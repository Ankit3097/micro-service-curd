package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.AccountDao;
import com.infy.model.Account;

@Service(value = "accountService")
@Transactional
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDao accountDao;

	@Override
	public Account getAccountDetailsByAccountId(Integer accountId) {
		
		Account account=new Account();
		if(accountId!=null) {
			account=accountDao.getAccountDetailsByAccountId(accountId);
		}
		return account;
	}
	
	@Override
	public void addNewAccount(Account account) {
		
		if(account!=null) {
			accountDao.addNewAccount(account);
		}
	}

	@Override
	public void deleteAccount(Integer accId) {
		
		if(accId!=null) {
			accountDao.deleteAccount(accId);
		}
	}

	@Override
	public void updateAccount(Integer accId, Integer balance) {
		
		accountDao.updateAccount(accId, balance);
	}
}
