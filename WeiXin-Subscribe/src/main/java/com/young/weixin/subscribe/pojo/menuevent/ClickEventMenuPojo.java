package com.young.weixin.subscribe.pojo.menuevent;

public class ClickEventMenuPojo {
	private String ToUserName;                       //开发者 微信号
	private String FromUserName;                       //发送方帐号（一个OpenID）
	private String CreateTime;                       //消息创建时间 （整型）
	private String MsgType;                       //消息类型，event
	private String Event;                       //事件类型，CLICK
	private String EventKey;                       //事件KEY值，与自定义菜单接口中KEY值对应
}
