package com.cqu.NewCQUer.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cqu.NewCQUer.pojo.Dormitory;
import com.cqu.NewCQUer.pojo.Student;

/**
 * 接口设计 
 * */


@Mapper
public interface StudentMapper {
	
	//向数据库中加入学生的必填信息
	void addStudentRequired(Student student);
	
	//向数据库中加入学生的选填信息
	void addStudentOptional(Student student);
	
	//通过学号向数据库中删除学生
	void deleteStudent(Student student);
	
	//更新数据库中的学生信息
	void updateStudent(Student student);
	
	//查询所有学生的信息
	ArrayList<Student> findAllStudent();
	
	//查询某一省份所有学生的信息
	ArrayList<Student> findAllStudentByProvince(String province);

	//查询特定学号的学生
	Student findStudentByAccount(String account);
	
	//由性别查看学生数量
	int countSexNumber(String sex);

	//由专业查看学生数量
	int countMajorNumber(String major);
	
	//由年龄查看学生数量，这里设置了两个输入参数，
	//可以查询[age1，age2]年龄段区间的人数，也可以查询某一个年龄的人数（age1=age2）
	int countAgeNumber(@Param("age1") int age1,@Param("age2")int age2);
	
	//由省份查看学生数量
	int countProvinceNumber(String province);
	
	//查询同省份学生信息
	ArrayList<Student> findSameProvince(String province);
	
	//把学生插入交友贴，即chat表
	void addStudentChat(Student studednt);
	
	//把学生从交友贴，即chat表中删除
	void deleteStudentChat(Student studednt);
	
	//查询chat表中所有学生的信息
	ArrayList<Student> findAllStudentChat();
	
	//从chat表中查找特定学号的学生
	Student findStudentChatByAccount(String account);
	
	//把宿舍四人信息填入dormitory表单
	void addDormitory(Dormitory dormitory);
	
	//获取dormitory表单中的信息
	ArrayList<Dormitory> findAllDorm();

}
