package com.tech.legou.item.service.impl;

import com.tech.legou.item.mapper.CategoryMapper;
import com.tech.legou.item.pojo.Category;
import com.tech.legou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类service
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 根据父节点的id,查询子节点
     * @param pid
     * @return
     */
    @Override
    public List<Category> queryCategoriesByParentId(Long pid) {
        // 有条件并且返回集合
        Category record = new Category();
        record.setParentId(pid);
       return this.categoryMapper.select(record);
    }
}
