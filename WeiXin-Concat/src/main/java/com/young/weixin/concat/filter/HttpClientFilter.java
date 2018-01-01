/**
 * 
 */
package com.young.weixin.concat.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @Name HttpClientFilter
 * @Description 
 *    TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月14日 上午10:50:50
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class HttpClientFilter implements Filter {

	
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req =(HttpServletRequest) request;
		CloseableHttpClient client = (CloseableHttpClient)req.getSession().getAttribute("WX_HTTP_CLIENT");//判断用户是否登录
        if (client == null) {
        	client = HttpClients.createDefault();;
        	req.getSession().setAttribute("WX_HTTP_CLIENT",client);
        }
        chain.doFilter(request, response);
	}

	public void destroy() {
	}
	
}
