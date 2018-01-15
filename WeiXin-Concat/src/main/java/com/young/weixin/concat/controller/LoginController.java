/**
 * 
 */
package com.young.weixin.concat.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.young.weixin.concat.bean.request.BaseRequest;
import com.young.weixin.concat.bean.request.InitRequest;
import com.young.weixin.concat.bean.response.InitResponse;
import com.young.weixin.concat.bean.response.TicketResponse;
import com.young.weixin.concat.serviceimpl.LoginService;

//import net.sf.json.JSONObject;

/**
 * @Name LoginController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月12日 上午10:01:31
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved.
 *             注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/image")
	@ResponseBody
	public void getImage(HttpServletResponse response, HttpSession session) throws Exception {
		response.setContentType("image/jpeg");
		try {
			loginService.getLoginCode();
			response.getOutputStream().write(loginService.getLoginQrCode());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/login")
	@ResponseBody
	public String test(HttpServletRequest request, HttpSession session) throws Exception {
		TicketResponse ticketResp = loginService.webwxnewloginpage();
		loginService.getIndex();
		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setDeviceID(loginService.getCookie("deviceID"));
		baseRequest.setSid(loginService.getCookie("wxsid"));
		baseRequest.setUin(loginService.getCookie("wxuin"));
		baseRequest.setSkey(loginService.getCookie("skey"));
		InitResponse initResp = null;
		String initRespStr = loginService.getWebwxInit(new InitRequest(baseRequest));
		if (initRespStr == null || initRespStr.isEmpty())
			initResp = new InitResponse();
		else
			initResp = new InitResponse(initRespStr);

		System.out.println(initResp.toString());
		return initResp.toString();
	}

	@RequestMapping(value = "/init")
	@ResponseBody
	public void init(HttpServletRequest request, HttpSession session) throws Exception {
		loginService.getIndex();
	}

	@RequestMapping(value = "/wxinit")
	@ResponseBody
	public String getWebwxInit(HttpServletRequest request, HttpSession session) throws Exception {
		loginService.getIndex2();
		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setDeviceID(loginService.getCookie("deviceID"));
		baseRequest.setSid(loginService.getCookie("wxsid"));
		baseRequest.setUin(loginService.getCookie("wxuin"));
		baseRequest.setSkey(loginService.getCookie("skey"));
		// {Uin: "xuin=904152460", Sid: "BLDwLSzy7U6N61QB", Skey: "", DeviceID:
		// "e724272063629085"}
		InitResponse initResp = null;
		String initRespStr = "";//loginService.getWebwxInit(new InitRequest(baseRequest));
		System.out.println(initRespStr);
		if (initRespStr == null || initRespStr.isEmpty())
			initResp = new InitResponse();
		else
			initResp = new InitResponse(initRespStr);
		if (initResp.getUser() == null || initResp.getUser().getUserName() == null
				|| initResp.getUser().getUserName().isEmpty()) {
//			loginService.getIndex2();
			baseRequest.setDeviceID(loginService.getCookie("deviceID"));
			baseRequest.setSid(loginService.getCookie("wxsid"));
			baseRequest.setUin(loginService.getCookie("wxuin"));
			baseRequest.setSkey(loginService.getCookie("skey"));
			initRespStr = loginService.getWebwx2Init(new InitRequest(baseRequest));
			System.out.println(initRespStr);
			if (initRespStr == null || initRespStr.isEmpty())
				initResp = new InitResponse();
			else
				initResp = new InitResponse(initRespStr);
		}

		return initResp.toString();
	}

	@RequestMapping(value = "/getConcat")
	@ResponseBody
	public String concat(HttpServletRequest request, HttpSession session) throws Exception {
		// loginService.getIndex();
		// List<Concat> cs = loginService.getConcats();
		// System.out.println(cs.size());
		// return cs.toString();
		return null;
	}

	@RequestMapping(value = "/sendMsg")
	@ResponseBody
	public String sendMsg(HttpServletRequest request, HttpSession session) throws Exception {
		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setDeviceID(loginService.cookieMap.get("deviceID"));
		baseRequest.setSid(loginService.cookieMap.get("wxsid"));
		baseRequest.setUin(loginService.cookieMap.get("wxuin"));
		baseRequest.setSkey(loginService.cookieMap.get("skey"));
		//
		// InitResponse initResp = loginService.getWebwxInit(new
		// InitRequest(baseRequest));

		// List<Concat> concats = loginService.getConcats();
		// for(int i = 0 ; i<concats.size();i++){
		// Concat concat = concats.get(i);
		// Message msg = new Message();
		// {
		// "BaseRequest": {
		// "Uin": 904152460,
		// "Sid": "ajI65aUBRLBpl0zG",
		// "Skey": "@crypt_cd188f5a_2fbf6c115d0f047b9f7c64bda9172bab",
		// "DeviceID": "e657197019318101"
		// },
		// "Msg": {
		// "Type": 1,
		// "Content": "test",
		// "FromUserName":
		// "@6d1a119efd50690cc0c4fe53d10d5f9b1f6190e4f71fb034e8f561992fcc3eb3",
		// "ToUserName":
		// "@8d52259ffdfb79f01f38cc074439005b9517f794ef1c257a924245d4e74138c2",
		// "LocalID": "15137337996410344",
		// "ClientMsgId": "15137337996410344"
		// },
		// "Scene": 0
		// }
		/**
		 * { "BaseRequest": { "Uin": 904152460, "Sid": "ajI65aUBRLBpl0zG", "Skey":
		 * "@crypt_cd188f5a_2fbf6c115d0f047b9f7c64bda9172bab", "DeviceID":
		 * "e178801155899714" }, "Msg": { "Type": 1, "Content": "test", "FromUserName":
		 * "@6d1a119efd50690cc0c4fe53d10d5f9b1f6190e4f71fb034e8f561992fcc3eb3",
		 * "ToUserName": "filehelper", "LocalID": "15137340108400599", "ClientMsgId":
		 * "15137340108400599" }, "Scene": 0 }
		 */
		// String clientMsgId = String.valueOf(System.currentTimeMillis()) +
		// String.valueOf((int)((Math.random()*9+1)*1000));
		// msg.setType(1);
		// msg.setContent("TEST MSG");
		// msg.setFromUserName(loginService.getCookieValue("fromUserName"));
		// msg.setToUserName(concat.getUserName());
		// msg.setClientMsgId(clientMsgId);
		// msg.setLocalID(clientMsgId);
		// SendMsgRequest sendMsg = new SendMsgRequest();
		// sendMsg.setBaseRequest(baseRequest);
		// sendMsg.setMsg(msg);
		// sendMsg.setScene(0);
		// loginService.sendMsg(sendMsg);
		// }
		return null;
	}

	@RequestMapping(value = "/test")
	@ResponseBody
	public void test01(HttpServletResponse response) throws Exception {
	}
}
