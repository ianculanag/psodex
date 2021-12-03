package com.money.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.money.account.Account;
import com.money.jar.Jar;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue
	private int id;

	private TransactionType type;

	private String details;

	private BigDecimal amount;

	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "inboundAccountId")
	private Account inboundAccount;

	@ManyToOne
	@JoinColumn(name = "outboundAccountId")
	private Account outboundAccount;
	
	@ManyToOne
	@JoinColumn(name = "jarId")
	private Jar jar;
	
	public Transaction() {
		
	}

	public Transaction(TransactionType type, String details, BigDecimal amount, LocalDate date,
			Account inboundAccount, Account outboundAccount, Jar jar) {
		this.type = type;
		this.details = details;
		this.amount = amount;
		this.date = date;
		this.inboundAccount = inboundAccount;
		this.outboundAccount = outboundAccount;
		this.jar = jar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Account getInboundAccount() {
		return inboundAccount;
	}

	public void setInboundAccount(Account inboundAccount) {
		this.inboundAccount = inboundAccount;
	}

	public Account getOutboundAccount() {
		return outboundAccount;
	}

	public void setOutboundAccount(Account outboundAccount) {
		this.outboundAccount = outboundAccount;
	}

	public Jar getJar() {
		return jar;
	}

	public void setJar(Jar jar) {
		this.jar = jar;
	}

}
