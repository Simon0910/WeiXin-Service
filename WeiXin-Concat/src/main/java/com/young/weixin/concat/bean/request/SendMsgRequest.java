/**
 * 
 */
package com.young.weixin.concat.bean.request;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.young.weixin.concat.bean.Message;

/**
 * @Name SendMsgRequest
 * @Description 
 *    {"BaseRequest":{"Uin":904152460,"Sid":"k09i42K85ZSZoL+y","Skey":"@crypt_cd188f5a_5ebcc287e1c49f26edc3156e12da3acd","DeviceID":"e192464458232262"},"Msg":{"Type":1,"Content":"x","FromUserName":"@da12a172423c4df17e3c71f815cacb8fc49872ab4df3eb6f652a7e6bfb95e74a","ToUserName":"filehelper","LocalID":"15131533158820189","ClientMsgId":"15131533158820189"},"Scene":0}
 * @Author YangZhan
 * @Date 2017年12月13日 下午4:30:02
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class SendMsgRequest {
	private BaseRequest BaseRequest;
	private Message Msg;
	private Integer Scene;
	public BaseRequest getBaseRequest() {
		return BaseRequest;
	}
	public void setBaseRequest(BaseRequest baseRequest) {
		BaseRequest = baseRequest;
	}
	public Message getMsg() {
		return Msg;
	}
	public void setMsg(Message msg) {
		Msg = msg;
	}
	public Integer getScene() {
		return Scene;
	}
	public void setScene(Integer scene) {
		Scene = scene;
	}
	public String toString() {
		StringWriter str = new StringWriter();  
        ObjectMapper mapper = new ObjectMapper();  
        try {
			mapper.writeValue(str, this);
		} catch (IOException e) {
		}  
        return str.toString();
	}
}
