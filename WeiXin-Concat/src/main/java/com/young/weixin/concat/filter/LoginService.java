/**
 * 
 */
package com.young.weixin.concat.filter;

import static com.young.weixin.concat.service.BaseService.cookieStore;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.beust.jcommander.internal.Lists;
import com.young.weixin.concat.bean.Concat;
import com.young.weixin.concat.bean.request.InitRequest;
import com.young.weixin.concat.bean.request.SendMsgRequest;
import com.young.weixin.concat.bean.response.ConcatResponse;
import com.young.weixin.concat.bean.response.TicketResponse;
import com.young.weixin.concat.service.BaseService;

/**
 * @Name LoginService
 * @Description 
 *    TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月12日 上午10:02:22
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
@Service
public class LoginService extends BaseService{
	public void setPublicHeader(HttpRequestBase method)
	{	
		method.addHeader("Accept","application/json, text/plain, */*");
		method.addHeader("Accept-Encoding","gzip, deflate, br");
		method.addHeader("Accept-Language","zh-CN,zh;q=0.9");
//		method.addHeader("Connection","keep-alive");
		method.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36");

	}
	private Logger logger = LoggerFactory.getLogger(LoginService.class);
	public void getIndex()  throws Exception 
	{
		HttpGet httpGet = new HttpGet("https://wx.qq.com");
		setPublicHeader(httpGet);
		CloseableHttpResponse resp = client.execute(httpGet);
		EntityUtils.toString(resp.getEntity()); 
	}
	public String getLoginCode() throws Exception 
	{
		HttpGet httpGet = new HttpGet("https://wx.qq.com");
		setPublicHeader(httpGet);
		String loginCode = null;
		CloseableHttpResponse resp = client.execute(httpGet);
		if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
		{ 
			List<NameValuePair> params = Lists.newArrayList();
			params.add(new BasicNameValuePair("appid","wx782c26e4c19acffb"));
			params.add(new BasicNameValuePair("redirect_uri","https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxnewloginpage"));
			params.add(new BasicNameValuePair("fun","new"));
			params.add(new BasicNameValuePair("lang","zh_CN"));
			params.add(new BasicNameValuePair("_",String.valueOf(System.currentTimeMillis())));
	
			String queryStr = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
			
			httpGet.setURI(new URI("https://login.wx.qq.com/jslogin?"+queryStr));
			CloseableHttpResponse resp1 = client.execute(httpGet);
			String res = EntityUtils.toString(resp1.getEntity());   
			loginCode = res.substring(res.indexOf("window.QRLogin.uuid = ")+"window.QRLogin.uuid = ".length());
			loginCode = loginCode.replace("\"", "");
			loginCode = loginCode.replace(";", "");
			setCookieValue("wxlid",loginCode);
		}
		return loginCode;
	}
	public byte[] getLoginQrCode() throws ClientProtocolException, IOException
	{
		String loginCode =getCookieValue("wxlid");
		HttpGet httpGet = new HttpGet("https://login.weixin.qq.com/qrcode/"+loginCode);
		setPublicHeader(httpGet);
		CloseableHttpResponse resp = client.execute(httpGet);
		return EntityUtils.toByteArray(resp.getEntity());  
	}
	public TicketResponse webwxnewloginpage() throws HttpException, IOException
	{
		String loginCode =getCookieValue("wxlid");
		List<NameValuePair> params = Lists.newArrayList();
		params.add(new BasicNameValuePair("loginicon","true"));
		params.add(new BasicNameValuePair("uuid",loginCode));
		params.add(new BasicNameValuePair("tip","0"));
		params.add(new BasicNameValuePair("r","-1400307965"));
		params.add(new BasicNameValuePair("_",String.valueOf(System.currentTimeMillis())));
		String queryStr = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
		
		HttpGet httpGet = new HttpGet("https://login.wx.qq.com/cgi-bin/mmwebwx-bin/login?"+queryStr);
		System.out.println(httpGet.getURI());
		setPublicHeader(httpGet);
		CloseableHttpResponse resp = client.execute(httpGet);
		String login_resp_str =  EntityUtils.toString(resp.getEntity());
		System.out.println(login_resp_str);
		String redirect_uri_str = "https://login.wx.qq.com/cgi-bin/mmwebwx-bin/login";
		try{
			redirect_uri_str = login_resp_str.substring(login_resp_str.indexOf("window.redirect_uri=\"")+"window.redirect_uri=\"".length(),login_resp_str.length()-2 );
		}catch (Exception e) {
			
		}
//		HttpPost HttpPost = new HttpPost("https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxstatreport?fun=new&lang=zh_CN");
//		Map map =new HashMap();
//		setPublicHeader(HttpPost);
//		BaseRequest b1= new BaseRequest();
//		b1.setDeviceID(getCookieValue("deviceID"));
//		map.put("BaseRequest",b1 );
//		map.put("Count",0 );
//		map.put("List",new ArrayList() );
//		HttpPost.setRequestBody(JSONObject.fromObject(map).toString());
//		client.execute(HttpPost);

		HttpGet getTicketMethod =new HttpGet(redirect_uri_str);
		//setPublicHeader(getTicketMethod);
		getTicketMethod.addHeader("Accept","application/json, text/plain, */*");
		getTicketMethod.addHeader("Accept-Encoding","gzip, deflate, br");
		getTicketMethod.addHeader("Accept-Language","zh-CN,zh;q=0.9");
//		getTicketMethod.addHeader("Connection","keep-alive");
		getTicketMethod.addHeader(HttpHeaders.CONNECTION, "close");
		getTicketMethod.addHeader(HttpHeaders.CONTENT_TYPE,"application/json;charset=UTF-8");
		getTicketMethod.addHeader("Referer","https://wx.qq.com/?&lang=zh_CN");
		getTicketMethod.addHeader("Cookie", getAllCookieValue());
		getTicketMethod.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36");
		System.out.println(getTicketMethod.getURI());
		CloseableHttpResponse resp1 = client.execute(getTicketMethod);
		
		Header contentEncoding =  resp1.getLastHeader("Content-Encoding");
		// 如果对内容进行了压缩，则解压  
		String xmlStr ;
        if (null != contentEncoding && contentEncoding.getValue().indexOf("gzip") != -1) { 
        	final GZIPInputStream gzipInputStream = new GZIPInputStream(resp1.getEntity().getContent());  
            ServletInputStream newStream = new ServletInputStream() {  
                @Override  
                public int read() throws IOException {  
                    return gzipInputStream.read();  
                }

				@Override
				public boolean isFinished() {
					return false;
				}

				@Override
				public boolean isReady() {
					return false;
				}

				@Override
				public void setReadListener(ReadListener listener) {
					
				}  
            }; 
            StringBuilder content = new StringBuilder();  
            byte[] b = new byte[1024];  
            int lens = -1;  
            while ((lens = newStream.read(b)) > 0) {  
                content.append(new String(b, 0, lens));  
            }  
            xmlStr = content.toString();// 内容
        }else{
        	xmlStr =  EntityUtils.toString(resp1.getEntity());
        }
		TicketResponse ticketResp =  new TicketResponse(xmlStr); 
		ticketResp.setMessage(xmlStr);
		if(ticketResp.getSkey()!=null&&!ticketResp.getSkey().isEmpty())
			setCookieValue("skey",ticketResp.getSkey());
		if(ticketResp.getWxsid()!=null&&!ticketResp.getWxsid().isEmpty())
			setCookieValue("wxsid",ticketResp.getWxsid());
		if(ticketResp.getWxuin()!=null&&!ticketResp.getWxuin().isEmpty())
			setCookieValue("wxuin",ticketResp.getWxuin());
		if(ticketResp.getPass_ticket()!=null&&!ticketResp.getPass_ticket().isEmpty())
			setCookieValue("pass_ticket",ticketResp.getPass_ticket());
		return ticketResp;
	}
	public String getWebwxInit(InitRequest initRequest) throws Exception
	{
		getIndex();
		List<NameValuePair> params = Lists.newArrayList();
		params.add(new BasicNameValuePair("r","-1516162729"));
		if(getCookieValue("pass_ticket")!=null&&!getCookieValue("pass_ticket").isEmpty())
			params.add(new BasicNameValuePair("pass_ticket",getCookieValue("pass_ticket")));
		String str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
		
		HttpPost httpPost = new HttpPost("https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxinit?"+str);
		System.out.println(httpPost.getURI());
		setPublicHeader(httpPost);
		httpPost.setEntity(new StringEntity(initRequest.toString()));
		CloseableHttpResponse resp = client.execute(httpPost);
		String jsonStr =  EntityUtils.toString(resp.getEntity());
		System.out.println(jsonStr);
		return jsonStr;
	}
	
	public void setCookieValue(String cookieName,String cookie){
		setCookieValue("localhost",cookieName,cookie);
	}
	public void setCookieValue(String domain,String cookieName,String cookieValue){
        BasicClientCookie cookie = new BasicClientCookie(cookieName,cookieValue);
        cookie.setVersion(0);
        cookie.setDomain(domain);
        cookieStore.addCookie(cookie);
	}
	public String getCookieValue(String cookieName){
		if("deviceID".equals(cookieName))
			if(getCookieValue("deviceID","") == null||getCookieValue("deviceID","").isEmpty())
				setCookieValue("deviceID", "e"+(long)(Math.random()* 1000000000000000L));
		return getCookieValue(cookieName,"");
	}
	public String getCookieValue(String cookieName,String defualtVlue)
	{
        List<Cookie> cookies = cookieStore.getCookies();
		for(Cookie cookie : cookies){
			if(cookieName.equals(cookie.getName()))
			{
				return cookie.getValue();
			}
		}
		return defualtVlue;
	}
	public String getAllCookieValue()
	{
        List<Cookie> cookies = cookieStore.getCookies();
        StringBuilder str = new StringBuilder();
        Map<String,String> c = new HashMap<String,String>();
		for(Cookie cookie : cookies){
			if(c.containsKey(cookie.getName()))
			{
				if(c.get(cookie.getName())==null||"".equals(c.get(cookie.getName()))){
					c.put(cookie.getName(), cookie.getValue());
				}
			}else{
				c.put(cookie.getName(), cookie.getValue());
			}
		}
		for(String cookieName : c.keySet()){
			str.append(cookieName);
			str.append("=");
			str.append(c.get(cookieName));
			str.append("; ");
		}
		return str.toString();
	}
	
	public List<Concat> getConcats() throws HttpException, IOException
	{
		List<NameValuePair> params = Lists.newArrayList();
		params.add(new BasicNameValuePair("lang","zh_CN"));
		if(getCookieValue("pass_ticket")!=null&&!getCookieValue("pass_ticket").isEmpty())
			params.add(new BasicNameValuePair("pass_ticket",getCookieValue("pass_ticket")));
		params.add(new BasicNameValuePair("r",String.valueOf(System.currentTimeMillis())));
		params.add(new BasicNameValuePair("seq","0"));
		params.add(new BasicNameValuePair("skey",getCookieValue("skey")));
		
		String queryStr = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
		HttpGet httpGet = new HttpGet("https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxgetcontact?"+queryStr);
		setPublicHeader(httpGet);
		CloseableHttpResponse resp = client.execute(httpGet);
		String jsonStr =  EntityUtils.toString(resp.getEntity());
		System.out.println(jsonStr);
		return new ConcatResponse(jsonStr).getMemberList();
	}
