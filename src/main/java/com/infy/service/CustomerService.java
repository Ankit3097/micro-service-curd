package com.infy.service;

import com.infy.model.Customer;

public interface CustomerService {
	
public Customer getCustomerByCustomerId(Integer customerId);
	
	public void addNewCustomer(Customer customer);
	
	public void deleteCustomer(Integer customerId);

	public void updateCustomer(Integer customerId, String emailId);

}
