package com.sansan.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sansan.bean.system.User;
import com.sansan.common.Response;
import com.sansan.service.UserService;

/**
 * 用户管理类
 * @author Sisansan
 * @date 2018-05-23
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userSrv;
	
	@RequestMapping(value="/getListUser", method=RequestMethod.GET, produces={ "application/json;charset=UTF-8" })
	@ResponseBody
	public Response getListUser(){
		List<User> list = userSrv.getListUser();
		return new Response().success(list);
	}
}
