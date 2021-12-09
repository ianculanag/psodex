package com.money.account;

import java.math.BigDecimal;

public class AccountResponse {
	
	private int accountId;
	
	private String accountNumber;
	
	private String accountName;
	
	private BigDecimal initialBalanceRaw;
	
	private String initialBalance;
	
	private BigDecimal currentBalanceRaw;
	
	private String currentBalance;
	
	private String description;
	
	private String issuingBank;

	public AccountResponse(int accountId, String accountNumber, String accountName, BigDecimal initialBalanceRaw,
			BigDecimal currentBalanceRaw, String description, String issuingBank) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.initialBalanceRaw = initialBalanceRaw;
		this.currentBalanceRaw = currentBalanceRaw;
		this.description = description;
		this.issuingBank = issuingBank;
		doAfterCreation();
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
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

	public BigDecimal getInitialBalanceRaw() {
		return initialBalanceRaw;
	}

	public void setInitialBalanceRaw(BigDecimal initialBalanceRaw) {
		this.initialBalanceRaw = initialBalanceRaw;
	}

	public String getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(String initialBalance) {
		this.initialBalance = initialBalance;
	}

	public BigDecimal getCurrentBalanceRaw() {
		return currentBalanceRaw;
	}

	public void setCurrentBalanceRaw(BigDecimal currentBalanceRaw) {
		this.currentBalanceRaw = currentBalanceRaw;
	}

	public String getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(String currentBalance) {
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

	private void doAfterCreation() {
		this.initialBalance = String.format("%,.2f",
				this.initialBalanceRaw == null ? 0 : this.initialBalanceRaw.doubleValue());
		this.currentBalance = String.format("%,.2f",
				this.currentBalanceRaw == null ? 0 : this.currentBalanceRaw.doubleValue());
	}
	
}
