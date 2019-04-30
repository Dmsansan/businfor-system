package com.sansan.mapper;

import com.sansan.bean.menu.Menu;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
    List<Menu> getMenuList(Map<String, Object> param);
}
