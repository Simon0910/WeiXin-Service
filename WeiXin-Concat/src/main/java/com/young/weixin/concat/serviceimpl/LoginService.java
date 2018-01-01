/**
 * 
 */
package com.young.weixin.concat.serviceimpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.springframework.stereotype.Service;

import com.young.weixin.common.httpclient.DefaultHTTPClient;
import com.young.weixin.common.httpclient.HTTPMethod;
import com.young.weixin.common.httpclient.HTTPRequest;
import com.young.weixin.concat.bean.request.InitRequest;
import com.young.weixin.concat.bean.response.TicketResponse;

/**
 * @Name LoginService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月12日 上午10:02:22
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved.
 *             注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
@Service
public class LoginService {
	DefaultHTTPClient client = new DefaultHTTPClient();
	public static Map<String, String> cookieMap = new HashMap<String, String>();
	
	public HTTPRequest setPublicHeader(HTTPRequest method) {
		method.addHeader("Accept", "application/json, text/plain, */*")
				.addHeader("Accept-Encoding", "gzip, deflate, br").addHeader("Accept-Language", "zh-CN,zh;q=0.9")
				// .addHeader("Connection","keep-alive")
				.addHeader("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36");
		return method;
	}

//	private Logger logger = LoggerFactory.getLogger(LoginService.class);
	public String getCookie(String cookieName) {
		if("deviceID".equals(cookieName))
			if(getCookie("deviceID","") == null||getCookie("deviceID","").isEmpty())
				setCookie("deviceID", "e"+(long)(Math.random()* 1000000000000000L));
		return getCookie(cookieName,"");
		
	}
	public String getCookie(String cookieName,String defualtValue)
	{

		List<Cookie> cookies = DefaultHTTPClient.cookieStore.getCookies();
		for(Cookie cookie:cookies)
		{
			if(cookie.getName().equals(cookieName))
			{
				return cookie.getValue();
			}
		}

		if("deviceID".equals(cookieName))
			return cookieMap.get(cookieName);
		return "";
	}
	public void setCookie(String name,String value)
	{
		cookieMap.put(name, value);
//		DefaultHTTPClient.cookieStore.addCookie();
		//DefaultHTTPClient.cookieStore.addCookie(new BasicClientCookie(name,value));
	}
	
	public void getIndex() throws Exception {
		String url = "https://wx.qq.com";
		HTTPRequest req = setPublicHeader(new HTTPRequest(HTTPMethod.GET, url));
		try {
			client.fetch(req);
		} catch (URISyntaxException e) {
			throw new RuntimeException("API url has been modified, current url: " + url);
		}
	}

	public String getLoginCode() throws Exception {

		getIndex();
		String url = "https://login.wx.qq.com/jslogin";
		HTTPRequest req = setPublicHeader(new HTTPRequest(HTTPMethod.GET, url))
				.addQueryParameter("appid", "wx782c26e4c19acffb")
				.addQueryParameter("redirect_uri", "https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxnewloginpage")
				.addQueryParameter("fun", "new").addQueryParameter("lang", "zh_CN")
				.addQueryParameter("_", String.valueOf(System.currentTimeMillis())).setConnectionTimeout(60 * 1000)
				.setRequestTimeout(60 * 10000);

		String loginCode = "";
		try {
			String res = client.fetch(req).body;
			loginCode = res.substring(res.indexOf("window.QRLogin.uuid = ") + "window.QRLogin.uuid = ".length());
			loginCode = loginCode.replace("\"", "");
			loginCode = loginCode.replace(";", "");
			cookieMap.put("wxlid", loginCode);
		} catch (URISyntaxException e) {
			throw new RuntimeException("API url has been modified, current url: " + url);
		}
		return loginCode;
	}

	public byte[] getLoginQrCode() throws ClientProtocolException, IOException {
		String loginCode = cookieMap.get("wxlid");
		String url = "https://login.weixin.qq.com/qrcode/" + loginCode;
		HTTPRequest req = setPublicHeader(new HTTPRequest(HTTPMethod.GET, url))
				.addQueryParameter("appid", "wx782c26e4c19acffb")
				.addQueryParameter("redirect_uri", "https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxnewloginpage")
				.addQueryParameter("fun", "new").addQueryParameter("lang", "zh_CN")
				.addQueryParameter("_", String.valueOf(System.currentTimeMillis())).setConnectionTimeout(60 * 1000)
				.setRequestTimeout(60 * 10000);
		try {
			return client.fetch(req).bodyBytes;
		} catch (URISyntaxException e) {
			throw new RuntimeException("API url has been modified, current url: " + url);
		}
	}

	public TicketResponse webwxnewloginpage() throws HttpException, IOException {
		String loginCode = cookieMap.get("wxlid");
		String url = "https://login.wx.qq.com/cgi-bin/mmwebwx-bin/login";
		HTTPRequest req = setPublicHeader(new HTTPRequest(HTTPMethod.GET, url)).addQueryParameter("loginicon", "true")
				.addQueryParameter("uuid", loginCode).addQueryParameter("tip", "0")
				.addQueryParameter("r", "-1400307965")
				.addQueryParameter("_", String.valueOf(System.currentTimeMillis()))
				.setConnectionTimeout(60 * 1000)
				.setRequestTimeout(60 * 10000);
		try {
			String login_resp_str = client.fetch(req).body;
			String redirect_uri_str = "https://login.wx.qq.com/cgi-bin/mmwebwx-bin/login";
			redirect_uri_str = login_resp_str.substring(
					login_resp_str.indexOf("window.redirect_uri=\"") + "window.redirect_uri=\"".length(),
					login_resp_str.length() - 2);
			System.out.println(redirect_uri_str);
			HTTPRequest req1 = setPublicHeader(new HTTPRequest(HTTPMethod.GET, redirect_uri_str))
					.addQueryParameter("loginicon", "true").addQueryParameter("uuid", loginCode)
					.addQueryParameter("tip", "0").addQueryParameter("r", "-1400307965")
					.addQueryParameter("_", String.valueOf(System.currentTimeMillis())).setConnectionTimeout(60 * 1000)
					.setRequestTimeout(60 * 10000);
			String xmlStr = client.fetch(req1).body;
			System.out.println(xmlStr);
			TicketResponse ticketResp = new TicketResponse(xmlStr);
			ticketResp.setMessage(xmlStr);
			if (ticketResp.getSkey() != null && !ticketResp.getSkey().isEmpty())
				cookieMap.put("skey", ticketResp.getSkey());
			if (ticketResp.getWxsid() != null && !ticketResp.getWxsid().isEmpty())
				cookieMap.put("wxsid", ticketResp.getWxsid());
			if (ticketResp.getWxuin() != null && !ticketResp.getWxuin().isEmpty())
				cookieMap.put("wxuin", ticketResp.getWxuin());
			if (ticketResp.getPass_ticket() != null && !ticketResp.getPass_ticket().isEmpty())
				cookieMap.put("pass_ticket", ticketResp.getPass_ticket());
			return ticketResp;
		} catch (URISyntaxException e) {
			throw new RuntimeException("API url has been modified, current url: " + url);
		}

	}

	public String getWebwxInit(InitRequest initRequest) throws Exception {
		System.out.println(initRequest);
		String url = "https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxinit" ;
		HTTPRequest req = setPublicHeader(new HTTPRequest(HTTPMethod.POST, url))
				.addQueryParameter("r", "-1516162729")
				.setBody(initRequest.toString())
				.setConnectionTimeout(60 * 1000)
				.setRequestTimeout(60 * 10000);
		String pass_ticket = cookieMap.get("pass_ticket");
		if ( pass_ticket != null && !pass_ticket.isEmpty())
			req.addQueryParameter("pass_ticket", pass_ticket);
		try {
			return client.fetch(req).body;
		} catch (URISyntaxException e) {
			throw new RuntimeException("API url has been modified, current url: " + url);
		}	
	}
}
