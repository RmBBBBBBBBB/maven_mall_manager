package com.heigo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heigo.bean.T_MALL_PRODUCT;
import com.heigo.mapper.SkuMapper;
import com.heigo.mapper.TestMapper;

@Service
public class SkuServiceImpl implements SkuServiceInf {

	@Autowired
	SkuMapper skuMapper;

	public List<T_MALL_PRODUCT> get_spu_by_ppid_class2id(int class_1_id, int class_2_id, int pp_id) {
		Map map = new HashMap<>();
		map.put("class_1_id", class_1_id);
		map.put("class_2_id", class_2_id);
		map.put("pp_id", pp_id);
		
		List<T_MALL_PRODUCT> T_MALL_PRODUCT_list = skuMapper.select_spu_by_ppid_class2id(map);
		return T_MALL_PRODUCT_list;
	}
	
	
}
