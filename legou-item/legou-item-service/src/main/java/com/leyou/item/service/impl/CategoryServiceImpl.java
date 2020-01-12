package com.leyou.item.service.impl;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
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
     *
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

    /**
     * 根据品牌id查询分类
     *
     * @param bid
     * @return
     */
    @Override
    public List<Category> queryByBrandId(Long bid) {

        return this.categoryMapper.queryByBrandId(bid);
    }

    @Override
    public void saveCategory(Category category) {
        /**
         * 将本节点插入到数据库中
         * 将此category的父节点的isParent设为true
         */

        // 1、首先设置id为null
        category.setId(null);
        // 2、保存
        this.categoryMapper.insert(category);
        // 3、修改父节点
        Category parent = new Category();
        parent.setId(category.getParentId());
        parent.setIsParent(true);
        this.categoryMapper.updateByPrimaryKeySelective(parent);


    }
}
