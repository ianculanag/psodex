package com.dabi.jar;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dabi.user.User;

@Entity
@Table(name = "jar")
public class Jar {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String description;

	private double percentage;

	private BigDecimal availableBalance;

	private LocalDate dateCreated;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "userId")
	private User user;

	private String color;

	public Jar() {

	}

	public Jar(int id) {
		this.id = id;
	}

	public Jar(String name, String description, double percentage, BigDecimal availableBalance, LocalDate dateCreated,
			User user, String color) {
		this.name = name;
		this.description = description;
		this.percentage = percentage;
		this.availableBalance = availableBalance;
		this.dateCreated = dateCreated;
		this.user = user;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
