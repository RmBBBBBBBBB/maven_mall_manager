package com.heigo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heigo.mapper.TestMapper;

@Service
public class IndexServiceImpl implements IndexServiceInf {

	@Autowired
	TestMapper testMapper;

	@Override
	public int testDb() {
		int select_test = testMapper.select_test();
		return select_test;
	}
	
	
}
