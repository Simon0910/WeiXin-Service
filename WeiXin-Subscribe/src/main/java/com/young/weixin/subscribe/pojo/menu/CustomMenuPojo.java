package com.young.weixin.subscribe.pojo.menu;

public class CustomMenuPojo {
	private String is_menu_open	; //菜单是否开启，0代表未开启，1代表开启
	private String selfmenu_info	; //菜单信息
	private String button	; //菜单按钮
	private String type	; //菜单的类型，公众平台官网上能够设置的菜单类型有view（跳转网页）、text（返回文本，下同）、img、photo、video、voice。使用API设置的则有8种，详见《自定义菜单创建接口》
	private String name	; //菜单名称
	private String value;
	private String url;
	private String key;
	//value、url、key等字段 对于不同的菜单类型，value的值意义不同。官网上设置的自定义菜单： Text:保存文字到value； Img、voice：保存mediaID到value； Video：保存视频下载链接到value； News：保存图文消息到news_info，同时保存mediaID到value； View：保存链接到url。 使用API设置的自定义菜单： click、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、 pic_weixin、location_select：保存值到key；view：保存链接到url
	private String news_info	; //图文消息的信息
	private String title	; //图文消息的标题
	private String digest	; //摘要
	private String author	; //作者
	private String show_cover	; //是否显示封面，0为不显示，1为显示
	private String cover_url	; //封面图片的URL
	private String content_url	; //正文的URL
	private String source_url	; //原文的URL，若置空则无查看原文入口
	public String getIs_menu_open() {
		return is_menu_open;
	}
	public void setIs_menu_open(String is_menu_open) {
		this.is_menu_open = is_menu_open;
	}
	public String getSelfmenu_info() {
		return selfmenu_info;
	}
	public void setSelfmenu_info(String selfmenu_info) {
		this.selfmenu_info = selfmenu_info;
	}
	public String getButton() {
		return button;
	}
	public void setButton(String button) {
		this.button = button;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getNews_info() {
		return news_info;
	}
	public void setNews_info(String news_info) {
		this.news_info = news_info;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getShow_cover() {
		return show_cover;
	}
	public void setShow_cover(String show_cover) {
		this.show_cover = show_cover;
	}
	public String getCover_url() {
		return cover_url;
	}
	public void setCover_url(String cover_url) {
		this.cover_url = cover_url;
	}
	public String getContent_url() {
		return content_url;
	}
	public void setContent_url(String content_url) {
		this.content_url = content_url;
	}
	public String getSource_url() {
		return source_url;
	}
	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}
}
