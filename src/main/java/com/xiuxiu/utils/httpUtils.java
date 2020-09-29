package com.xiuxiu.utils;

import net.sf.json.JSONObject;
import weixin.payment.WeiXinPayConstants;
import weixin.payment.exception.SignatureException;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class httpUtils {

	public static JSONObject sendPostUrl(String url, String param){
		PrintWriter out = null;
		BufferedReader in = null;
		JSONObject jsonObject = null;
		String result ="";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流（设置请求编码为UTF-8）
			out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 获取请求返回数据（设置返回数据编码为UTF-8）
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			jsonObject = JSONObject.fromObject(result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{
				if(out!=null){
					out.close();
				}
				if(in!=null){
					in.close();
				}
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return jsonObject;
	}
	
	public static String generateSignature(Map<String, String> data, String mearchantSecertKey) throws SignatureException {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals(WeiXinPayConstants.FIELD_SIGN)) {
                continue;
            }
            if (data.get(k) != null && data.get(k).trim().length() > 0) {
                sb.append(k).append("=").append(data.get(k).trim()).append("&");
            } else {
                sb.append(k).append("=").append("&");
            }
        }
        sb.append("secret=").append(mearchantSecertKey);
        try {
                return MD5(sb.toString()).toLowerCase();
         
        } catch (Exception ex) {
            throw new SignatureException();
        }
        
    }
	
	public static StringBuilder MapToString(Map<String, String> data) throws SignatureException {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        int i=1;
        for (String k : keyArray) {
            if (data.get(k) != null && data.get(k).trim().length() > 0) {
            	if(i==data.size()){
            		sb.append(k).append("=").append(data.get(k).trim());
            	}else {
            		sb.append(k).append("=").append(data.get(k).trim()).append("&");
				}
            } 
            i++;
        }
        return sb;
        
    }
	
	public static String MD5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }
	
	
	 public static String generateNonceStr() {
	        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
	    }
}
