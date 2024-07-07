package com.cqu.NewCQUer.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.cqu.NewCQUer.pojo.Administrator;

/**
 * 接口设计 
 * */

@Mapper
public interface AdministratorMapper {
	
	//向数据库中加入新的管理员
	void addAdministrator(Administrator admin);
	
	//删除管理员
	void deleteAdministrator(Administrator admin);
	
	//更新数据库中的管理员信息
	void updateAdministrator(Administrator admin);
	
	//查询所有管理员的信息
	ArrayList<Administrator> findAllAdministrator();

	//查询特定账号的管理员
	Administrator findAdministratorByAccount(String account);
}
