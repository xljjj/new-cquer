package com.cqu.NewCQUer.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqu.NewCQUer.pojo.Administrator;
import com.cqu.NewCQUer.pojo.Result;
import com.cqu.NewCQUer.pojo.Student;
import com.cqu.NewCQUer.service.AdministratorService;
import com.cqu.NewCQUer.service.StudentService;
/**
 * spring mvc 的框架
 * m:model
 * v:view
 * c:controller
 * */


@Controller
@RequestMapping("admin")
public class AdministratorController {
	
	@Autowired
	AdministratorService service;
	@Autowired
	StudentService stuservice;
	
	//登录,管理员的账号是数据库中已存的不可创建
	@PostMapping("login")
	@ResponseBody
	public Result<?> login(String account, String password, HttpSession session) {
		Administrator result_admin = service.findAdministratorByAccount(account);
		String nextpage;  //下一个网页
		String psw_encrypt = DigestUtils.md5Hex(password);  //同种加密方式加密后的密码
		if(psw_encrypt.equals(result_admin.getPassword())) {
			nextpage = "/adminhome"; //主页
		} else {
			session.setAttribute("message", "密码错误");
			return Result.error(500,"用户名或密码错误");
		}
		return Result.success(nextpage,"跳转到下一网页");
	}
	
	//修改个人信息
	@PostMapping("update")
	@ResponseBody
	public Result<?> update(String account, String password, String name ,String phone) {
		String nextpage;
		String psw_encrypt = DigestUtils.md5Hex(password);  //同种加密方式加密后的密码
		Administrator admin = new Administrator(account, psw_encrypt, name,phone);
		service.updateAdministrator(admin);
		nextpage = "/home";
		return Result.success(nextpage,"修改完信息回到首页");
	}
	
	//查看所有学生信息  
	//返回data的类型 Arraylist<Student>;
	@PostMapping("check")
	@ResponseBody
	public Result<?> check() {
		ArrayList<Student> allstudents = new ArrayList<>();
		allstudents = stuservice.findAllStudent();
		return Result.success(allstudents,"所有学生信息");
	}
	
	//为学生找回密码
	//输入 学生账号;
	@PostMapping("findBack")
	@ResponseBody
	public Result<?> findBack(String stuaccount) {  
		Student student = stuservice.findStudentByAccount(stuaccount);
		if(student == null) {
			return Result.error(500, "该学生账号不存在");
		}
		//重置学生密码为123456
		String psw_encrypt = DigestUtils.md5Hex("123456");  //同种加密方式加密后的密码
		student.setPassword(psw_encrypt);
		stuservice.updateStudent(student);
		return Result.success("已重置该学生密码", "已重置该学生密码");
	}
	
	//修改学生个人信息
	//修改个人信息
	@PostMapping("updateStu")
	@ResponseBody
	public Result<?> updateStu(String account, String password, String name, String age, String sex, 
			String major, String province, String hobby, String phone, String qq, String wx, 
			String email, String description) {
		String nextpage;
		Student stu = stuservice.findStudentByAccount(account);
		if(password.length()!=0) {
			String psw_encrypt = DigestUtils.md5Hex(password);  //同种加密方式加密后的密码
			stu.setPassword(psw_encrypt);
		}
		if(name.length()!=0) 		 stu.setName(name);
		if(age.length()!=0) 		 stu.setAge(age);
		if(sex.length()!=0)  		 stu.setSex(sex);
		if(major.length()!=0) 		 stu.setMajor(major);
		if(province.length()!=0)	 stu.setProvince(province);
		if(hobby.length()!=0) 		 stu.setHobby(hobby);
		if(phone.length()!=0) 		 stu.setPhone(phone);
		if(qq.length()!=0)			 stu.setQq(qq);
		if(wx.length()!=0)           stu.setWx(wx);
		if(email.length()!=0) 		 stu.setEmail(email);
		if(description.length()!=0)  stu.setDescription(description);
		stuservice.updateStudent(stu);
		nextpage = "/home";
		return Result.success(nextpage,"修改完信息回到首页");
	}
	
	//发布公告
	
	
}