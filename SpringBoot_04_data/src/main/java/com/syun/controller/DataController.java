package com.syun.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
	
	// Template是SpringBoot配置好的模板
	// JdbcTemplate是SpringBoot配置好的JBDC常用指令，已經封裝成一個bean，可直接注入使用其中的方法
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping("/userList")
	public List<Map<String, Object>> userList(){
		String sql = "select * from mybatis_user";
		
		List<Map<String, Object>> listMaps = jdbcTemplate.queryForList(sql);
		
		return listMaps;
	}
	
	@GetMapping("/addUser")
	public String addUser() {
		String sql = "insert into mybatis_user (id, name, pwd) values (9, 'testtest', 'springboot')";
		jdbcTemplate.update(sql);
		return "add finished";
	}
	
	@GetMapping("/updateUser/{id}")
	public String updateUser(@PathVariable("id") int id) {
		String sql = "update mybatis_user set name=?, pwd=? where id="+id;
		
		Object[] objects = new Object[2];
		objects[0] = "updateTest";
		objects[1] = "chenshihsyun";
		
		jdbcTemplate.update(sql, objects);
		
		return "update finished";	
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		String sql = "delete from mybatis_user where id = ?";
		
		jdbcTemplate.update(sql, id);
		
		return "delete finished";
		
	}
}
