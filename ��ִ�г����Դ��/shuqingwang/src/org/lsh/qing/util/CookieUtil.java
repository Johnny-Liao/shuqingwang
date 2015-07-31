package org.lsh.qing.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	private static String default_path
	     ="/shopCat";
	private static int default_age =365*24*3600;
	
    // ÉèÖÃage
	public static void addCookie(String name,String value,
			HttpServletResponse response,int age) throws UnsupportedEncodingException{
		
		Cookie cookie = 
		    new Cookie(name,URLEncoder.encode(value,"utf-8"));
		cookie.setMaxAge(age);
		cookie.setPath(default_path);
		response.addCookie(cookie);
		
	}
	//Ä¬ÈÏµÄ
	public static void addCookie(String name,String value,HttpServletResponse
			response) throws UnsupportedEncodingException{
		addCookie(name,value,response,default_age);
		
	}
	public static String findCookie(String name,HttpServletRequest request) 
	       throws UnsupportedEncodingException{
		String value = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(int i=0;i<cookies.length;i++){
				Cookie cookie = cookies[i];
				if(cookie.getName().equals(name)){
					value = URLDecoder.decode(cookie.getValue(), "utf-8");
					
				}
			}
		}
		return value;
		
	}
	public static void deleteCookie(String name,HttpServletResponse
			response){
		Cookie cookie = new Cookie(name,"");
		cookie.setMaxAge(0);
		cookie.setPath(default_path);
		response.addCookie(cookie);
		
	}
	
	
	

}
