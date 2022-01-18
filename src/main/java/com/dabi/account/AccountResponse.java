package com.dabi.account;

public class AccountResponse {

	private String accountId;

	private String accountNumber;

	private String accountName;

	private String balanceRaw;

	private String balance;

	private String description;

	private String issuingBank;

	public AccountResponse(String accountId, String accountNumber, String accountName, String balanceRaw,
			String description, String issuingBank) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balanceRaw = balanceRaw;
		this.description = description;
		this.issuingBank = issuingBank;
		doAfterCreation();
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
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

	public String getBalanceRaw() {
		return balanceRaw;
	}

	public void setBalanceRaw(String balanceRaw) {
		this.balanceRaw = balanceRaw;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
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

	private void doAfterCreation() {
		this.balance = String.format("%,.2f", this.balanceRaw == null ? 0 : Double.valueOf(this.balanceRaw));
	}

}
