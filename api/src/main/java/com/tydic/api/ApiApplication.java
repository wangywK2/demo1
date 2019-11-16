package com.tydic.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.tydic.api.tool.DateUtil;


@SpringBootApplication
@EnableScheduling
public class ApiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	
	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { 
		return builder.sources(ApiApplication.class);
	}
	 
	
	@Scheduled(cron = "0 0/1 * * * ?")
	void test() {
		System.out.println(DateUtil.getNow()+":尝试获取所");
		synchronized (this) {
			System.out.println(DateUtil.getNow()+":123456123456");
			try {
				Thread.sleep(120000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
