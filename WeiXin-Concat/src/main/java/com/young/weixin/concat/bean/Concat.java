/**
 * 
 */
package com.young.weixin.concat.bean;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @Name Concat
 * @Description TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月12日 下午5:51:54
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved.
 *             注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class Concat {
	private String Uin;
	private String UserName;
	private String NickName;
	private String HeadImgUrl;
	private Integer ContactFlag;
	private Integer MemberCount;
	private List<Concat> MemberList;
	private String RemarkName;
	private Integer HideInputBarFlag;
	private Integer Sex;
	private String Signature;
	private Integer VerifyFlag;
	private Integer OwnerUin;
	private String PYInitial;
	private String PYQuanPin;
	private String RemarkPYInitial;
	private String RemarkPYQuanPin;
	private Integer StarFriend;
	private Integer AppAccountFlag;
	private Integer Statues;
	private Integer AttrStatus;
	private String Province;
	private String City;
	private String Alias;
	private Integer SnsFlag;
	private Integer UniFriend;
	private String DisplayName;
	private Integer ChatRoomId;
	private String KeyWord;
	private String EncryChatRoomId;
	private Integer IsOwner;

	public Concat() {

	}

	public Concat(String jsonStr) throws JSONException {
		this(new JSONObject(jsonStr));
	}

	public static List<Concat> concatList(JSONArray concatArray) throws JSONException {
		List<Concat> list = new ArrayList<Concat>();
		for (int i = 0; i < concatArray.length(); i++) {
			list.add(new Concat((JSONObject) concatArray.getJSONObject(i)));
		}
		return list;
	}

	public Concat(JSONObject concatObject) throws JSONException {
		if (!concatObject.isNull("Uin"))
			setUin(concatObject.getString("Uin"));
		if (!concatObject.isNull("UserName"))
			setUserName(concatObject.getString("UserName"));
		if (!concatObject.isNull("NickName"))
			setNickName(concatObject.getString("NickName"));
		if (!concatObject.isNull("HeadImgUrl"))
			setHeadImgUrl(concatObject.getString("HeadImgUrl"));
		if (!concatObject.isNull("ContactFlag"))
			setContactFlag(concatObject.getInt("ContactFlag"));
		if (!concatObject.isNull("MemberCount"))
			setMemberCount(concatObject.getInt("MemberCount"));
		if (!concatObject.isNull("MemberList"))
			setMemberList(Concat.concatList((JSONArray) concatObject.get("MemberList")));
		if (!concatObject.isNull("RemarkName"))
			setRemarkName(concatObject.getString("RemarkName"));
		if (!concatObject.isNull("HideInputBarFlag"))
			setHideInputBarFlag(concatObject.getInt("HideInputBarFlag"));
		if (!concatObject.isNull("Sex"))
			setSex(concatObject.getInt("Sex"));
		if (!concatObject.isNull("Signature"))
			setSignature(concatObject.getString("Signature"));
		if (!concatObject.isNull("VerifyFlag"))
			setVerifyFlag(concatObject.getInt("VerifyFlag"));
		if (!concatObject.isNull("OwnerUin"))
			setOwnerUin(concatObject.getInt("OwnerUin"));
		if (!concatObject.isNull("PYInitial"))
			setPYInitial(concatObject.getString("PYInitial"));
		if (!concatObject.isNull("PYQuanPin"))
			setPYQuanPin(concatObject.getString("PYQuanPin"));
		if (!concatObject.isNull("RemarkPYInitial"))
			setRemarkPYInitial(concatObject.getString("RemarkPYInitial"));
		if (!concatObject.isNull("RemarkPYQuanPin"))
			setRemarkPYQuanPin(concatObject.getString("RemarkPYQuanPin"));
		if (!concatObject.isNull("StarFriend"))
			setStarFriend(concatObject.getInt("StarFriend"));
		if (!concatObject.isNull("AppAccountFlag"))
			setAppAccountFlag(concatObject.getInt("AppAccountFlag"));
		if (!concatObject.isNull("Statues"))
			setStatues(concatObject.getInt("Statues"));
		if (!concatObject.isNull("AttrStatus"))
			setAttrStatus(concatObject.getInt("AttrStatus"));
		if (!concatObject.isNull("Province"))
			setProvince(concatObject.getString("Province"));
		if (!concatObject.isNull("City"))
			setCity(concatObject.getString("City"));
		if (!concatObject.isNull("Alias"))
			setAlias(concatObject.getString("Alias"));
		if (!concatObject.isNull("SnsFlag"))
			setSnsFlag(concatObject.getInt("SnsFlag"));
		if (!concatObject.isNull("UniFriend"))
			setUniFriend(concatObject.getInt("UniFriend"));
		if (!concatObject.isNull("DisplayName"))
			setDisplayName(concatObject.getString("DisplayName"));
		if (!concatObject.isNull("ChatRoomId"))
			setChatRoomId(concatObject.getInt("ChatRoomId"));
		if (!concatObject.isNull("KeyWord"))
			setKeyWord(concatObject.getString("KeyWord"));
		if (!concatObject.isNull("EncryChatRoomId"))
			setEncryChatRoomId(concatObject.getString("EncryChatRoomId"));
		if (!concatObject.isNull("IsOwner"))
			setIsOwner(concatObject.getInt("IsOwner"));
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

	public Integer getContactFlag() {
		return ContactFlag;
	}

	public void setContactFlag(Integer contactFlag) {
		ContactFlag = contactFlag;
	}

	public Integer getMemberCount() {
		return MemberCount;
	}

	public void setMemberCount(Integer memberCount) {
		MemberCount = memberCount;
	}

	public List<Concat> getMemberList() {
		return MemberList;
	}

	public void setMemberList(List<Concat> memberList) {
		MemberList = memberList;
	}

	public String getRemarkName() {
		return RemarkName;
	}

	public void setRemarkName(String remarkName) {
		RemarkName = remarkName;
	}

	public Integer getHideInputBarFlag() {
		return HideInputBarFlag;
	}

	public void setHideInputBarFlag(Integer hideInputBarFlag) {
		HideInputBarFlag = hideInputBarFlag;
	}

	public Integer getSex() {
		return Sex;
	}

	public void setSex(Integer sex) {
		Sex = sex;
	}

	public String getSignature() {
		return Signature;
	}

	public void setSignature(String signature) {
		Signature = signature;
	}

	public Integer getVerifyFlag() {
		return VerifyFlag;
	}

	public void setVerifyFlag(Integer verifyFlag) {
		VerifyFlag = verifyFlag;
	}

	public Integer getOwnerUin() {
		return OwnerUin;
	}

	public void setOwnerUin(Integer ownerUin) {
		OwnerUin = ownerUin;
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

	public Integer getStarFriend() {
		return StarFriend;
	}

	public void setStarFriend(Integer starFriend) {
		StarFriend = starFriend;
	}

	public Integer getAppAccountFlag() {
		return AppAccountFlag;
	}

	public void setAppAccountFlag(Integer appAccountFlag) {
		AppAccountFlag = appAccountFlag;
	}

	public Integer getStatues() {
		return Statues;
	}

	public void setStatues(Integer statues) {
		Statues = statues;
	}

	public Integer getAttrStatus() {
		return AttrStatus;
	}

	public void setAttrStatus(Integer attrStatus) {
		AttrStatus = attrStatus;
	}

	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		Province = province;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getAlias() {
		return Alias;
	}

	public void setAlias(String alias) {
		Alias = alias;
	}

	public Integer getSnsFlag() {
		return SnsFlag;
	}

	public void setSnsFlag(Integer snsFlag) {
		SnsFlag = snsFlag;
	}

	public Integer getUniFriend() {
		return UniFriend;
	}

	public void setUniFriend(Integer uniFriend) {
		UniFriend = uniFriend;
	}

	public String getDisplayName() {
		return DisplayName;
	}

	public void setDisplayName(String displayName) {
		DisplayName = displayName;
	}

	public Integer getChatRoomId() {
		return ChatRoomId;
	}

	public void setChatRoomId(Integer chatRoomId) {
		ChatRoomId = chatRoomId;
	}

	public String getKeyWord() {
		return KeyWord;
	}

	public void setKeyWord(String keyWord) {
		KeyWord = keyWord;
	}

	public String getEncryChatRoomId() {
		return EncryChatRoomId;
	}

	public void setEncryChatRoomId(String encryChatRoomId) {
		EncryChatRoomId = encryChatRoomId;
	}

	public Integer getIsOwner() {
		return IsOwner;
	}

	public void setIsOwner(Integer isOwner) {
		IsOwner = isOwner;
	}

}
