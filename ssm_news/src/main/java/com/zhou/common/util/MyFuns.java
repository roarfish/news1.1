package com.zhou.common.util;

import java.io.UnsupportedEncodingException;


/**
 * 工具类
 * @author zhoup
 *
 */
public class MyFuns {
	/**
	 * 转换字符编码格式为UTF-8
	 * @param s
	 * @return
	 */
	public static String convert2Utf8(String s){
		if(s==null)return null;
		try {
			s=new String(s.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * 字符串转换为int类型
	 * @param s
	 * @return
	 */
	public static int string2Int(String s){
		if(s==null)return 0;
		try{
			return Integer.parseInt(s);
		}catch(Exception e){
			//e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String htmlspecialchars(String str) {
		if(str==null)return "";
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		
		return str;
	}
}
