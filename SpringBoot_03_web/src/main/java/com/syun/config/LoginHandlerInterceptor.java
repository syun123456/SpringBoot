package com.syun.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object loginUser = request.getSession().getAttribute("loginUser");
		
		if(loginUser == null) {
			request.setAttribute("msg", "沒有權限，請先登入");
			request.getRequestDispatcher("/login.html").forward(request, response);
			return false;
		}
		else {
			return true;
		}
	}
	
}
