package com.syun.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 允許所有人都可以存取首頁，其首頁功能只有對應權限的人可以存取
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/level1/**").hasRole("L1")
		.antMatchers("/level2/**").hasRole("L2")
		.antMatchers("/level3/**").hasRole("L3");
		
		// 沒有權限預設則發送/login請求，轉到登入頁面
		// 前端頁面要記得設定name參數，預設參數名為username、password，可使用usernameParameter()、passwordParameter()更換預設參數名
		http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");
		
		// 關閉csrf功能，有時候不關閉會出問題，如登出跳出404錯誤
		http.csrf().disable();
		
		// 實現登出功能，發出請求/logout登出，並返回首頁
		http.logout().logoutSuccessUrl("/");
		
		// 記住密碼功能，利用cookie及session，預設保存二周
		// rememberMeParameter("remember")中的remember為前端參數名
		http.rememberMe().rememberMeParameter("remember");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// inMemoryAuthentication可自己建立帳號密碼
		// 一般都是使用jdbcAuthentication()進資料庫讀取下面所需的資訊
		// 密碼需要加密，不然有可能會報錯，Error：PasswordEncoder
		// spring security 5.0以上版本新增多個加密方式
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
			.withUser("syun").password(new BCryptPasswordEncoder().encode("123456")).roles("L2","L3")
			.and()
			.withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("L1","L2","L3")
			.and()
			.withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("L1");
	}
	
	
}
