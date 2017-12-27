/**
 * 
 */
package com.young.weixin.concat.test;

/**
 * @Name TestMath
 * @Description 
 *    TODO(这里用一句话描述这个类的作用)
 * @Author YangZhan
 * @Date 2017年12月14日 上午10:13:49
 * @Version 1.0
 * @Copyright: 2017 www.ruiqi.cd Inc. All rights reserved. 
 * 注意：本内容仅限于成都瑞骐金服集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class TestMath {
	public static void main(String[] args) {
		long s = (long)(Math.random()* 10000);
		System.out.println(String.valueOf(s).length());
		String clientMsgId = String.valueOf(System.currentTimeMillis()) + String.valueOf((int)((Math.random()*9+1)*1000));
		
		System.out.println(clientMsgId); 
		System.out.println(clientMsgId.length());
		System.out.println("15137337996410344".length() );
		
	}
}
