package com.young.weixin.concat.test;

import org.json.JSONObject;

public class TestJson {
	public static void main(String[] args) throws Exception{
		JSONObject obj = new JSONObject();
		obj.put("", new TestBean());
		System.out.println(obj);
	}
}
