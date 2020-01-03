package com.tech.legou.item.mapper;

import com.tech.legou.item.pojo.Category;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 继承通用mampper,定义商品分类泛型
 */
public interface CategoryMapper extends Mapper<Category> {
}
