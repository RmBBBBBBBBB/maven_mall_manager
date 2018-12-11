package com.heigo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heigo.bean.T_MALL_PRODUCT;

public interface SpuMapper {

	public int insert_product(T_MALL_PRODUCT spu);

	int insert_product_images(@Param("id") int id, @Param("upload_img_name") List<String> upload_img_name);
	
}
