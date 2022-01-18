package com.dabi.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionResponse {

	private int transactionId;

	private BigDecimal transactionAmount;

	private LocalDate transactionDate;

	private String details;

	private String transactionType;

	private int inboundAccountId;

	private String inboundAccountName;

	private int outboundAccountId;

	private String outboundAccountName;

	public TransactionResponse(int transactionId, BigDecimal transactionAmount, LocalDate transactionDate,
			String details, String transactionType, int inboundAccountId, String inboundAccountName,
			int outboundAccountId, String outboundAccountName) {
		this.transactionId = transactionId;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.details = details;
		this.transactionType = transactionType;
		this.inboundAccountId = inboundAccountId;
		this.inboundAccountName = inboundAccountName;
		this.outboundAccountId = outboundAccountId;
		this.outboundAccountName = outboundAccountName;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getInboundAccountId() {
		return inboundAccountId;
	}

	public void setInboundAccountId(int inboundAccountId) {
		this.inboundAccountId = inboundAccountId;
	}

	public String getInboundAccountName() {
		return inboundAccountName;
	}

	public void setInboundAccountName(String inboundAccountName) {
		this.inboundAccountName = inboundAccountName;
	}

	public int getOutboundAccountId() {
		return outboundAccountId;
	}

	public void setOutboundAccountId(int outboundAccountId) {
		this.outboundAccountId = outboundAccountId;
	}

	public String getOutboundAccountName() {
		return outboundAccountName;
	}

	public void setOutboundAccountName(String outboundAccountName) {
		this.outboundAccountName = outboundAccountName;
	}

}
