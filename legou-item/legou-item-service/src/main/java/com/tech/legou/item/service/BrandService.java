package com.tech.legou.item.service;

import com.leyou.common.vo.PageResult;
import com.tech.legou.item.pojo.Brand;

import java.util.List;

public interface BrandService {

    PageResult<Brand> queryBrandByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);
    void saveBrand(Brand brand, List<Long> cids);
}
