package com.young.weixin.subscribe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.young.weixin.common.pojo.WeiXinConfig;

@SpringBootApplication
@EnableConfigurationProperties({WeiXinConfig.class}) 
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
