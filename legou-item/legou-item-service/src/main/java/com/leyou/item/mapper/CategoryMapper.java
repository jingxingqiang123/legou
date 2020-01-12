package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 继承通用mampper,定义商品分类泛型
 */
public interface CategoryMapper extends Mapper<Category> {
    /**
     * 通过品牌id,在分类品牌中间表中查询分类id
     * 再通过分类id,在分类表中查询所有的分类信息
     * @param bid
     * @return
     */
    @Select("SELECT * FROM tb_category WHERE id IN (SElECT category_id FROM tb_category_brand WHERE brand_id = #{bid})")
    List<Category> queryByBrandId(Long bid);
}
