package com.young.weixin.common.pojo;

//@ConfigurationProperties(prefix = "WeiXinConfig")
public class WeiXinConfig {
	private String grantType = "client_credential";
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
