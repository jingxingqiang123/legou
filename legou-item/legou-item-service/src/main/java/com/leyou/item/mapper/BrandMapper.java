package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMapper extends Mapper<Brand> {
//    /**
//     * 新增商品分类和商品的中间表
//     *
//     * @param cids 商品分类id
//     * @param bid 商品品牌id
//     */
//    @Insert("INSERT INTO tb_category_brand(category_id,brand_id) values(#{cid},#{bid}) in" +
//            "<foreach  item=\"cid\" index=\"index\" collection=\"cids\"  open=\"(\" separator=\",\" close=\")\">>" +
//            "(#{cid,#{bid})  </foreach>")
//    void insertCategoryAndBrand(@Param("cids") Long[] cids, @Param("bid") Long bid);
//

    /**
     * 新增商品分类和商品的中间表
     *
     * @param cid 商品分类id
     * @param bid 商品品牌id
     */
    @Insert("INSERT INTO tb_category_brand (category_id, brand_id) VALUES (#{cid},#{bid})")
    void insertCategoryAndBrand(@Param("cid") Long cid, @Param("bid") Long bid);
}
