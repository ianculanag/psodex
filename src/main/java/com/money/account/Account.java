package com.money.account;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue
	private int id;
	
	private String accountNumber;
	
	private String name;
	
	private BigDecimal initialBalance;
	
	private BigDecimal currentBalance;
	
	private String description;
	
	private String issuingBank;

	public Account() {

	}

	public Account(String accountNumber, String name, BigDecimal initialBalance, BigDecimal currentBalance,
			String description, String issuingBank) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.initialBalance = initialBalance;
		this.currentBalance = currentBalance;
		this.description = description;
		this.issuingBank = issuingBank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(BigDecimal initialBalance) {
		this.initialBalance = initialBalance;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIssuingBank() {
		return issuingBank;
	}

	public void setIssuingBank(String issuingBank) {
		this.issuingBank = issuingBank;
	}

}
