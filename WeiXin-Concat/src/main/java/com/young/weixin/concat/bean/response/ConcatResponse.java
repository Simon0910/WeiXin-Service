/**
 * 
 */
package com.young.weixin.concat.bean.response;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.young.weixin.concat.bean.Concat;

/**
 * @Name Request
 * @Description 
 *    TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月12日 下午5:56:40
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class ConcatResponse 
{
	private BaseResponse BaseResponse;
	private Integer MemberCount;
	private List<Concat> MemberList;
	private Integer Seq;
	public ConcatResponse()
	{
		
	}
	public ConcatResponse(String jsonStr){
		try {
			JSONObject obj = new JSONObject(jsonStr);
			this.BaseResponse = new BaseResponse((JSONObject)obj.get("BaseResponse"));
			this.MemberCount = obj.getInt("MemberCount");
			this.MemberList = Concat.concatList((JSONArray)obj.get("MemberList"));
			this.Seq = obj.getInt("Seq");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public BaseResponse getBaseResponse() {
		return BaseResponse;
	}
	public void setBaseResponse(BaseResponse baseResponse) {
		this.BaseResponse = baseResponse;
	}
	public Integer getMemberCount() {
		return MemberCount;
	}
	public void setMemberCount(Integer memberCount) {
		this.MemberCount = memberCount;
	}
	public List<Concat> getMemberList() {
		return MemberList;
	}
	public void setMemberList(List<Concat> memberList) {
		this.MemberList = memberList;
	}
	public Integer getSeq() {
		return Seq;
	}
	public void setSeq(Integer seq) {
		this.Seq = seq;
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
