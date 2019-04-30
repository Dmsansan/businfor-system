package com.sansan.bean.menu;

import java.util.Date;

/**
 * create by siss 2019.4.30 15:40
 */
public class Menu {
    // id
    private int id;
    // 菜单名称
    private String menuName;
    // 父节点id
    private int parentId;
    // 菜单级别 1级菜单 2级菜单
    private int grade;
    // 连接
    private String href;
    // 图标
    private String icon;
    // 创建时间
    private Date createTime;
    // 最后更新时间
    private Date lastUpdateTime;
    // 删除状态 0未删除 1已删除
    private int delStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(int delStatus) {
        this.delStatus = delStatus;
    }
}
