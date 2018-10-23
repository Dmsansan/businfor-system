package com.sansan.common;

import com.sun.xml.internal.ws.server.ServerRtException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class LoginCheck {
    public static final String USERNAME = "user";
    public static final String PASSWORD = "123";
    public static final String COOKIE_NAME = "ssocookie";
    public static final String COOKIE_VALUE = "sso";

    public static boolean checkLogin(String username,String password){
        if(USERNAME.equals(username)&&PASSWORD.equals(password)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies == null){
            return false;
        }

        for(Cookie cookie:cookies){
            if(COOKIE_NAME.equals(cookie.getName())&&COOKIE_VALUE.equals(cookie.getValue())){
                return true;
            }
        }
        return false;
    }
}
