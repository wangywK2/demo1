package com.cn.wemi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cn.wemi.model.Account;
import com.cn.wemi.model.AccountExample;
import com.cn.wemi.model.AccountExample.Criteria;
import com.cn.wemi.service.AccountService;


@Configuration
public class StartUpDo2 implements CommandLineRunner{
	@Autowired
	public AccountService as;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("服务启动... ...");
		System.out.println("count:"+as.countByExample(null));
		
		/*
		 * Account record = new Account(); record.setAccount("测试账号");
		 * System.out.println("count:"+as.insertSelective(record));
		 */
		
		AccountExample example = new AccountExample();
		Criteria cc = example.createCriteria();
		cc.andAccountEqualTo("测试账号");
		List<Account> list = as.selectByExample(example);
		list.forEach(o->System.out.println(o.toString()));
		System.out.println(list.size());
	}
}
