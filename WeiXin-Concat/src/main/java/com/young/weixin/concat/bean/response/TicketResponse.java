/**
 * 
 */
package com.young.weixin.concat.bean.response;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Name TicketResponse
 * @Description 
 *    TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月13日 下午2:22:33
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
@SuppressWarnings("rawtypes")
public class TicketResponse {
	private String ret;
	private String message;
	private String skey;
	private String wxsid;
	private String wxuin;
	private String pass_ticket;
	private String isgrayscale;
	
	public TicketResponse(String xmlResponse)
	{
		try {
			Document doc = DocumentHelper.parseText(xmlResponse);
			Element rootElt = doc.getRootElement(); 
			Iterator iter = rootElt.elementIterator("error"); 
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				this.ret = recordEle.elementTextTrim("ret");
				this.message = recordEle.elementTextTrim("message");
				this.skey = recordEle.elementTextTrim("skey");
				this.wxsid = recordEle.elementTextTrim("wxsid");
				this.wxuin = recordEle.elementTextTrim("wxuin");
				this.pass_ticket = recordEle.elementTextTrim("pass_ticket");
				this.isgrayscale = recordEle.elementTextTrim("isgrayscale");
			}
		} catch (DocumentException e) {
		}
	}
	public String getRet() {
		return ret;
	}
	public void setRet(String ret) {
		this.ret = ret;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSkey() {
		return skey;
	}
	public void setSkey(String skey) {
		this.skey = skey;
	}
	public String getWxsid() {
		return wxsid;
	}
	public void setWxsid(String wxsid) {
		this.wxsid = wxsid;
	}
	public String getWxuin() {
		return wxuin;
	}
	public void setWxuin(String wxuin) {
		this.wxuin = wxuin;
	}
	public String getPass_ticket() {
		return pass_ticket;
	}
	public void setPass_ticket(String pass_ticket) {
		this.pass_ticket = pass_ticket;
	}
	public String getIsgrayscale() {
		return isgrayscale;
	}
	public void setIsgrayscale(String isgrayscale) {
		this.isgrayscale = isgrayscale;
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
}
