package com.dabi.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionRequest {

	private BigDecimal transactionAmount;

	private String transactionDetails;

	private LocalDate transactionDate;
	
	private int inboundAccountId;
	
	private int outboundAccountId;
	
	private int jarId;
	
	private String transactionType;
	
	public TransactionRequest() {
		
	}
	
	public TransactionRequest(BigDecimal transactionAmount, String transactionDetails, LocalDate transactionDate,
			int inboundAccountId, int outboundAccountId, int jarId, String transactionType) {
		super();
		this.transactionAmount = transactionAmount;
		this.transactionDetails = transactionDetails;
		this.transactionDate = transactionDate;
		this.inboundAccountId = inboundAccountId;
		this.outboundAccountId = outboundAccountId;
		this.jarId = jarId;
		this.transactionType = transactionType;
	}
	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getInboundAccountId() {
		return inboundAccountId;
	}

	public void setInboundAccountId(int inboundAccountId) {
		this.inboundAccountId = inboundAccountId;
	}

	public int getOutboundAccountId() {
		return outboundAccountId;
	}

	public void setOutboundAccountId(int outboundAccountId) {
		this.outboundAccountId = outboundAccountId;
	}

	public int getJarId() {
		return jarId;
	}

	public void setJarId(int jarId) {
		this.jarId = jarId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
