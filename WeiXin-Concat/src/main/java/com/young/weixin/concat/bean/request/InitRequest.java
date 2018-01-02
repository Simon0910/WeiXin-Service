/**
 * 
 */
package com.young.weixin.concat.bean.request;

import java.io.IOException;
import java.io.StringWriter;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InitRequest {
	private BaseRequest BaseRequest;
	public InitRequest()
	{
		
	}
	public InitRequest(BaseRequest baseRequest)
	{
		setBaseRequest(baseRequest);
	}
	public BaseRequest getBaseRequest() {
		return BaseRequest;
	}
	public void setBaseRequest(BaseRequest baseRequest) {
		BaseRequest = baseRequest;
	}
	@Override
	public String toString() {
        JSONObject body = new JSONObject();
        try {
			body.put("BaseRequest", BaseRequest.toJsonObject());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return body.toString();
	}
}
