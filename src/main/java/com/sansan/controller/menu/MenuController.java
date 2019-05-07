package com.sansan.controller.menu;

import com.sansan.Contails;
import com.sansan.bean.menu.Menu;
import com.sansan.bean.menu.NavTal;
import com.sansan.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by siss 2019-4-30 16:53
 * 菜单控制类
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 首页左侧菜单导航
     * @return
     */
    @RequestMapping(value = "/leftNavMenu", method = RequestMethod.GET, produces = Contails.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> leftNavMenu(){
        int grade = 1;
        int parentId = 0;
        List<NavTal> navTals = new ArrayList<>();
        List<Menu> menus = menuService.getMenuList(grade, parentId);
        for (Menu menu:menus) {
            NavTal navTal = new NavTal();
            navTal.setTitle(menu.getMenuName());
            navTal.setHref(menu.getHref());
            navTal.setIcon(menu.getIcon());
            navTal.setSpread("true");
            navTals.add(navTal);
        }

        Map<String, Object> res =new HashMap<>();
        res.put("contentManagement", navTals);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
