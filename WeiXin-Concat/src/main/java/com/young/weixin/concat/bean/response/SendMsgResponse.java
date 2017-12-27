/**
 * 
 */
package com.young.weixin.concat.bean.response;

import java.io.IOException;
import java.io.StringWriter;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Name SendMsgResponse
 * @Description 
 *    {"BaseResponse": {"Ret": 0, "ErrMsg": "" },"MsgID": "7124038491073501627","LocalID": "15131533158820189"}
 * @Author YangZhan
 * @Date 2017年12月13日 下午4:40:30
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class SendMsgResponse {
	private BaseResponse BaseResponse;
	private String MsgID;
	private String LocalID;

	public SendMsgResponse(String jsonStr){
		try {
			JSONObject obj = new JSONObject(jsonStr);
			this.BaseResponse = new BaseResponse((JSONObject)obj.get("BaseResponse"));
			this.MsgID = obj.getString("MsgID");
			this.LocalID = obj.getString("LocalID");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public BaseResponse getBaseResponse() {
		return BaseResponse;
	}
	public void setBaseResponse(BaseResponse baseResponse) {
		BaseResponse = baseResponse;
	}
	public String getMsgID() {
		return MsgID;
	}
	public void setMsgID(String msgID) {
		MsgID = msgID;
	}
	public String getLocalID() {
		return LocalID;
	}
	public void setLocalID(String localID) {
		LocalID = localID;
	}
	@Override
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
