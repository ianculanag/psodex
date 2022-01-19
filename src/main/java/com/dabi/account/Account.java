package com.dabi.account;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dabi.user.User;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue
	private int id;

	private String accountNumber;

	private String name;

	private BigDecimal balance;

	private String description;

	private String issuingBank;
	
	@OneToOne(targetEntity = User.class)
	@JoinColumn(name = "userId")
	private User user;

	public Account() {

	}

	public Account(int id) {
		this.id = id;
	}

	public Account(String accountNumber, String name, BigDecimal balance, String description, String issuingBank, User user) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.description = description;
		this.issuingBank = issuingBank;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
