package com.tarena.chapter03.intentdemo2;

import java.io.Serializable;

public class User implements Serializable {
	private String userName;
	private String userPassword;

	public User() {
	}

	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}