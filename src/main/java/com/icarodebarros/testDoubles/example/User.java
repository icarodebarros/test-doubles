package com.icarodebarros.testDoubles.example;

import java.time.LocalDateTime;

public class User {
	private String username;
	private LocalDateTime creationTime;
	
	public User(String username, LocalDateTime creationTime) {
		this.username = username;
		this.creationTime = creationTime;
	}
	
	public String getUsername() {
		return username;
	}
	
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
}
