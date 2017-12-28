package com.young.weixin.common.pojo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties( prefix = "weixin.config" ) 
public class WeiXinConfig {
	private String granttype ;
	private String appid ;
	private String secret ;
	public String getGranttype() {
		return granttype;
	}
	public void setGranttype(String granttype) {
		this.granttype = granttype;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}

	private final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
	public String getAccessToken() {
		String res = "";
		try {
			CloseableHttpClient client = HttpClients.custom().build();
			HttpGet httpGet = new HttpGet(ACCESS_TOKEN_URL.concat("?grant_type=" + getGranttype()
					+ "&appid=" + getAppid() + "&secret=" + getSecret()));
			CloseableHttpResponse resp1;
			resp1 = client.execute(httpGet);
			res = EntityUtils.toString(resp1.getEntity());
			System.out.println(res);
		} catch (Exception e) {
			
		}
		return res;
	}
	
	@Override
	public String toString() {
		return "WeiXinConfig [granttype=" + granttype + ", appid=" + appid + ", secret=" + secret + "]";
	}
	
}
