package com.tech.legou.item.service;

import com.tech.legou.item.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> queryCategoriesByParentId(Long pid);
}
