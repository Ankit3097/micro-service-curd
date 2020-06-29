package com.infy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="acc_id")
	private Integer accId;
	
	@Column(name="balance")
	private Integer balance;
	
	
	@Column(name="acc_no")
	private Integer accountNumber;


	public Integer getAccId() {
		return accId;
	}


	public void setAccId(Integer accId) {
		this.accId = accId;
	}


	public Integer getBalance() {
		return balance;
	}


	public void setBalance(Integer balance) {
		this.balance = balance;
	}


	public Integer getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}


}
