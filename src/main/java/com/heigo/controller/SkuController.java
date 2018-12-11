package com.heigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heigo.bean.T_MALL_ATTR;
import com.heigo.bean.T_MALL_PRODUCT;
import com.heigo.service.AttrServiceImpl;
import com.heigo.service.SkuServiceImpl;

@Controller
public class SkuController {
	
	@Autowired
	SkuServiceImpl skuService;
	
	@Autowired
	AttrServiceImpl attrServiceImp;
	
	@RequestMapping("sku_get_attr_list_by_class_2_id")
	public String sku_get_attr_list_by_class_2_id(int class_2_id,ModelMap map){
		// 根据二级分类id查询对应的分类属性集合
		List<T_MALL_ATTR> list_attr_value = attrServiceImp.get_attr_list_by_class_2_id(class_2_id);
		map.put("list_attr_value", list_attr_value);
		return "manager_sku_publish_inner";
		
	}
	
	/**
	 * 通过 品牌id 分类属性1 分类属性2 查询 对应的 商品
	 * @param class_1_id
	 * @param class_2_id
	 * @param pp_id
	 * @return
	 */
	@RequestMapping("get_spu_by_ppid_class2id")
	public List<T_MALL_PRODUCT> get_spu_by_ppid_class2id(int class_1_id,int class_2_id,int pp_id){
		List<T_MALL_PRODUCT> list_product = skuService.get_spu_by_ppid_class2id(class_1_id, class_2_id, pp_id);
		return list_product;
		
	}
	
	/**
	 * 跳转到sku 发布页面
	 * @param success
	 * @param map
	 * @return
	 */
	@RequestMapping("goto_sku_publish")
	public String goto_sku_publish(ModelMap map){
		
		return "manager_sku_publish";
	}
	
}