/**
	https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxsendmsg?pass_ticket=JVJEQqEgGdHwWZuQjb1s8juMrjvrAflWk82cZhDoncqLL582%252F4eUBx5yK1aTXt1s 
		*/
	public void sendMsg(SendMsgRequest sendMsg) throws Exception{

		String queryStr ="";
		if(getCookieValue("pass_ticket")!=null&&!getCookieValue("pass_ticket").isEmpty()){
			List<NameValuePair> params = Lists.newArrayList();
			params.add(new BasicNameValuePair("pass_ticket",getCookieValue("pass_ticket")));
			queryStr = "?"+EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
		}
		
		HttpPost httpPost = new HttpPost("https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxsendmsg"+queryStr);
		setPublicHeader(httpPost);
		httpPost.setEntity(new StringEntity(sendMsg.toString()));
		CloseableHttpResponse resp = client.execute(httpPost);
		String jsonStr =  EntityUtils.toString(resp.getEntity());
		System.out.println(jsonStr);
	}
	public void printRequestHeader(HttpRequestBase method,Header[] headers){
		 for(Header header : headers){
			 method.setHeader(header);
		 } 
	}
	public void printRequestHeader(HttpRequestBase method){
		 for(Header header : method.getAllHeaders()){
			 logger.info(header.getName()+":"+header.getValue());
		 } 
	}
}
