package com.cqu.NewCQUer.service.impl;


import com.cqu.NewCQUer.pojo.Dormitory;
import com.cqu.NewCQUer.pojo.Student;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.NewCQUer.mapper.StudentMapper;
import com.cqu.NewCQUer.service.StudentService;
/**
 * 服务层的实现类
 *
 */

@Service
public class StudentServiceImpl implements StudentService {
	
	//把这个mapper对象自动注入spring容器
	@Autowired
	StudentMapper mapper;
	
	@Override
	//由性别查看学生数量
	public int countSexNumber(String sex) {
		int countSexNumber = mapper.countSexNumber(sex);
		return countSexNumber;
	}
	
	@Override
	//由专业查看学生数量
	public int countMajorNumber(String major) {
		int countMajorNumber = mapper.countMajorNumber(major);
		return countMajorNumber;
	}
	
	@Override
	//由年龄查看学生数量(两个参数)
	public int countAgeNumber(int age1, int age2) {
		int countAgeNumber = mapper.countAgeNumber(age1,age2);
		return countAgeNumber;
	}
	
	@Override
	//由省份查看学生数量
	public int countProvinceNumber(String province) {
		int countProvinceNumber = mapper.countProvinceNumber(province);
		return countProvinceNumber;
	}

	@Override
	//查询特定学号（账号）的学生
	public Student findStudentByAccount(String account) {
		Student findStudentByAccount = mapper.findStudentByAccount(account);
		return findStudentByAccount;
	}
		
	@Override
	//查询所有学生的信息
	public ArrayList<Student> findAllStudent(){
		ArrayList<Student> students = new ArrayList<>();
		students = mapper.findAllStudent();
		return students;
	}
	
	@Override
	//查询某一省份所有学生的信息
	public ArrayList<Student> findAllStudentByProvince(String province){
		ArrayList<Student> stuProvince = mapper.findAllStudentByProvince(province);
		return stuProvince;
	}
	
	@Override
	//向数据库加入学生
	public void insertStudent(Student student) {
		mapper.addStudentRequired(student);
		mapper.addStudentOptional(student);
	}
	
	@Override
	//向数据库删除学生
	public void deleteStudent(String account) {
		Student student = new Student();
		student.setAccount(account);
		mapper.deleteStudent(student);
	}

	@Override
	//更新数据库中的学生信息
	public void updateStudent(Student student) {
		mapper.updateStudent(student);
	}
	
	@Override
	//查询同省份学生信息
	public ArrayList<Student> findSameProvince(String province) {
		ArrayList<Student> students = mapper.findSameProvince(province);
		return students;
	}
	
	@Override
	//把学生插入交友贴，及chat表
	public void insertStudentChat(Student studednt) {
		mapper.addStudentChat(studednt);
	}
	
	@Override
	//把学生从交友贴，即chat表中删除
	public void deleteStudentChat(Student studednt) {
		mapper.deleteStudentChat(studednt);
	}
	
	@Override
	//查询chat表中所有学生的信息
	public ArrayList<Student> findAllStudentChat(){
		ArrayList<Student> students = mapper.findAllStudentChat();
		return students;
	}
	
	@Override
	//从chat表中查找特定学号的学生
	public Student findStudentChatByAccount(String account) {
		Student student = mapper.findStudentChatByAccount(account);
		return student;
	}
	
	@Override
	//把宿舍四人信息填入dormitory表单
	public void insertDormitory(Dormitory dormitory) {
		mapper.addDormitory(dormitory);
	}
	
	@Override
	//获取dormitory表单中的信息
	public ArrayList<Dormitory> findAllDorm(){
		ArrayList<Dormitory> dormitories = mapper.findAllDorm();
		return dormitories;
	}
}