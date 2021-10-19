package com.syun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync // 開啟非同步註解
@EnableScheduling // 開啟排程註解
@SpringBootApplication
public class SpringBoot08TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot08TaskApplication.class, args);
	}

}
