package com.psodex.rest.user;

public class UserBuilder {

	private int id;
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	private String password;
	
	public UserBuilder() {
		
	}

	public UserBuilder(int id, String name, String email, String mobile, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	public UserBuilder id(int id) {
		this.id = id;
		return this;
	}

	public UserBuilder name(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder email(String email) {
		this.email = email;
		return this;
	}

	public UserBuilder mobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public UserBuilder password(String password) {
		this.password = password;
		return this;
	}
	
	public User build() {
		return new User(id, name, email, mobile, password, null);
	}
	
}
