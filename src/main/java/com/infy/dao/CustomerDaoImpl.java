package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.entity.AccountEntity;
import com.infy.entity.CustomerEntity;
import com.infy.model.Account;
import com.infy.model.Customer;

@Repository(value = "customerDao")
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Customer getCustomerByCustomerId(Integer CustomerId) {
		
		List<AccountEntity> accountEntities=new ArrayList();
		
		List<Account> accountList=new ArrayList();
		CustomerEntity CustomerEntity=entityManager.find(CustomerEntity.class, CustomerId);
		
	
		Customer Customer=new Customer();
		Customer.setCustomerId(CustomerId);
		Customer.setFirstName(CustomerEntity.getFirst_name());
		Customer.setLastName(CustomerEntity.getLast_name());
		Customer.setEmail(CustomerEntity.getEmail());
		Customer.setAddress(CustomerEntity.getAddress());
		
		accountEntities=CustomerEntity.getAccountEntities();
		
		for(AccountEntity accountEntity:accountEntities) {
			Account account=new Account();
			account.setAccId(accountEntity.getAccId());
			account.setAccountNumber(accountEntity.getAccId());
			account.setBalance(accountEntity.getBalance());
			
			accountList.add(account);
			}
		Customer.setAccounts(accountList);
		return Customer;
	}

	@Override
	public void addNewCustomer(Customer Customer) {
		
		List<AccountEntity> accountEntities=new ArrayList();
		
		List<Account> accountList=new ArrayList();
		
		CustomerEntity CustomerEntity=new CustomerEntity();
		//CustomerEntity.setCustomerId(Customer.getCustomerId());
		CustomerEntity.setFirst_name(Customer.getFirstName());
		CustomerEntity.setLast_name(Customer.getLastName());
		CustomerEntity.setEmail(Customer.getEmail());
		CustomerEntity.setAddress(Customer.getAddress());
		
		accountList=Customer.getAccounts();
		
		for(Account account:accountList) {
			AccountEntity accountEntity=new AccountEntity();
			accountEntity.setAccountNumber(account.getAccountNumber());
			accountEntity.setBalance(account.getBalance());
			
			
			accountEntities.add(accountEntity);
		}
		CustomerEntity.setAccountEntities(accountEntities);
		
		entityManager.persist(CustomerEntity);
		
	}

	@Override
	public void deleteCustomer(Integer CustomerId) {
		
		CustomerEntity CustomerEntity=entityManager.find(CustomerEntity.class, CustomerId);
		entityManager.remove(CustomerEntity);
	}

	@Override
	public void updateCustomer(Integer CustomerId,String emailId) {
		
		
		CustomerEntity CustomerEntity=entityManager.find(CustomerEntity.class, CustomerId);
		
		CustomerEntity.setEmail(emailId);
	}
}
