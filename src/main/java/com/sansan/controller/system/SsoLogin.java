package com.sansan.controller.system;

import com.sansan.common.LoginCheck;
import com.sansan.common.Response;
import org.apache.http.HttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.log.LogInputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/sso")
public class SsoLogin {

    @RequestMapping("/doLogin")
    public ModelAndView doLogin(String username, String password, String gotoUrl, HttpServletResponse response){
            ModelAndView mv = new ModelAndView("login_fail");
            boolean ok = LoginCheck.checkLogin(username,password);
            if(ok){
                Cookie cookie = new Cookie(LoginCheck.COOKIE_NAME, LoginCheck.COOKIE_VALUE);
                cookie.setPath("/");
                response.addCookie(cookie);
                mv.setViewName("redirect:"+gotoUrl);
            }
            return mv;
    }
}
