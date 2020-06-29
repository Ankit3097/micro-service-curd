package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.entity.AccountEntity;
import com.infy.entity.CustomerEntity;
import com.infy.model.Account;
import com.infy.model.Customer;


@Repository(value = "CustomerDao")
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public Account getAccountDetailsByAccountId(Integer accountId) {
		
		AccountEntity accountEntity=entityManager.find(AccountEntity.class, accountId);
		Account account=new Account();
		account.setAccId(accountEntity.getAccId());
		account.setAccountNumber(accountEntity.getAccountNumber());
		account.setBalance(accountEntity.getBalance());
		return account;
	}

	@Override
	public void addNewAccount(Account account) {
		AccountEntity accountEntity=new AccountEntity();
		accountEntity.setAccId(account.getAccId());
		accountEntity.setBalance(account.getBalance());
		accountEntity.setAccountNumber(account.getBalance());

		entityManager.persist(accountEntity);
		
	}

	@Override
	public void deleteAccount(Integer accountId) {
		AccountEntity accountEntity=entityManager.find(AccountEntity.class, accountId);
		entityManager.remove(accountEntity);
	}

	@Override
	public void updateAccount(Integer accountId, Integer balance) {
		AccountEntity accountEntity=entityManager.find(AccountEntity.class, accountId);
		accountEntity.setBalance(balance);
		
	}
}
