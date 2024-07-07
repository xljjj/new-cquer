package com.cqu.NewCQUer.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cqu.NewCQUer.pojo.Dormitory;
import com.cqu.NewCQUer.pojo.Student;

/**
 * 接口设计
 * 
 * */

@Service
public interface StudentService {
	
	//由性别查看学生数量
	int countSexNumber(String sex);
	
	//由专业查看学生数量
	int countMajorNumber(String major);
	
	//由年龄查看学生数量
	int countAgeNumber(int age1, int age2);
	
	//由省份查看学生数量
	int countProvinceNumber(String province);

	//查询特定学号的学生
	Student findStudentByAccount(String account);
	
	//查询所有学生的信息
	ArrayList<Student> findAllStudent();
	
	//查询某一省份所有学生的信息
	ArrayList<Student> findAllStudentByProvince(String province);
	
	//向数据库加入学生
	void insertStudent(Student student);
	
	//向数据库删除学生
	void deleteStudent(String account);
	
	//更新数据库中的学生信息
	void updateStudent(Student student);
	
	//查询同省份学生信息
	ArrayList<Student> findSameProvince(String province);
	
	//把学生插入交友贴，即chat表
	void insertStudentChat(Student studednt);
	
	//把学生从交友贴，即chat表中删除
	void deleteStudentChat(Student studednt);
	
	//查询chat表中所有学生的信息
	ArrayList<Student> findAllStudentChat();
	
	//从chat表中查找特定学号的学生
	Student findStudentChatByAccount(String account);
	
	//把宿舍四人信息填入dormitory表单
	void insertDormitory(Dormitory dormitory);

	//获取dormitory表单中的信息
	ArrayList<Dormitory> findAllDorm();
}
