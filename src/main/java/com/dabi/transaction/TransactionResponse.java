package com.dabi.transaction;

public class TransactionResponse {

	private String transactionId;

	private String transactionAmount;

	private String transactionDate;

	private String details;

	private String transactionType;

	private String inboundAccountId;

	private String inboundAccountName;

	private String outboundAccountId;

	private String outboundAccountName;

	public TransactionResponse(String transactionId, String transactionAmount, String transactionDate,
			String details, String transactionType, String inboundAccountId, String inboundAccountName,
			String outboundAccountId, String outboundAccountName) {
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

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
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

	public String getInboundAccountId() {
		return inboundAccountId;
	}

	public void setInboundAccountId(String inboundAccountId) {
		this.inboundAccountId = inboundAccountId;
	}

	public String getInboundAccountName() {
		return inboundAccountName;
	}

	public void setInboundAccountName(String inboundAccountName) {
		this.inboundAccountName = inboundAccountName;
	}

	public String getOutboundAccountId() {
		return outboundAccountId;
	}

	public void setOutboundAccountId(String outboundAccountId) {
		this.outboundAccountId = outboundAccountId;
	}

	public String getOutboundAccountName() {
		return outboundAccountName;
	}

	public void setOutboundAccountName(String outboundAccountName) {
		this.outboundAccountName = outboundAccountName;
	}

}
