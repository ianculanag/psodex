package com.dabi.jar;

import java.math.BigDecimal;
import java.time.LocalDate;

public class JarRequest {

	private String jarId;

	private String jarName;

	private String description;

	private double percentage;

	private BigDecimal availableBalance;

	private LocalDate dateCreated;

	public JarRequest() {
	}

	public JarRequest(String jarId, String jarName, String description, double percentage,
			BigDecimal availableBalance, LocalDate dateCreated) {
		this.jarId = jarId;
		this.jarName = jarName;
		this.description = description;
		this.percentage = percentage;
		this.availableBalance = availableBalance;
		this.dateCreated = dateCreated;
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

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

}
