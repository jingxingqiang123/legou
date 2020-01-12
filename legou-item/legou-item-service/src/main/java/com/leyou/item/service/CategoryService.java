package com.leyou.item.service;

import com.leyou.item.pojo.Category;

import java.util.List;

public interface CategoryService {

    List<Category> queryCategoriesByParentId(Long pid);

    /**
     * 根据brand id查询分类信息
     *
     * @param bid
     * @return
     */
    List<Category> queryByBrandId(Long bid);


    /**
     * 保存
     *
     * @param category
     */
    void saveCategory(Category category);
}
