package com.sansan.service;

import com.sansan.bean.system.User;

import javax.xml.ws.ServiceMode;

public interface SystemService {
    //判断用户登录信息
    public boolean checkUserInfo(User user);
}
