package com.leyou.item.service;

import com.leyou.item.pojo.Brand;
import com.leyou.common.vo.PageResult;

import java.util.List;

public interface BrandService {

    PageResult<Brand> queryBrandByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);
    void saveBrand(Brand brand, List<Long> cids);

    /**
     * 修改brand，并且维护中间表
     * @param brand
     * @param cids
     */
    void updateBrand(Brand brand, List<Long> cids);
}
