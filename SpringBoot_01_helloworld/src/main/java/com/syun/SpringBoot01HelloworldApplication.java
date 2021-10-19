package com.syun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//這裡為程式主入口不可隨意更改，所有新建立的java類或套件都要在程式主入口的套件下，不然會報錯

@SpringBootApplication // 底層為Spring的組件(Component)
public class SpringBoot01HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01HelloworldApplication.class, args);
	}

}
