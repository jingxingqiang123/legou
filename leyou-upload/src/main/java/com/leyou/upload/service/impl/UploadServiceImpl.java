package com.leyou.upload.service.impl;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.upload.service.UploadService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 图片上传
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private FastFileStorageClient storageClient;

    private static final Logger log = LoggerFactory.getLogger(UploadServiceImpl.class);

    /**
     * 支持的图片类型 白名单
     */
    private static final List<String> CONTENT_TYPE = Arrays.asList("image/gif", "image/jpeg", "image/png", "application/x-jpg");


    /**
     * 图片上传
     *
     * @param file
     * @return
     */
    @Override
    public String uploadImage(MultipartFile file) {

        String originalFilename = file.getOriginalFilename();
        // 图片类型校验
        String contentType = file.getContentType();
        if (!CONTENT_TYPE.contains(contentType)) {
            // 文件类型不合法，直接返回null
            log.info("文件类型不合法：{}", originalFilename);
            return null;
        }
        // 图片内容校验
        try {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage == null || bufferedImage.getWidth() <= 0 || bufferedImage.getWidth() <= 0) {
                log.error("文件内容不合法： {}", originalFilename);
                return null;
            }
            // 文件名生成随机数

            // 保存服务器
            // File fliePath = new File("D:\\leyou\\image\\" + originalFilename);
            //file.transferTo(fliePath);
            String ext = StringUtils.substringAfterLast(originalFilename, ".");
            StorePath storePath = this.storageClient.uploadFile(
                    file.getInputStream(),
                    file.getSize(),
                    ext,
                    null);
            // 返回url
            return "http://image.leyou.com/" + storePath.getFullPath();
        } catch (IOException e) {
            log.error("服务器内部错误", e);
        }

        return null;
    }
}
