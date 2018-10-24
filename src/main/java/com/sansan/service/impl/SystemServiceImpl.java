package com.sansan.service.impl;

import com.sansan.bean.system.User;
import com.sansan.mapper.UserMapper;
import com.sansan.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean checkUserInfo(User user) {
        String passWord = userMapper.getUserPassWord(user.getUserName());
        if(!StringUtils.isEmpty(passWord)) {
            if (passWord.equals(user.getPassWord())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean register(User user) {
        int res = userMapper.insertUser(user);
        if(res > 0){
            return true;
        }
        return false;
    }
}
