package com.models;

public class User {
	int id;
	String username;
	String password;
	int userType;
	public User(int id, String username, String password, int userType) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}
	
	public User(String username, String password, int userType) {
		super();
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", password=" + password + ", userType=" + userType + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
}
