package com.syun;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.syun.pojo.Person;

@SpringBootTest
class SpringBoot02ConfigApplicationTests {
	
	@Autowired
	private Person person;
	
	@Test
	void contextLoads() {
		System.out.println(person);
	}

}
