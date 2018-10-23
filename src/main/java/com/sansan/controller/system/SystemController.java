package com.sansan.controller.system;

import org.apache.log4j.Logger;
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
	
	/**
	 * 登录
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public Response login(HttpServletRequest req){
		log.info("获取表单信息："+req.getParameter("userName"));
		return new Response().success(req.getParameter("userName"));
	}

	/**
	 * 登录成功首页
	 * @return
	 */
	@RequestMapping(value = "/user")
	public ModelAndView user(){
		return new ModelAndView("user");
	}

}
