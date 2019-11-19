package com.cn.wemi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.wemi.dao.master.AccountMapper;
import com.cn.wemi.model.Account;
import com.cn.wemi.model.AccountExample;
import com.cn.wemi.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	public AccountMapper am;

	@Override
	public long countByExample(AccountExample example) throws Exception {
		return am.countByExample(example);
	}

	@Override
	public int insertSelective(Account record) throws Exception {
		return am.insertSelective(record);
	}

	@Override
	public List<Account> selectByExample(AccountExample example) throws Exception {
		return am.selectByExample(example);
	}
	

}
