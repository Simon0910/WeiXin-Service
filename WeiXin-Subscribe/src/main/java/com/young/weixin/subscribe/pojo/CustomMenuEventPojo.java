package com.young.weixin.subscribe.pojo;

public class CustomMenuEventPojo {
	
	private String ToUserName;                       //开发者 微信号
	private String FromUserName;                       //发送方帐号（一个OpenID）
	private String CreateTime;                       //消息创建时间 （整型）
	private String MsgType;                       //消息类型，event
	private String Event;                       //事件类型，VIEW
	private String EventKey;                       //事件KEY值，设置的跳转URL
	private String MenuID;                       //指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了。
	
	private String ScanCodeInfo;                       //扫描信息
	private String ScanType;                       //扫描类型，一般是qrcode
	private String ScanResult;                       //扫描结果，即二维码对应的字符串信息
	
	private String SendPicsInfo;                       //发送的图片信息
	private String Count;                       //发送的图片数量
	private String PicList;                       //图片列表
	private String PicMd5Sum;                       //图片的MD5值，开发者若需要，可用于验证接收到图片
	private String SendLocationInfo;                       //发送的位置信息
	private String Location_X;                       //X坐标信息
	private String Location_Y;                       //Y坐标信息
	private String Scale;                       //精度，可理解为精度或者比例尺、越精细的话 scale越高
	private String Label;                       //地理位置的字符串信息
	private String Poiname;                       //朋友圈POI的名字，可能为空
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	public String getMenuID() {
		return MenuID;
	}
	public void setMenuID(String menuID) {
		MenuID = menuID;
	}
	public String getScanCodeInfo() {
		return ScanCodeInfo;
	}
	public void setScanCodeInfo(String scanCodeInfo) {
		ScanCodeInfo = scanCodeInfo;
	}
	public String getScanType() {
		return ScanType;
	}
	public void setScanType(String scanType) {
		ScanType = scanType;
	}
	public String getScanResult() {
		return ScanResult;
	}
	public void setScanResult(String scanResult) {
		ScanResult = scanResult;
	}
	public String getSendPicsInfo() {
		return SendPicsInfo;
	}
	public void setSendPicsInfo(String sendPicsInfo) {
		SendPicsInfo = sendPicsInfo;
	}
	public String getCount() {
		return Count;
	}
	public void setCount(String count) {
		Count = count;
	}
	public String getPicList() {
		return PicList;
	}
	public void setPicList(String picList) {
		PicList = picList;
	}
	public String getPicMd5Sum() {
		return PicMd5Sum;
	}
	public void setPicMd5Sum(String picMd5Sum) {
		PicMd5Sum = picMd5Sum;
	}
	public String getSendLocationInfo() {
		return SendLocationInfo;
	}
	public void setSendLocationInfo(String sendLocationInfo) {
		SendLocationInfo = sendLocationInfo;
	}
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		Scale = scale;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	public String getPoiname() {
		return Poiname;
	}
	public void setPoiname(String poiname) {
		Poiname = poiname;
	}
	
}
