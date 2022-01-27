package com.psodex.rest.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.psodex.rest.account.Account;
import com.psodex.rest.jar.Jar;
import com.psodex.rest.user.User;

public class TransactionBuilder {

	private TransactionType type;

	private String details;

	private BigDecimal amount;

	private LocalDate date;

	private Account inboundAccount;

	private Account outboundAccount;

	private Jar jar;

	private User user;

	public TransactionBuilder() {

	}

	public TransactionBuilder(TransactionType type, String details, BigDecimal amount, LocalDate date,
			Account inboundAccount, Account outboundAccount, Jar jar, User user) {
		this.type = type;
		this.details = details;
		this.amount = amount;
		this.date = date;
		this.inboundAccount = inboundAccount;
		this.outboundAccount = outboundAccount;
		this.jar = jar;
		this.user = user;
	}

	public TransactionBuilder type(TransactionType type) {
		this.type = type;
		return this;
	}

	public TransactionBuilder details(String details) {
		this.details = details;
		return this;
	}

	public TransactionBuilder amount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public TransactionBuilder date(LocalDate date) {
		this.date = date;
		return this;
	}

	public TransactionBuilder inboundAccount(Account inboundAccount) {
		this.inboundAccount = inboundAccount;
		return this;
	}

	public TransactionBuilder outboundAccount(Account outboundAccount) {
		this.outboundAccount = outboundAccount;
		return this;
	}

	public TransactionBuilder jar(Jar jar) {
		this.jar = jar;
		return this;
	}

	public TransactionBuilder user(User user) {
		this.user = user;
		return this;
	}

	public Transaction build() {
		return new Transaction(type, details, amount, date, inboundAccount, outboundAccount, jar, user);
	}

}
