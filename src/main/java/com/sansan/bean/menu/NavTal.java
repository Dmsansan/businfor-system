package com.sansan.bean.menu;

import java.util.List;

/**
 * create by siss 2019-4-30 16:52
 */
public class NavTal {
    // 标题
    private String title;
    // 图标
    private String icon;
    // 是否展开
    private String spread;
    // 连接地址
    private String href;

    // 子菜单
    private List<NavTal> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<NavTal> getChildren() {
        return children;
    }

    public void setChildren(List<NavTal> children) {
        this.children = children;
    }
}
