/**
 * 
 */
package com.young.minico.weixin.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @Name UserInfo
 * @Description 
 *    TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月13日 下午5:29:08
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class UserInfo {
	private String Uin              ;  
	private String UserName         ;  
	private String NickName         ;  
	private String HeadImgUrl       ;  
	private String RemarkName       ;  
	private String PYInitial        ;  
	private String PYQuanPin        ;  
	private String RemarkPYInitial  ;  
	private String RemarkPYQuanPin  ;  
	private String HideInputBarFlag ;  
	private String StarFriend       ;  
	private String Sex              ;  
	private String Signature        ;  
	private String AppAccountFlag   ;  
	private String VerifyFlag       ;  
	private String ContactFlag      ;  
	private String WebWxPluginSwitch;  
	private String HeadImgFlag      ;  
	private String SnsFlag          ;
	public UserInfo()
	{
		
	}
	public UserInfo(String userJson) throws JSONException
	{
		this(new JSONObject(userJson));
	}
	
	public UserInfo(JSONObject userObject) throws JSONException
	{
		setUin              (userObject.getString("Uin"              ));
		setUserName         (userObject.getString("UserName"         ));
		setNickName         (userObject.getString("NickName"         ));
		setHeadImgUrl       (userObject.getString("HeadImgUrl"       ));
		setRemarkName       (userObject.getString("RemarkName"       ));
		setPYInitial        (userObject.getString("PYInitial"        ));
		setPYQuanPin        (userObject.getString("PYQuanPin"        ));
		setRemarkPYInitial  (userObject.getString("RemarkPYInitial"  ));
		setRemarkPYQuanPin  (userObject.getString("RemarkPYQuanPin"  ));
		setHideInputBarFlag (userObject.getString("HideInputBarFlag" ));
		setStarFriend       (userObject.getString("StarFriend"       ));
		setSex              (userObject.getString("Sex"              ));
		setSignature        (userObject.getString("Signature"        ));
		setAppAccountFlag   (userObject.getString("AppAccountFlag"   ));
		setVerifyFlag       (userObject.getString("VerifyFlag"       ));
		setContactFlag      (userObject.getString("ContactFlag"      ));
		setWebWxPluginSwitch(userObject.getString("WebWxPluginSwitch"));
		setHeadImgFlag      (userObject.getString("HeadImgFlag"      ));
		setSnsFlag          (userObject.getString("SnsFlag"          ));
	}
	 
	public String getUin() {
		return Uin;
	}
	public void setUin(String uin) {
		Uin = uin;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getHeadImgUrl() {
		return HeadImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		HeadImgUrl = headImgUrl;
	}
	public String getRemarkName() {
		return RemarkName;
	}
	public void setRemarkName(String remarkName) {
		RemarkName = remarkName;
	}
	public String getPYInitial() {
		return PYInitial;
	}
	public void setPYInitial(String pYInitial) {
		PYInitial = pYInitial;
	}
	public String getPYQuanPin() {
		return PYQuanPin;
	}
	public void setPYQuanPin(String pYQuanPin) {
		PYQuanPin = pYQuanPin;
	}
	public String getRemarkPYInitial() {
		return RemarkPYInitial;
	}
	public void setRemarkPYInitial(String remarkPYInitial) {
		RemarkPYInitial = remarkPYInitial;
	}
	public String getRemarkPYQuanPin() {
		return RemarkPYQuanPin;
	}
	public void setRemarkPYQuanPin(String remarkPYQuanPin) {
		RemarkPYQuanPin = remarkPYQuanPin;
	}
	public String getHideInputBarFlag() {
		return HideInputBarFlag;
	}
	public void setHideInputBarFlag(String hideInputBarFlag) {
		HideInputBarFlag = hideInputBarFlag;
	}
	public String getStarFriend() {
		return StarFriend;
	}
	public void setStarFriend(String starFriend) {
		StarFriend = starFriend;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getSignature() {
		return Signature;
	}
	public void setSignature(String signature) {
		Signature = signature;
	}
	public String getAppAccountFlag() {
		return AppAccountFlag;
	}
	public void setAppAccountFlag(String appAccountFlag) {
		AppAccountFlag = appAccountFlag;
	}
	public String getVerifyFlag() {
		return VerifyFlag;
	}
	public void setVerifyFlag(String verifyFlag) {
		VerifyFlag = verifyFlag;
	}
	public String getContactFlag() {
		return ContactFlag;
	}
	public void setContactFlag(String contactFlag) {
		ContactFlag = contactFlag;
	}
	public String getWebWxPluginSwitch() {
		return WebWxPluginSwitch;
	}
	public void setWebWxPluginSwitch(String webWxPluginSwitch) {
		WebWxPluginSwitch = webWxPluginSwitch;
	}
	public String getHeadImgFlag() {
		return HeadImgFlag;
	}
	public void setHeadImgFlag(String headImgFlag) {
		HeadImgFlag = headImgFlag;
	}
	public String getSnsFlag() {
		return SnsFlag;
	}
	public void setSnsFlag(String snsFlag) {
		SnsFlag = snsFlag;
	}
}
