package com.young.weixin.subscribe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	Logger logger = LoggerFactory.getLogger(TestController.class);
	@RequestMapping("test")
	public String test() 
	{
		logger.info("testddddddddddddddddddddd");
		return "ok";
	}
}
