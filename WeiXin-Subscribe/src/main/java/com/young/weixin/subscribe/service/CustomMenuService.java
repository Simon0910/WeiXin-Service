package com.young.weixin.subscribe.service;

public class CustomMenuService {
	public static final String CUSTOM_MENU_CREAT = "https://api.weixin.qq.com/cgi-bin/menu/create";
	public static final String CUSTOM_MENU_QUERY = "https://api.weixin.qq.com/cgi-bin/menu/get";
	public static final String CUSTOM_MENU_DELETE = "https://api.weixin.qq.com/cgi-bin/menu/delete";
	
	public void create() {
		//access_token=ACCESS_TOKEN
		
//		button	是	一级菜单数组，个数应为1~3个
//		sub_button	否	二级菜单数组，个数应为1~5个
//		type	是	菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
//		name	是	菜单标题，不超过16个字节，子菜单不超过60个字节
//		key	click等点击类型必须	菜单KEY值，用于消息接口推送，不超过128字节
//		url	view、miniprogram类型必须	网页 链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，不支持小程序的老版本客户端将打开本url。
//		media_id	media_id类型和view_limited类型必须	调用新增永久素材接口返回的合法media_id
//		appid	miniprogram类型必须	小程序的appid（仅认证公众号可配置）
//		pagepath	miniprogram类型必须	小程序的页面路径
	}
	public void query() {
	}
}
