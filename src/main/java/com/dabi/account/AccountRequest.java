package com.dabi.account;

import java.math.BigDecimal;

public class AccountRequest {

	private String accountNumber;

	private String accountName;

	private BigDecimal balance;

	private String description;

	private String issuingBank;

	public AccountRequest() {
	}

	public AccountRequest(String accountNumber, String accountName, BigDecimal balance, String description,
			String issuingBank) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balance = balance;
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

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
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
