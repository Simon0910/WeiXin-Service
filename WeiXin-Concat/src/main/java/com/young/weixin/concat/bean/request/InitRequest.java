/**
 * 
 */
package com.young.weixin.concat.bean.request;

import java.io.IOException;
import java.io.StringWriter;

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
		StringWriter str = new StringWriter();  
        ObjectMapper mapper = new ObjectMapper();  
        try {
			mapper.writeValue(str, this);
		} catch (IOException e) {
		}  
        return str.toString();
	}
}
