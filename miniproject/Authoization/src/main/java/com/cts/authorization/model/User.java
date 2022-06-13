package com.cts.authorization.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	

	

	public User(int id,String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String username;
	
	private String password;
	
}