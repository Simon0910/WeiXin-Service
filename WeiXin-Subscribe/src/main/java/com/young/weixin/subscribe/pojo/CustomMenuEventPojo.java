package com.young.weixin.subscribe.pojo;

public class CustomMenuEventPojo {
	
	private String ToUserName;                       //������ ΢�ź�
	private String FromUserName;                       //���ͷ��ʺţ�һ��OpenID��
	private String CreateTime;                       //��Ϣ����ʱ�� �����ͣ�
	private String MsgType;                       //��Ϣ���ͣ�event
	private String Event;                       //�¼����ͣ�VIEW
	private String EventKey;                       //�¼�KEYֵ�����õ���תURL
	private String MenuID;                       //ָ�˵�ID������Ǹ��Ի��˵��������ͨ������ֶΣ�֪�����ĸ�����Ĳ˵�������ˡ�
	
	private String ScanCodeInfo;                       //ɨ����Ϣ
	private String ScanType;                       //ɨ�����ͣ�һ����qrcode
	private String ScanResult;                       //ɨ����������ά���Ӧ���ַ�����Ϣ
	
	private String SendPicsInfo;                       //���͵�ͼƬ��Ϣ
	private String Count;                       //���͵�ͼƬ����
	private String PicList;                       //ͼƬ�б�
	private String PicMd5Sum;                       //ͼƬ��MD5ֵ������������Ҫ����������֤���յ�ͼƬ
	private String SendLocationInfo;                       //���͵�λ����Ϣ
	private String Location_X;                       //X������Ϣ
	private String Location_Y;                       //Y������Ϣ
	private String Scale;                       //���ȣ������Ϊ���Ȼ��߱����ߡ�Խ��ϸ�Ļ� scaleԽ��
	private String Label;                       //����λ�õ��ַ�����Ϣ
	private String Poiname;                       //����ȦPOI�����֣�����Ϊ��
	
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
