package com.cqu.NewCQUer.pojo;

public class Administrator {
	
	//封装实体类
	private String account;
	private String password;
	private String name;
	private String phone;
	
	//各种属性的get方法和set方法
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//构造函数
	public Administrator(String account, String password, String name, String phone) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	public Administrator() {
		super();
	}
	
	
	
	
	//输出打印
	@Override
	public String toString() {
		return "Administrator [account=" + account + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ "]";
	}
}
