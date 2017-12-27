package com.young.weixin.subscribe.pojo.message;

public class GeneralMessage {
	private String ToUserName;				//开发者微信号
	private String FromUserName;			//发送方帐号（一个OpenID）
	private String CreateTime;				//消息创建时间 （整型）
	private String MsgType;					//text
	private String Content;					//文本消息内容
	private String MsgId;					//消息id，64位整型
	private String PicUrl;					//图片链接（由系统生成）
	private String MediaId;					//图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String Format;					//语音格式，如amr，speex等
	private String MsgID;					//消息id，64位整型
	private String MediaID;					//语音消息媒体id，可以调用多媒体文件下载接口拉取该媒体
	private String Recognition;				//语音识别结果，UTF8编码
	private String ThumbMediaId;			//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	private String Location_X;				//地理位置维度
	private String Location_Y;				//地理位置经度
	private String Scale;					//地图缩放大小
	private String Label;					//地理位置信息
	private String Title;					//消息标题
	private String Description;				//消息描述
	private String Url;				  		//消息链接
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
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getMsgID() {
		return MsgID;
	}
	public void setMsgID(String msgID) {
		MsgID = msgID;
	}
	public String getMediaID() {
		return MediaID;
	}
	public void setMediaID(String mediaID) {
		MediaID = mediaID;
	}
	public String getRecognition() {
		return Recognition;
	}
	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
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
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public enum MsgType	
	{
		TEXT("text",""),
		IMAGE("image",""),
		VOICE("voice",""),
		VIDEO("video",""),
		SHORTVIDEO("shortvideo",""),
		LOCATION("location",""),
		LINK("link","");
		private String type;
		private String desc;
		MsgType(String type,String desc)
		{
			this.type = type;
			this.desc = desc;
		}
		public String getType() {
			return type;
		}
		public String getDesc() {
			return desc;
		}
		
	}
}
