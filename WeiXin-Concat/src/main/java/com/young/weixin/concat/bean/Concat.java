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
 * @Description 
 *    TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月12日 下午5:51:54
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
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
		

		public Concat(){
			
		}
		public Concat(String jsonStr) throws JSONException
		{
			 this(new JSONObject(jsonStr));
		}
		public static  List<Concat> concatList(JSONArray concatArray) throws JSONException
		{
			List<Concat> list = new ArrayList<Concat>();
			for(int i = 0 ; i<concatArray.length() ; i++)
			{
				list.add(new Concat((JSONObject)concatArray.getJSONObject(i)));
			}
			return list;
		}
		public Concat(JSONObject concatObject) throws JSONException{
			setUin             ( concatObject.getString("Uin"             ));
			setUserName        ( concatObject.getString("UserName"        ));
			setNickName        ( concatObject.getString("NickName"        ));
			setHeadImgUrl      ( concatObject.getString("HeadImgUrl"      ));
			setContactFlag     ( concatObject.getInt   ("ContactFlag"     ));
			setMemberCount     ( concatObject.getInt   ("MemberCount"     ));
			setMemberList      ( Concat.concatList((JSONArray)concatObject.get("MemberList")));
			setRemarkName      ( concatObject.getString("RemarkName"      ));
			setHideInputBarFlag( concatObject.getInt   ("HideInputBarFlag"));
			setSex             ( concatObject.getInt   ("Sex"             ));
			setSignature       ( concatObject.getString("Signature"       ));
			setVerifyFlag      ( concatObject.getInt   ("VerifyFlag"      ));
			setOwnerUin        ( concatObject.getInt   ("OwnerUin"        ));
			setPYInitial       ( concatObject.getString("PYInitial"       ));
			setPYQuanPin       ( concatObject.getString("PYQuanPin"       ));
			setRemarkPYInitial ( concatObject.getString("RemarkPYInitial" ));
			setRemarkPYQuanPin ( concatObject.getString("RemarkPYQuanPin" ));
			setStarFriend      ( concatObject.getInt   ("StarFriend"      ));
			setAppAccountFlag  ( concatObject.getInt   ("AppAccountFlag"  ));
			setStatues         ( concatObject.getInt   ("Statues"         ));
			setAttrStatus      ( concatObject.getInt   ("AttrStatus"      ));
			setProvince        ( concatObject.getString("Province"        ));
			setCity            ( concatObject.getString("City"            ));
			setAlias           ( concatObject.getString("Alias"           ));
			setSnsFlag         ( concatObject.getInt   ("SnsFlag"         ));
			setUniFriend       ( concatObject.getInt   ("UniFriend"       ));
			setDisplayName     ( concatObject.getString("DisplayName"     ));
			setChatRoomId      ( concatObject.getInt   ("ChatRoomId"      ));
			setKeyWord         ( concatObject.getString("KeyWord"         ));
			setEncryChatRoomId ( concatObject.getString("EncryChatRoomId" ));
			setIsOwner         ( concatObject.getInt   ("IsOwner"         ));
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
