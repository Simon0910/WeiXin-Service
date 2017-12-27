package com.young.weixin;

import com.young.weixin.common.util.XMLUtil;
import com.young.weixin.subscribe.pojo.CustomMenuEventPojo;

public class TestXmlClass {
	private static String xmlString = 
			"<xml>"
			+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
			+ "<FromUserName><![CDATA[FromUser]]></FromUserName>"
			+ "<CreateTime>123456789</CreateTime>"
			+ "<MsgType><![CDATA[event]]></MsgType>"
			+ "<Event><![CDATA[CLICK]]></Event>"
			+ "<EventKey><![CDATA[EVENTKEY]]></EventKey>"
			+ "</xml>";
	
	public static void main(String[] args) {
		CustomMenuEventPojo pojo = XMLUtil.convertXmlStrToObject(CustomMenuEventPojo.class, xmlString);
		System.out.println(pojo);
	}
}
