package com.cn.wemi.service;

import java.util.List;

import com.cn.wemi.model.Account;
import com.cn.wemi.model.AccountExample;

public interface AccountService {
	
	long countByExample(AccountExample example) throws Exception;
	
	int insertSelective(Account record) throws Exception;
	List<Account> selectByExample(AccountExample example) throws Exception;
}
