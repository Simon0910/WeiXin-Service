/**
 * 
 */
package com.young.weixin.concat.bean.response;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.young.weixin.concat.bean.Concat;
import com.young.weixin.concat.bean.UserInfo;

/**
 * @Name InitResponse
 * @Description 
 *    TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月13日 下午5:21:56
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class InitResponse {
	private BaseResponse BaseResponse;
	private Integer Count;
	private List<Concat> ContactList;
	private String  SyncKey; 
	private UserInfo User;
	private String  ChatSet;
	private String  SKey; 
	private Integer ClientVersion;
	private Integer SystemTime;
	private Integer GrayScale;
	private Integer InviteStartCount;
	private Integer MPSubscribeMsgCount; 
	private String MPSubscribeMsgList;
	private Integer ClickReportInterval;
	public InitResponse(){
		
	}
	public InitResponse(String initJson) throws JSONException{
		this(new JSONObject(initJson));
	}
	public InitResponse(JSONObject initObject) throws JSONException{
		setBaseResponse       (new BaseResponse((JSONObject)initObject.get("BaseResponse")));
		setCount              (initObject.getInt   ("Count"              ));
		setContactList        (Concat.concatList((JSONArray)initObject.get("ContactList"        )));
		setSyncKey            (initObject.getString   ("SyncKey"            ));
		setUser               (new UserInfo((JSONObject)initObject.get("User")));
		setChatSet            (initObject.getString("ChatSet"            ));
		setSKey               (initObject.getString("SKey"               ));
		setClientVersion      (initObject.getInt   ("ClientVersion"      ));
		setSystemTime         (initObject.getInt   ("SystemTime"         ));
		setGrayScale          (initObject.getInt   ("GrayScale"          ));
		setInviteStartCount   (initObject.getInt   ("InviteStartCount"   ));
		setMPSubscribeMsgCount(initObject.getInt   ("MPSubscribeMsgCount"));
		setMPSubscribeMsgList (initObject.getString("MPSubscribeMsgList" ));
		setClickReportInterval(initObject.getInt   ("ClickReportInterval"));
	}
	public BaseResponse getBaseResponse() {
		return BaseResponse;
	}
	public void setBaseResponse(BaseResponse baseResponse) {
		BaseResponse = baseResponse;
	}
	public Integer getCount() {
		return Count;
	}
	public void setCount(Integer count) {
		Count = count;
	}
	public List<Concat> getContactList() {
		return ContactList;
	}
	public void setContactList(List<Concat> contactList) {
		ContactList = contactList;
	}
	public String getSyncKey() {
		return SyncKey;
	}
	public void setSyncKey(String syncKey) {
		SyncKey = syncKey;
	}
	public UserInfo getUser() {
		return User;
	}
	public void setUser(UserInfo user) {
		User = user;
	}
	public String getChatSet() {
		return ChatSet;
	}
	public void setChatSet(String chatSet) {
		ChatSet = chatSet;
	}
	public String getSKey() {
		return SKey;
	}
	public void setSKey(String sKey) {
		SKey = sKey;
	}
	public Integer getClientVersion() {
		return ClientVersion;
	}
	public void setClientVersion(Integer clientVersion) {
		ClientVersion = clientVersion;
	}
	public Integer getSystemTime() {
		return SystemTime;
	}
	public void setSystemTime(Integer systemTime) {
		SystemTime = systemTime;
	}
	public Integer getGrayScale() {
		return GrayScale;
	}
	public void setGrayScale(Integer grayScale) {
		GrayScale = grayScale;
	}
	public Integer getInviteStartCount() {
		return InviteStartCount;
	}
	public void setInviteStartCount(Integer inviteStartCount) {
		InviteStartCount = inviteStartCount;
	}
	public Integer getMPSubscribeMsgCount() {
		return MPSubscribeMsgCount;
	}
	public void setMPSubscribeMsgCount(Integer mPSubscribeMsgCount) {
		MPSubscribeMsgCount = mPSubscribeMsgCount;
	}
	public String getMPSubscribeMsgList() {
		return MPSubscribeMsgList;
	}
	public void setMPSubscribeMsgList(String mPSubscribeMsgList) {
		MPSubscribeMsgList = mPSubscribeMsgList;
	}
	public Integer getClickReportInterval() {
		return ClickReportInterval;
	}
	public void setClickReportInterval(Integer clickReportInterval) {
		ClickReportInterval = clickReportInterval;
	}

	@Override
	public String toString() {
		StringWriter str = new StringWriter();  
        try {
            ObjectMapper mapper = new ObjectMapper();  
			mapper.writeValue(str, this);
		} catch (IOException e) {
		}  
        return str.toString();
	}
}
