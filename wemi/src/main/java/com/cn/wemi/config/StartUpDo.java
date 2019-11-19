package com.cn.wemi.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
@Configuration
public class StartUpDo implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("服務啟動");
	}

}
