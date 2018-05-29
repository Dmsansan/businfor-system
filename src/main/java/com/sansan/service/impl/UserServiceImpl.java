package com.sansan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sansan.bean.system.User;
import com.sansan.mapper.UserMapper;
import com.sansan.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMap;
	
	@Override
	public List<User> getListUser() {
		return userMap.getListUser();
	}

}
