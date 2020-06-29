package com.infy.dao;
import com.infy.model.Account;

public interface AccountDao {
public Account getAccountDetailsByAccountId(Integer acccountId);
	
	public void addNewAccount(Account account);
	
	public void deleteAccount(Integer accountId);
	
	public void updateAccount(Integer accountId,Integer balance);

}
