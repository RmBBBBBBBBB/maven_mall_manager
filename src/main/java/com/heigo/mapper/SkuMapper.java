package com.heigo.mapper;

import java.util.List;
import java.util.Map;

import com.heigo.bean.T_MALL_PRODUCT;

public interface SkuMapper {

	List<T_MALL_PRODUCT> select_spu_by_ppid_class2id(Map map);


}
