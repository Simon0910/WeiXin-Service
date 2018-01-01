/**
 * 
 */
package com.young.weixin.concat.test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpException;
import org.apache.http.client.utils.URIUtils;

/**
 * @Name TestHttpClient
 * @Description 
 *    TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月14日 上午10:29:33
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class TestHttpClient {
	public static void main(String[] args) throws HttpException, IOException, URISyntaxException {
		URI requestURI =new URI("https://login.wx.qq.com/cgi-bin/mmwebwx-bin/login?r=-1400307965&tip=0&loginicon=true&uuid&_=1514810678290");
		System.out.println(URIUtils.extractHost(requestURI));;
	}
}
