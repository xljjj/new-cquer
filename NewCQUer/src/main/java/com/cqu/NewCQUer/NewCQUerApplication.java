package com.cqu.NewCQUer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.cqu.NewCQUer.mapper")
public class NewCQUerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewCQUerApplication.class, args);
	}

}
