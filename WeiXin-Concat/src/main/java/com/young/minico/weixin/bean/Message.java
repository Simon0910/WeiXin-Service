/**
 * 
 */
package com.young.minico.weixin.bean;

/**
 * @Name Message
 * @Description 
 *    {
 *    "Type":1,
 *    "Content":"x",
 *    "FromUserName":"@da12a172423c4df17e3c71f815cacb8fc49872ab4df3eb6f652a7e6bfb95e74a",
 *    "ToUserName":"filehelper",
 *    "LocalID":"15131533158820189",
 *    "ClientMsgId":"15131533158820189"
 *    }
 * @Author YangZhan
 * @Date 2017年12月13日 下午4:31:12
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class Message {
	private Integer Type;
	private String Content;
	private String FromUserName;
	private String ToUserName;
	private String LocalID;
	private String ClientMsgId;
	public Integer getType() {
		return Type;
	}
	public void setType(Integer type) {
		Type = type;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getLocalID() {
		return LocalID;
	}
	public void setLocalID(String localID) {
		LocalID = localID;
	}
	public String getClientMsgId() {
		return ClientMsgId;
	}
	public void setClientMsgId(String clientMsgId) {
		ClientMsgId = clientMsgId;
	}
}
