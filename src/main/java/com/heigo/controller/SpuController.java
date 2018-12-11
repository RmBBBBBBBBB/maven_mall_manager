package com.heigo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.heigo.bean.T_MALL_PRODUCT;
import com.heigo.service.SpuServiceImpl;
import com.heigo.utils.MyUploadUtils;

@Controller
public class SpuController {

	@Autowired
	SpuServiceImpl spuService;
	
	@RequestMapping(value="spu_pubilsh",method=RequestMethod.POST)
	public String spu_publish(T_MALL_PRODUCT spu,@RequestParam("files") MultipartFile[] file){
		// 将图片上传到服务器指定位置
		List<String> upload_img_name = MyUploadUtils.upload_img_name(file);
		// 调用业务层的商品发布的增删改查
		int i = spuService.spu_publish(spu,upload_img_name);
		
		return "redirect:goto_spu_publish/gongxi.do";
	}
	
	@RequestMapping("goto_spu_publish/{success}")
	public String goto_spu_publish(@PathVariable String success,ModelMap map) {
		map.put("success", success);
		return "manager_spu_publish";
	}
}
