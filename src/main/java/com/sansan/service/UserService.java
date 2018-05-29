package com.sansan.service;

import java.util.List;

import com.sansan.bean.system.User;

public interface UserService {
	
	/**
	 * 获取用户管理列表
	 * @return
	 */
	List<User> getListUser();

}
