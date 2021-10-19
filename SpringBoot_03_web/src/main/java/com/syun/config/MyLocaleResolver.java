package com.syun.config;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

// 自定義一個語言切換工具，要在MVCConfig中擴充
public class MyLocaleResolver implements LocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		// 獲得請求中的參數
		String language = request.getParameter("l");
		// 沒有參數就使用預設的語言
		Locale locale = Locale.getDefault();
		// 判斷是否有參數
		if(!StringUtils.isEmpty(language)) {
			String[] split = language.split("_");
			locale = new Locale(split[0], split[1]);
		}
		
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		
		
	}
	
}
