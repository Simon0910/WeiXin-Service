package com.young.weixin.subscribe.pojo.menu;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.ObjectMapper;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "xml")  
public class CustomMenuEventPojo implements Serializable {
	private static final long serialVersionUID = -6851591386507485900L;
	private String ToUserName;                       
	private String FromUserName;                       
	private String CreateTime;                       
	private String MsgType;                      
	private String Event;                
	private String EventKey;                      
	private String MenuID;                   
	
	private String ScanCodeInfo;                   
	private String ScanType;                      
	private String ScanResult;                     
	
	private String SendPicsInfo;                      
	private String Count;                    
	private String PicList;                    
	private String PicMd5Sum;                     
	private String SendLocationInfo;                    
	private String Location_X;                      
	private String Location_Y;                     
	private String Scale;                       
	private String Label;                      
	private String Poiname;                       
	
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
	public enum EventType
	{
		CLICK("CLICK","点击菜单拉取消息时的事件推送"),
		VIEW("VIEW","点击菜单跳转链接时的事件推送"),
		SCANCODE_PUSH("scancode_push","扫码推事件的事件推送"),
		SCANCODE_WAITMSG("scancode_waitmsg","扫码推事件且弹出“消息接收中”提示框的事件推送"),
		PIC_SYSPHOTO("pic_sysphoto","弹出系统拍照发图的事件推送"),
		PIC_PHOTO_OR_ALBUM("pic_photo_or_album","弹出拍照或者相册发图的事件推送"),
		PIC_WEIXIN("pic_weixin","弹出微信相册发图器的事件推送"),
		LOCATION_SELECT("location_select","弹出地理位置选择器的事件推送");
		
		private String event;
		private String desc;
		EventType(String event,String desc)
		{
			this.event = event;
			this.desc = desc;
		}
		public String getEvent() {
			return event;
		}
		public String getDesc() {
			return desc;
		}
	}
}

