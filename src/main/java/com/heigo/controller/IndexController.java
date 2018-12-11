package com.heigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heigo.service.IndexServiceImpl;

@Controller
public class IndexController {
	
	@Autowired
	IndexServiceImpl indexService;

	@RequestMapping("index")
	public String index(){
		//int testDb = indexService.testDb();
		return "manager_index";
	}
}
