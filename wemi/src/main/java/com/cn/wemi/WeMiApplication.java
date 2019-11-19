package com.cn.wemi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
})
public class WeMiApplication {
	public static void main(String[] args) {
		SpringApplication.run(WeMiApplication.class, args);
	}
}
