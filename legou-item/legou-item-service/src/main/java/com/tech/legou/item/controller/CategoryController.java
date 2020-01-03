package com.tech.legou.item.controller;

import com.tech.legou.item.pojo.Category;
import com.tech.legou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jingxingqiang on 2020/1/1 23:29
 */
//http://api.leyou.com/api/item/category/list?pid=0
@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父节点的id,查询子节点
     * @param pid 父节点的id
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByParentId(@RequestParam(value = "pid", defaultValue = "0") Long pid) {
        // 判断long型的pid是否为空或者小于0
        if (pid == null || pid < 0) {
            // 400 参数不合法
            // return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return ResponseEntity.badRequest().build();
        }
        List<Category>categories = this.categoryService.queryCategoriesByParentId(pid);
        // 判断集合是否为空
        if (CollectionUtils.isEmpty(categories)){
            // 404 资源服务器为资源服务器未找到
           // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.notFound().build();
        }
        // 200 查询成功
        return ResponseEntity.ok(categories);
    }
}
