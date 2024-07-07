package com.cqu.NewCQUer.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.NewCQUer.mapper.AdministratorMapper;
import com.cqu.NewCQUer.pojo.Administrator;
import com.cqu.NewCQUer.service.AdministratorService;


@Service
public class AdministratorServiceImpl implements AdministratorService{
	
	@Autowired
	AdministratorMapper mapper;
	
	@Override
	//向数据库中加入新的管理员
	public void insertAdministrator(Administrator admin) {
		mapper.addAdministrator(admin);
	}
	
	//删除管理员
	public void deleteAdministrator(Administrator admin) {
		mapper.deleteAdministrator(admin);
	}
	
	//更新数据库中的管理员信息
	public void updateAdministrator(Administrator admin) {
		mapper.updateAdministrator(admin);
	}
	
	//查询所有管理员的信息
	public ArrayList<Administrator> findAllAdministrator() {
		ArrayList<Administrator> admins= mapper.findAllAdministrator();
		return admins;
	}

	//查询特定账号的管理员
	public Administrator findAdministratorByAccount(String account) {
		Administrator admin = mapper.findAdministratorByAccount(account);
		return admin;
	}
}
