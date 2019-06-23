package com.li.util;

import javax.servlet.http.Cookie;

public class CookiesUtil {

	/**
	 * 查找某一个特定名称的cookie
	 * @param c
	 * @param name
	 * @return
	 */
	public static Cookie findCookie(Cookie[] c,String name){
		if(c != null){
			if(c.length != 0){
				for (Cookie cookie : c) {
					if(cookie.getName().equals(name)){
						return cookie;
					}
				}	
			}
		}		
		return null;
	}
}
