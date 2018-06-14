package com.sansan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public Map<String, Object> addUser(User user) {
		Map<String, Object> map = new HashMap<>();
		user.setPassWord("123456");
		if(user.isNull(user)){
			map.put("msg", "参数不完整!");
			map.put("code", 2);
		}else{
			User user1 = userMap.getUserByUserName(user.getUserName());
			if(user1!=null){
				map.put("msg", "用户已存在，请勿重复添加！");
				map.put("code", 3);
			}else{
				int num = userMap.insertUser(user);
				map.put("msg", "添加成功！");
				map.put("code", 1);
			}
		}
		return map;
	}

	/**
	 * 编辑用户
	 * @param user
	 * @return
	 */
	@Override
	public Map<String, Object> editUser(User user) {
		Map<String,Object> map = new HashMap<>();
		try{
			User userInfo = userMap.getUserByUserID(user.getUserID());
			if(userInfo.getUserName().equals(user.getUserName())&&userInfo.getPassWord().equals(user.getPassWord())&&
					userInfo.getName().equals(user.getName())&&userInfo.getAddress().equals(user.getAddress())&&userInfo.getAge()==user.getAge()&&
					userInfo.getSex()==user.getSex()&&userInfo.getPhone().equals(user.getPhone())){
				map.put("msg","没有信息被修改！");
				map.put("code",3);
			}else{
				int num = userMap.editUser(user);
				if(num <=0){//修改失败
					map.put("msg","修改失败！");
					map.put("code",2);
				}else{
					map.put("msg","修改成功！");
					map.put("code",1);
				}
			}

		}catch (Exception e){
			e.printStackTrace();
			map.put("msg","service error...");
			map.put("code",0);
		}
		return map;
	}

	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	@Override
	public Map<String, Object> deleteUser(User user) {
		Map<String, Object> map = new HashMap<>();
		try{
			int num = userMap.deleteUser(user.getUserID());
			if(num <= 0){
				map.put("msg","删除失败！");
				map.put("code",2);
			}else{
				map.put("msg","删除成功！");
				map.put("code",1);
			}
		}catch (Exception e){
			e.printStackTrace();
			map.put("msg","service error...");
			map.put("code",0);
		}
		return map;
	}
}
