package com.money.account;

import java.math.BigDecimal;

public class AccountRequest {

	private String accountNumber;
	
	private String accountName;
	
	private BigDecimal initialBalance;
	
	private BigDecimal currentBalance;
	
	private String description;
	
	private String issuingBank;
	
	public AccountRequest() {}
	
	public AccountRequest(String accountNumber, String accountName, BigDecimal initialBalance, BigDecimal currentBalance, String description, String issuingBank) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.initialBalance = initialBalance;
		this.currentBalance = currentBalance;
		this.description = description;
		this.issuingBank = issuingBank;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
