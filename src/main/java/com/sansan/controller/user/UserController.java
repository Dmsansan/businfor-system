package com.sansan.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	/**
	 * 获取用户列表
	 * @return
	 */
	@RequestMapping(value="/getListUser", method=RequestMethod.GET, produces={ "application/json;charset=UTF-8" })
	@ResponseBody
	public Response getListUser(){
		int total;
		List<User> list = userSrv.getListUser();
		total = list.size();
		Map<String, Object> map = new HashMap<>();
		map.put("Rows", list);
		map.put("Total", total);
		
 		return new Response().success(map);
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/addUser", method=RequestMethod.POST, produces={ "application/json;charset=UTF-8" })
	@ResponseBody
	public Response addUser(User user){
		Map<String, Object> map = new HashMap<>();
		
		try{
			map = userSrv.addUser(user);
		}catch(Exception e){
			e.printStackTrace();
			map.put("msg", "服务器异常");
			map.put("code",0);
		}
		
		return new Response().success(map);
	}

	/**
	 * 编辑用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/editUser", method=RequestMethod.POST, produces={ "application/json;charset=UTF-8" })
	@ResponseBody
	public Response editUser(User user){
		Map<String, Object> map = new HashMap<>();
		try{
			map = userSrv.editUser(user);
		}catch (Exception e){
			e.printStackTrace();
			map.put("msg","service error...");
			map.put("code",0);
		}

		return new Response().success(map);
	}

	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/deleteUser", method=RequestMethod.POST, produces={ "application/json;charset=UTF-8" })
	@ResponseBody
	public Response deleteUser(User user){
		Map<String,Object> map = new HashMap<>();
		try{
			map = userSrv.deleteUser(user);
		}catch (Exception e){
			e.printStackTrace();
			map.put("msg","service error...");
			map.put("code",0);
		}
		return new Response().success(map);
	}
}
