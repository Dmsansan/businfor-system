package com.sansan.controller.system;

import com.sansan.service.SystemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sansan.bean.system.User;
import com.sansan.common.Response;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/system")
public class SystemController {

	private static final Logger log = Logger.getLogger(SystemController.class);

	@Autowired
	private SystemService systemService;
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public Response login(User user){
		boolean flag = systemService.checkUserInfo(user);
		if(flag){
			return new Response().success("登陆成功");
		}else{
			return new Response().failure("登录失败");
		}

	}

	/**
	 * 登录成功首页
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index(){
		return new ModelAndView("index");
	}

}
