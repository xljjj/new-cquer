package com.cqu.NewCQUer.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable{
	
	//封装实体类
	//必填的信息存于数据库中的table student_required
	private String account;
	private String password;
	private String name;
	private int    age;
	private String sex;
	private String major;
	private String province;
	private String hobby;
	//选填的信息存于数据库中的table studednt_optional
	private String phone;
	private String qq;
	private String wx;
	private String email;
	private String roommatepre;
	private String description;
	
	
	
	//各种属性的get方法和set方法
	//其中Age的set方法有两个，输入参数类型为int和String都可以设置int类型的属性
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public void setAge(String age) {
		int age_int = Integer.parseInt(age);
		this.age = age_int;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWx() {
		return wx;
	}
	public void setWx(String wx) {
		this.wx = wx;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoommatepre() {
		return roommatepre;
	}
	public void setRoommatepre(String roommatepre) {
		this.roommatepre = roommatepre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	//Student的两个带参数构造函数(第二个输入参数类型全为String)
	public Student(String account, String password, String name, int age, String sex, String major, String province,
			String hobby, String phone, String qq, String wx, String email, String roommatepre, String description) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.major = major;
		this.province = province;
		this.hobby = hobby;
		this.phone = phone;
		this.qq = qq;
		this.wx = wx;
		this.email = email;
		this.roommatepre = roommatepre;
		this.description = description;
	}
	public Student(String account, String password, String name, String age, String sex, String major, String province,
			String hobby, String phone, String qq, String wx, String email, String roommatepre, String description) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		int age_int = Integer.parseInt(age);
		this.age = age_int;
		this.sex = sex;
		this.major = major;
		this.province = province;
		this.hobby = hobby;
		this.phone = phone;
		this.qq = qq;
		this.wx = wx;
		this.email = email;
		this.roommatepre = roommatepre;
		this.description = description;
	}
	public Student() {
		super();
	}
	
	
	//输出打印
	@Override
	public String toString() {
		return "Student [account=" + account + ", password=" + password + ", name=" + name + ", age=" + age + ", sex="
				+ sex + ", major=" + major + ", province=" + province + ", hobby=" + hobby + ", phone=" + phone
				+ ", qq=" + qq + ", wx=" + wx + ", email=" + email + ", roommatepre=" + roommatepre + ", description="
				+ description + "]";
	}
}
