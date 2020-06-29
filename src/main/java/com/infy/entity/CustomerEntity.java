package com.infy.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cust_id")
	private Integer CustomerId;
	
	@column(name = "first_name")
	private String first_name;
	
	@column(name = "last_name")
	private String last_name;
	
	@column(name = "email")
	private String email;
	
	@column(name = "address")
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@joinColumn("cust_id")
	private List<AccountEntity> accountEntities;
	
	public Integer getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(Integer customerId) {
		CustomerId = customerId;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<AccountEntity> getAccountEntities() {
		return accountEntities;
	}

	public void setAccountEntities(List<AccountEntity> accountEntities) {
		this.accountEntities = accountEntities;
	}
}
