package com.syun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syun.service.AsyncService;

@RestController
public class AsyncController {
	
	@Autowired
	AsyncService asyncService;
	
	@RequestMapping("/hello")
	public String hello() {
		asyncService.hello();
		return "OK";
	}
}
