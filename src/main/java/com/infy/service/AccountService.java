package com.infy.service;

import com.infy.model.Account;

public interface AccountService {
	
public Account getAccountDetailsByAccountId(Integer accountId);
	
	public void addNewAccount(Account account);
	
	public void deleteAccount(Integer accId);
	
	public void updateAccount(Integer accId,Integer balance);
}
