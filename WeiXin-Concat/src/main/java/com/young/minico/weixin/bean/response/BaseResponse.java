/**
 * 
 */
package com.young.minico.weixin.bean.response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @Name BaseResponse
 * @Description 
 *    TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月12日 下午5:58:09
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class BaseResponse {
	private Integer Ret;
	private String ErrMsg;

	public BaseResponse()
	{
	}
	public BaseResponse(String BaseResponseStr) throws JSONException
	{
		this(new JSONObject(BaseResponseStr));
	}
	public BaseResponse(JSONObject BaseResponseObject) throws JSONException
	{
		setRet(BaseResponseObject.getInt("Ret"));
		setErrMsg(BaseResponseObject.getString("ErrMsg"));
	}
	public Integer getRet() {
		return Ret;
	}
	public void setRet(Integer ret) {
		Ret = ret;
	}
	public String getErrMsg() {
		return ErrMsg;
	}
	public void setErrMsg(String errMsg) {
		ErrMsg = errMsg;
	}
	
}
