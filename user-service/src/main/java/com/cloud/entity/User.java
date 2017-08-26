package com.cloud.entity;

public class User {
	private Role role;
	private String name;
	
	public User(String name) {
		setName(name);
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
