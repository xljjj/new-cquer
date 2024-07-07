package com.cqu.NewCQUer.pojo;


public class Dormitory {
	
	//封装实体类 寝室四人的学号和姓名
	private String student1_account;
	private String student1_name;
	private String student2_account;
	private String student2_name;
	private String student3_account;
	private String student3_name;
	private String student4_account;
	private String student4_name;
	
	
	
	//各种属性的get方法和set方法
	public String getStudent1_account() {
		return student1_account;
	}

	public void setStudent1_account(String student1_account) {
		this.student1_account = student1_account;
	}

	public String getStudent1_name() {
		return student1_name;
	}

	public void setStudent1_name(String student1_name) {
		this.student1_name = student1_name;
	}

	public String getStudent2_account() {
		return student2_account;
	}

	public void setStudent2_account(String student2_account) {
		this.student2_account = student2_account;
	}

	public String getStudent2_name() {
		return student2_name;
	}

	public void setStudent2_name(String student2_name) {
		this.student2_name = student2_name;
	}

	public String getStudent3_account() {
		return student3_account;
	}

	public void setStudent3_account(String student3_account) {
		this.student3_account = student3_account;
	}

	public String getStudent3_name() {
		return student3_name;
	}

	public void setStudent3_name(String student3_name) {
		this.student3_name = student3_name;
	}

	public String getStudent4_account() {
		return student4_account;
	}

	public void setStudent4_account(String student4_account) {
		this.student4_account = student4_account;
	}

	public String getStudent4_name() {
		return student4_name;
	}

	public void setStudent4_name(String student4_name) {
		this.student4_name = student4_name;
	}
	
	
	//构造函数
	public Dormitory(String student1_account, String student1_name, String student2_account, String student2_name,
			String student3_account, String student3_name, String student4_account, String student4_name) {
		super();
		this.student1_account = student1_account;
		this.student1_name    = student1_name;
		this.student2_account = student2_account;
		this.student2_name    = student2_name;
		this.student3_account = student3_account;
		this.student3_name    = student3_name;
		this.student4_account = student4_account;
		this.student4_name    = student4_name;
	}
	public Dormitory() {
		super();
	}


	//输出打印
	@Override
	public String toString() {
		return "Dormitory [student1_account=" + student1_account + ", student1_name=" + student1_name
				+ ", student2_account=" + student2_account + ", student2_name=" + student2_name + ", student3_account="
				+ student3_account + ", student3_name=" + student3_name + ", student4_account=" + student4_account
				+ ", student4_name=" + student4_name + "]";
	}

	
	
}