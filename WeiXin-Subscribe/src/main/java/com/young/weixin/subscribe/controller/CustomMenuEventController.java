package com.young.weixin.subscribe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.young.weixin.common.util.XMLParser;

@RestController
@RequestMapping("/Menu")
public class CustomMenuEventController 
{
	@RequestMapping("/Callback")
	public void callback(String xmlString)
	{
		CustomMenuEventController pojo = XMLParser.convertXmlStrToObject(CustomMenuEventController.class, xmlString);
		System.out.println(pojo);
	}
	
	
}