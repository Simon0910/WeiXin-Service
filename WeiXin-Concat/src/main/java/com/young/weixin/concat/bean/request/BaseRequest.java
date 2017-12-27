/**
 * 
 */
package com.young.weixin.concat.bean.request;

/**
 * @Name BaseRequest
 * @Description 
 *    {"Uin":904152460,
 *    "Sid":"k09i42K85ZSZoL+y",
 *    "Skey":"@crypt_cd188f5a_5ebcc287e1c49f26edc3156e12da3acd",
 *    "DeviceID":"e192464458232262"
 *    }
 * @Author YangZhan
 * @Date 2017年12月13日 下午4:29:45
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class BaseRequest {
	private String Uin;
	private String Sid;
	private String Skey;
	private String DeviceID;
	public String getUin() {
		return Uin;
	}
	public void setUin(String uin) {
		Uin = uin;
	}
	public String getSid() {
		return Sid;
	}
	public void setSid(String sid) {
		Sid = sid;
	}
	public String getSkey() {
		return Skey;
	}
	public void setSkey(String skey) {
		Skey = skey;
	}
	public String getDeviceID() {
		return DeviceID;
	}
	public void setDeviceID(String deviceID) {
		DeviceID = deviceID;
	}
}
