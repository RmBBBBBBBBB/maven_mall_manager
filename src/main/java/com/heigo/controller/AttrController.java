package com.heigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.heigo.bean.MODEL_T_MALL_ATTR;
import com.heigo.bean.T_MALL_ATTR;
import com.heigo.bean.T_MALL_VALUE;
import com.heigo.service.AttrServiceImpl;

@Controller
public class AttrController {
	
	@Autowired
	AttrServiceImpl attrServiceImpl;
		
	/**
	 * 提交分类属性值，属性明 table 表格，然后重定向到 分类属性页面
	 * @param list_attr
	 * @param class_2_id
	 * @param class_2_value
	 * @return
	 */
	@RequestMapping("add_attr")
	public ModelAndView add_attr(MODEL_T_MALL_ATTR list_attr,int class_2_id,String class_2_name){
		
		attrServiceImpl.add_attr(list_attr.getList_attr(),class_2_id);
		
		//以 modelandview 形式 重定向 链接，则不会乱码
		ModelAndView mv = new ModelAndView("redirect:/goto_add_attr/{class_2_id}/{class_2_name}.do");
		mv.addObject("class_2_id", class_2_id);
		mv.addObject("class_2_name", class_2_name);

		return mv;
		//重定向到goto_add_attr 请求，
		//return "redirect:goto_add_attr/"+class_2_id+"/"+class_2_value+".do";
	}
	
	/**
	 * 跳转到  添加分类属性页面
	 * @param map
	 * @param class_2_id
	 * @param class_2_name
	 * @return
	 */
	@RequestMapping("goto_add_attr/{class_2_id}/{class_2_name}")
	public String goto_add_attr(ModelMap map,@PathVariable String class_2_id,@PathVariable String class_2_name){
		
		return "manager_add_attr";
	}
	
	/**
	 * 显示分类属性值-属性等的内嵌页
	 * @param class_2_id
	 * @param map
	 * @return
	 */
	@RequestMapping("get_attr_list_by_class_2_id")
	public String get_attr_list_by_class_2_id(int class_2_id,ModelMap map){
		List<T_MALL_ATTR> list_attr_value = attrServiceImpl.get_attr_list_by_class_2_id(class_2_id);
		map.put("list_attr_value", list_attr_value);
		return "manager_attr_publish_inner";
	}
	
	/**
	 * 跳转到manager_attr_publish 页面
	 * @param map
	 * @param success
	 * @return
	 */
	@RequestMapping("goto_attr_publish/{success}")
	public String goto_attr_publish(ModelMap map,@PathVariable String success){
		
		map.put("success", success);
		
		return "manager_attr_publish";
	}

}
