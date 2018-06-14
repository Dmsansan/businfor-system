package com.sansan.service;

import java.util.List;
import java.util.Map;

import com.sansan.bean.system.User;

public interface UserService {
	
	/**
	 * 获取用户管理列表
	 * @return
	 */
	List<User> getListUser();
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	Map<String, Object> addUser(User user);

	/**
	 * 编辑用户
	 * @param user
	 * @return
	 */
	Map<String,Object> editUser(User user);

	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	Map<String,Object> deleteUser(User user);
}
