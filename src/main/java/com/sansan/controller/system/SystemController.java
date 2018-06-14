package com.sansan.controller.system;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sansan.bean.system.User;
import com.sansan.common.Response;

@RestController
@RequestMapping("/system")
public class SystemController {
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public Response login(@RequestBody User user){
		System.out.println(user.getUserName());
		
		return new Response().success();
	}


}
