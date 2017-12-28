package com.young.weixin.common.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.young.weixin.common.pojo.WeiXinConfig;
@Component
public class AccessTokenService {
	@Autowired
	WeiXinConfig weiXinConfig;
	private final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
	public String getAccessToken() {
		System.out.println(weiXinConfig);
		String res = "";
		try {
			CloseableHttpClient client = HttpClients.custom().build();
			HttpGet httpGet = new HttpGet(ACCESS_TOKEN_URL.concat("?granttype=" + weiXinConfig.getGranttype()
					+ "&appid=" + weiXinConfig.getAppid() + "&secret=" + weiXinConfig.getSecret()));
			CloseableHttpResponse resp1;
			resp1 = client.execute(httpGet);
			res = EntityUtils.toString(resp1.getEntity());
			System.out.println(res);
		} catch (Exception e) {
		}
		return res;
	}
}
