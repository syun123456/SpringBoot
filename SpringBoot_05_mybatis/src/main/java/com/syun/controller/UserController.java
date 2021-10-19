package com.syun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.syun.mapper.UserMapper;
import com.syun.pojo.User;

@RestController
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/queryUserList")
	public List<User> queryUserList(){
		List<User> userList = userMapper.queryUserList();
		return userList;
	}
	
	@GetMapping("/queryUserById/{id}")
	public User queryUserById(@PathVariable("id") int id) {
		User user = userMapper.queryUserById(id);
		return user;
	}
	
	@GetMapping("/addUser")
	public String addUser() {
		userMapper.addUser(new User(6, "mybatisTest", "123456789"));
		return "add Finished";
	}
	
	@GetMapping("/updateUser")
	public String updateUser() {
		userMapper.updateUser(new User(6, "update", "update"));
		return "update Finished";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userMapper.deleteUser(id);
		return "delete Finished";
	}
}
