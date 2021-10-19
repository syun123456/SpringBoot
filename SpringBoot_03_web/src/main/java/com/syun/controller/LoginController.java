package com.syun.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@RequestMapping("/user/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
		if(!StringUtils.isEmpty(username) && password.equals("123456")) {
			session.setAttribute("loginUser", username);
			return "redirect:/main.html";
		}
		else {
			model.addAttribute("msg", "帳號或密碼錯誤");
			return "index";
		}
	}
	
	@RequestMapping("/user/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index.html";
	}
}
