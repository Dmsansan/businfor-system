package com.sansan.bean.system;

import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;

/**
 * 用户实体类
 * @author Sisansan
 * @date 2018-05-22
 */
public class User {
	private int userID;
	private String userName;
	private String passWord;
	private String name;
	private int age;
	private int sex;
	private String address;
	private String phone;
	private String regTime;
	
	
	
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", passWord=" + passWord + ", name=" + name
				+ ", age=" + age + ", sex=" + sex + ", address=" + address + ", phone=" + phone + ", regTime=" + regTime
				+ "]";
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public boolean isNull(User user){
		if(user.getUserName()==null||user.getPassWord()==null||user.getName()==null||user.getAge()==0
				||user.getSex()==0||user.getAddress()==null||user.getPhone()==null){
			return true;
		}
		return false;
	}
}
