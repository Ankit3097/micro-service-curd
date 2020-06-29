package com.infy.dao;

import com.infy.model.Customer;

public interface CustomerDao {

	public Customer getCustomerByCustomerId(Integer CustomerId);
	
	public void addNewCustomer(Customer customer);
	
	public void deleteCustomer(Integer customerId);
	
	public void updateCustomer(Integer CustomerId,String emailId);
}
