package com.young.weixin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.young.weixin.common.pojo.WeiXinConfig;
import com.young.weixin.common.service.AccessTokenService;
import com.young.weixin.subscribe.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class ApplicationTests {

	@Autowired
	WeiXinConfig weiXinConfig;
	@Test
	public void contextLoads() {
		System.out.println("------------------------------------");
		System.out.println(weiXinConfig);
		System.out.println(weiXinConfig.getAccessToken());
		System.out.println("------------------------------------");
	}

}
