package com.syun.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
	
	// cron表達式 = 秒 分 時 日 月 星期幾
	// 每天的第0秒執行此方法
	@Scheduled(cron = "0 * * * * 0-7")
	public void hello() {
		System.out.println("hello方法執行...");
	}
}
