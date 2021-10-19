package com.syun.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
	
	@Async // 這是一個非同步方法
	public void hello() {
		
		try {
			// 停止三秒才進行後面程式
			Thread.sleep(3000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("資料正在處理中...");
	}
}
