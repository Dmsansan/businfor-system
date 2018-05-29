package com.sansan.mapper;

import java.util.List;

import com.sansan.bean.system.User;

public interface UserMapper {
	
	/**
	 * 获取用户列表数据
	 * @return
	 */
	List<User> getListUser();
	
}
