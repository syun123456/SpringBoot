package com.syun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.syun.mapper")
public class SpringBoot05MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot05MybatisApplication.class, args);
	}

}
