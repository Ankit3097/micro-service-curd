package com.infy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.model.Customer;
import com.infy.service.CustomerService;

@RestController
@RequestMapping("/CustomerAPI")
public class CustomerApi {

	@Autowired
	private Environment environment;
	
	@Autowired
	CustomerService CustomerService;
	
	
	
	@GetMapping("/getCustomer/{CustomerId}")
	public ResponseEntity<Customer> fetchCustomer(@PathVariable Integer CustomerId){
	
		ResponseEntity<Customer> responseEntity=null;
		Customer Customer=CustomerService.getCustomerByCustomerId(CustomerId);
		responseEntity=new ResponseEntity<Customer>(Customer, HttpStatus.OK);
		return responseEntity;
		
	
}
	@PostMapping("/addCustomer/Customer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer Customer){
		
		ResponseEntity<String> responseEntity=null;
		String message=null;
		
		CustomerService.addNewCustomer(Customer);
		message=environment.getProperty("Customer_API.SUCCESSFUL_ADDITION");
		responseEntity=new ResponseEntity<String>(message, HttpStatus.CREATED);
		return responseEntity;
		
	}
	
	@PostMapping("/deleteCustomer/{CustomerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer CustomerId){
		
		ResponseEntity<String> responseEntity=null;
		String message=null;
		
		CustomerService.deleteCustomer(CustomerId);
		message=environment.getProperty("Customer_API.SUCCESSFUL_DELETION");
		responseEntity=new ResponseEntity<String>(message, HttpStatus.OK);
		return responseEntity;
	
	}
	
	@PutMapping("updateCustomer/Customer/{CustomerId}")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer  Customer,@PathVariable Integer CustomerId){
		
		ResponseEntity<String> responseEntity=null;
		String message=null;
		
		CustomerService.updateCustomer(CustomerId, Customer.getEmail());
		
		message=environment.getProperty("Customer_API.SUCCESSFUL_UPDATION");
		responseEntity=new ResponseEntity<String>(message, HttpStatus.OK);
		return responseEntity;
	}
	
}

