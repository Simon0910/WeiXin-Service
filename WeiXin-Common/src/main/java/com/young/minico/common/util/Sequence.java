package com.young.minico.common.util;

import java.util.ArrayList;
import java.util.List;

public class Sequence {
	private static List<String> ls = new ArrayList<String>();
	private static String timestamp;
	public static String getPK() throws Exception {
		String lo = getpk();
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
	private static String getpk() {
		String d = (String.valueOf(Math.random())).substring(2, 9);
		return d;
	}
	
    public static String getCurDateTime() throws Exception {
    	timestamp=String.valueOf(System.currentTimeMillis());
        return timestamp;
    }

	public synchronized static String getFlow() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append(getCurDateTime());
		String str=getPK();
		ls.add(str);
		sb.append(str);
		return sb.toString();
	}
}