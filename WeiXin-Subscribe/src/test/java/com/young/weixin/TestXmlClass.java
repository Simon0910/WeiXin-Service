package com.young.weixin;

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
	}
}
