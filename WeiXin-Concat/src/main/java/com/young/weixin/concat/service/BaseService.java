/**
 * 
 */
package com.young.weixin.concat.service;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @Name BaseService
 * @Description 
 *    TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月14日 上午11:01:38
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class BaseService {
	public static CookieStore cookieStore = new BasicCookieStore();
	protected CloseableHttpClient client;
	public BaseService() 
	{
		CookieStore cs = cookieStore;
		client = HttpClients.custom().setDefaultCookieStore(cs).build();
			//client.wait(3000);
	
	}
}
