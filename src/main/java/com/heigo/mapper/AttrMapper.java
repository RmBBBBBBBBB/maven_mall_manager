package com.heigo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heigo.bean.T_MALL_ATTR;

public interface AttrMapper {

	List<T_MALL_ATTR> select_attr_value_list(@Param("class_2_id")Integer class_2_id);

	void insert_attr(T_MALL_ATTR t_MALL_ATTR);

	void insert_values(HashMap<String, Object> hashMap);

	
}
