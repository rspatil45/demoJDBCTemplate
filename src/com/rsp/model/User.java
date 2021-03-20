package com.rsp.model;

public class User {
	String firstname;
	String lastname;
	String email;
	String password;
	@Override
	public String toString() {
		return "UserBean [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password="
				+ password + "]";
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
