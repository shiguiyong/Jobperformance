package com.xiuxiu.utils;

import net.sf.json.JSONObject;

public class JsonpUtils {

	
	public static String Result(String callback, Object obj){
		JSONObject fromObject = JSONObject.fromObject(obj);
    	String res = callback + "(" + fromObject + ")";
    	return res;
	}
}
