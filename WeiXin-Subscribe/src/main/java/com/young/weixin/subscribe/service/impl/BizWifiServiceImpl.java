package com.young.weixin.subscribe.service.impl;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.young.weixin.subscribe.service.BizWifiService;

public class BizWifiServiceImpl implements BizWifiService
{
//	private static String BIZWIFI_OPEN = "https://api.weixin.qq.com/bizwifi/openplugin/token?access_token=";
	
	protected CloseableHttpClient  client = HttpClients.custom().build();
	public String getLoginCode() throws Exception 
	{
//		String AccessToken = "";
//		HttpGet httpGet = new HttpGet(BIZWIFI_OPEN.concat(AccessToken));
//		CloseableHttpResponse resp1 = client.execute(httpGet);
//		String res = EntityUtils.toString(resp1.getEntity()); 
//			List<NameValuePair> params = Lists.newArrayList();
//			params.add(new BasicNameValuePair("appid",""));
//		String queryStr = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
		return null;
	}
}
