package com.heigo.service;

import java.util.List;

import com.heigo.bean.T_MALL_ATTR;

public interface AttrServiceInf {
	
	public List<T_MALL_ATTR> get_attr_list_by_class_2_id(Integer class_2_id);

	public void add_attr(List<T_MALL_ATTR> list_attr, int class_2_id);

}
