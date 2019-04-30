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
import java.util.List;

/**
 * create by siss 2019-4-30 16:53
 * 菜单控制类
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/leftNavMenu", method = RequestMethod.POST, produces = Contails.APPLICATION_JSON_VALUE)
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
        return new ResponseEntity<>(navTals, HttpStatus.OK);
    }

}
