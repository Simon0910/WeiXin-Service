package com.young.weixin.common.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value="weixin.config")
public class WeiXinConfig {
	private String grantType ;
	private String appID ;
	private String secret ;
	public String getGrantType() {
		return grantType;
	}
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	public String getAppID() {
		return appID;
	}
	public void setAppID(String appID) {
		this.appID = appID;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
}
