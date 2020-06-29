package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.CustomerDao;
import com.infy.model.Customer;

@Service(value = "CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer getCustomerByCustomerId(Integer customerId) {
	
		
		Customer customer = new Customer();
		if(customerId!=null) {
			customer=CustomerDao.getCustomerByCustomerId(customerId);
		}
		return Customer;
	}

	@Override
	public void addNewCustomer(Customer customer) {
		if(customer!=null)
		CustomerDao.addNewCustomer(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		
		if(customerId!=null)
			CustomerDao.deleteCustomer(customerId);
	}

	@Override
	public void updateCustomer(Integer customerId, String emailId) {
		
		CustomerDao.updateCustomer(customerId, emailId);
		
	}
	
	

}
