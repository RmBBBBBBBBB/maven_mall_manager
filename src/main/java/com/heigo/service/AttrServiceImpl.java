package com.heigo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heigo.bean.MODEL_T_MALL_ATTR;
import com.heigo.bean.T_MALL_ATTR;
import com.heigo.bean.T_MALL_VALUE;
import com.heigo.mapper.AttrMapper;

@Service
public class AttrServiceImpl implements AttrServiceInf{

	@Autowired
	AttrMapper attrMapper;

	@Override
	public List<T_MALL_ATTR> get_attr_list_by_class_2_id(Integer class_2_id) {
		List<T_MALL_ATTR> attr_value= attrMapper.select_attr_value_list(class_2_id);
		return attr_value;
	}
	
	@Override
	public void add_attr(List<T_MALL_ATTR> list_attr, int class_2_id) {
		
		for (int i = 0; i < list_attr.size(); i++) {
			T_MALL_ATTR t_MALL_ATTR = list_attr.get(i);
			t_MALL_ATTR.setFlbh2(class_2_id);
			attrMapper.insert_attr(t_MALL_ATTR);

			HashMap<String, Object> hashMap = new HashMap<String, Object>();

			hashMap.put("shxm_id", t_MALL_ATTR.getId());
			hashMap.put("class_2_id", class_2_id);
			hashMap.put("list_value", t_MALL_ATTR.getList_value());
			attrMapper.insert_values(hashMap);
		}
	}

	
}
