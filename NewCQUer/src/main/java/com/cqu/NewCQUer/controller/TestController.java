package com.cqu.NewCQUer.controller;

//import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqu.NewCQUer.service.AdministratorService;
import com.cqu.NewCQUer.service.StudentService;
//import com.cqu.NewCQUer.pojo.Administrator;
//import com.cqu.NewCQUer.pojo.Dormitory;
import com.cqu.NewCQUer.pojo.Result;
import com.cqu.NewCQUer.pojo.Student;

@Controller
@RequestMapping("test")
public class TestController {
	
	@Autowired
	StudentService service;
	@Autowired
	AdministratorService service2;
	
	@RequestMapping("hello")
	@ResponseBody
	public String hello() {
//		ArrayList<Student> stuPro = new ArrayList<>();
//		stuPro = service.findAllStudentByProvince("安徽省");
//		for(Student student : stuPro) {
//			System.out.println(student);
//		}
//		
//		ArrayList<Administrator> admins = new ArrayList<>();
//		admins = service2.findAllAdministrator();
//		for(Administrator admin : admins) {
//			System.out.println(admin);
//		}
//		Administrator admin = service2.findAdministratorByAccount("20204322");
//		System.out.println(admin);
 		
//		Student student = service.findStudentByAccount("1");
//		service.insertStudentChat(student);
//		Student student = service.findStudentByAccount("20204322");
//		service.deleteStudentChat(student);
		
//		ArrayList<Student> students = new ArrayList<>();
//		students = service.findAllStudentChat();
//		System.out.println(students);
		System.out.println(DigestUtils.md5Hex("123456"));
		return "hello";
	}
	

	//  登录
	  @PostMapping("login")
	  @ResponseBody
	  public Result<?> login(@RequestParam(defaultValue = "11") String account,
	          @RequestParam(defaultValue = "22") String password){
	      Student res = service.findStudentByAccount(account);
	      System.out.println(account);
	      System.out.println(res);
	      if (res==null){
	    	  System.out.println(0);
	          return Result.error(500,"用户名或密码错误");
	      }
	      System.out.println(1);
	      return Result.success(res,"数据库中已有该学生");
	  }
	  
	

	  
	
}
