package com.young.weixin.common.util;

import java.util.ArrayList;
import java.util.List;

public class Sequence {
	private static List<String> ls = new ArrayList<String>();
	private static String timestamp;
	public static String getPK() {
		String lo = (String.valueOf(Math.random())).substring(2, 9);
		if(!timestamp.equals(getCurDateTime())){
			ls.clear(); 
		}
		for (int i = 0; i < ls.size(); i++) {
			String lt = ls.get(i);
			if (lo.equals(lt)) {
				lo = getPK();
				break;
			}
		}
		return lo;
	}
	
    public static String getCurDateTime()  {
    	timestamp=String.valueOf(System.currentTimeMillis());
        return timestamp;
    }

	public synchronized static String getFlow(){
		StringBuilder sb = new StringBuilder();
		sb.append(getCurDateTime());
		String str=getPK();
		ls.add(str);
		sb.append(str);
		return sb.toString();
	}
	
	
}