package com.syun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	// http://localhost:8080/hello/h1
	@RequestMapping("/h1")
	@ResponseBody
	public String hello() {
		return "Hello，SpringBoot";
	}
}
