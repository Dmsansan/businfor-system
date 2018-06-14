package com.sansan.mapper;

import java.util.List;

import com.sansan.bean.system.User;

public interface UserMapper {
	
	/**
	 * 获取用户列表数据
	 * @return
	 */
	List<User> getListUser();
	
	/**
	 * 根据用户名获取用户信息
	 * @param userName
	 * @return
	 */
	User getUserByUserName(String userName);
	
	/**
	 * 插入用户数据
	 * @param user
	 * @return
	 */
	int insertUser(User user);

	/**
	 * 编辑用户
	 * @param user
	 * @return
	 */
	int editUser(User user);

	/**
	 * 根据用户ID获取用户信息
	 * @param userID
	 * @return
	 */
	User getUserByUserID(Integer userID);

	/**
	 * 删除用户
	 * @param userID
	 * @return
	 */
	int deleteUser(Integer userID);
}
