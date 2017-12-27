package com.young.weixin.subscribe.service.impl;

import com.young.weixin.subscribe.pojo.menu.CustomMenuPojo;
import com.young.weixin.subscribe.pojo.menu.IndividuationMenuPojo;
import com.young.weixin.subscribe.service.CustomMenuService;

public class CustomMenuServiceImpl implements CustomMenuService {
	public static final String CUSTOM_MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create";
	public static final String CUSTOM_MENU_QUERY  = "https://api.weixin.qq.com/cgi-bin/menu/get";
	public static final String CUSTOM_MENU_DELETE = "https://api.weixin.qq.com/cgi-bin/menu/delete";
	public static final String INDIVIDUATION_MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/addconditional";
	public static final String INDIVIDUATION_MENU_TRY_MATCH = "https://api.weixin.qq.com/cgi-bin/menu/trymatch";
	public static final String INDIVIDUATION_MENU_DELETE = "https://api.weixin.qq.com/cgi-bin/menu/delconditional";

	@Override
	public void customMenuCreate(CustomMenuPojo pojo) 
	{
	}
	@Override
	public void customMenuQuery() 
	{
	}
	@Override
	public void customMenuDelete(String menuId) {
		
	}
	@Override
	public void customMenuCurrent() {
		
	}

	@Override
	public void individuationMenuCreate(IndividuationMenuPojo pojo) 
	{
	}
	@Override
	public void individuationMenuTryMatch(String user_id) 
	{
	}
	@Override
	public void individuationMenuDelete(String menuId) 
	{
	}
}
