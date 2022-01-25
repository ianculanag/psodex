package com.psodex.rest.jar;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JarResponse {

	private String jarId;

	private String jarName;

	private String description;

	private String percentage;

	@JsonIgnore
	private BigDecimal availableBalanceRaw;

	private String availableBalance;

	private String dateCreated;

	public JarResponse() {
	}

	public JarResponse(String jarId, String jarName, String description, String percentage,
			BigDecimal availableBalanceRaw, String dateCreated) {
		this.jarId = jarId;
		this.jarName = jarName;
		this.description = description;
		this.percentage = percentage;
		this.availableBalanceRaw = availableBalanceRaw;
		this.dateCreated = dateCreated;
		doAfterCreation();
	}

	public String getJarId() {
		return jarId;
	}

	public void setJarId(String jarId) {
		this.jarId = jarId;
	}

	public String getJarName() {
		return jarName;
	}

	public void setJarName(String jarName) {
		this.jarName = jarName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public BigDecimal getAvailableBalanceRaw() {
		return availableBalanceRaw;
	}

	public void setAvailableBalance(BigDecimal availableBalanceRaw) {
		this.availableBalanceRaw = availableBalanceRaw;
	}

	public String getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(String availableBalance) {
		this.availableBalance = availableBalance;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	private void doAfterCreation() {
		this.availableBalance = String.format("%,.2f",
				this.availableBalanceRaw == null ? 0 : this.availableBalanceRaw.doubleValue());
	}

}
