package com.sansan.service.menu;

import com.sansan.bean.menu.Menu;

import java.util.List;

public interface MenuService {

    /**
     * 获取菜单列表 by 级别 父节点ID
     * @param grade
     * @param parentId
     * @return
     */
    List<Menu> getMenuList(int grade, int parentId);
}
