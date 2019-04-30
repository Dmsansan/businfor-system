package com.sansan.service.menu.impl;

import com.sansan.bean.menu.Menu;
import com.sansan.mapper.MenuMapper;
import com.sansan.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("MenuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuList(int grade, int parentId) {
        final Map<String, Object> param = new HashMap<>();
        param.put("grade", grade);
        param.put("parentId", parentId);

        return menuMapper.getMenuList(param);
    }
}
