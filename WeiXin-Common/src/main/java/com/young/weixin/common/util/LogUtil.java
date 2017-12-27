package com.young.weixin.common.util;

public class LogUtil {
	private static final ThreadLocal<String> LOG_ID_NUM = new ThreadLocal<String>();

	public static void remove(){
		LOG_ID_NUM.remove();
	}
	public static void set(){
		if(LOG_ID_NUM.get() == null || LOG_ID_NUM.get().isEmpty()){
			LOG_ID_NUM.set(Sequence.getPK());
		}
	}
}
