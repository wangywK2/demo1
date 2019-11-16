package com.tydic.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.tydic.api.dao.master.DKMapper;
import com.tydic.api.service.DkService;

/**
 *服务启动后执行该配置
 */
@Configuration
public class OnStartUp implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	@Qualifier("dkService")
	private DkService dk;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("服务已启动... ...");
	}

}
