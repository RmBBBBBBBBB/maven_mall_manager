package com.heigo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heigo.bean.T_MALL_PRODUCT;
import com.heigo.mapper.SpuMapper;

@Service
public class SpuServiceImpl implements SpuServiceInf {

	@Autowired
	SpuMapper spuMapper;

	public int spu_publish(T_MALL_PRODUCT spu, List<String> upload_img_name) {
		// 将上传的第一张图片设置为头图
		spu.setShp_tp(upload_img_name.get(0));

		// 插入商品信息
		int i = spuMapper.insert_product(spu);

		// 根据商品表生成的id，批量插入商品图片
		int j = spuMapper.insert_product_images(spu.getId(), upload_img_name);
		return j;
	}

}
