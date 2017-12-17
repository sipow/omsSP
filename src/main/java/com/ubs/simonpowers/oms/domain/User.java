package com.ubs.simonpowers.oms.domain;

public class User implements MyIdentifiable {
	private Long userId;
	private String forname;
	private String surname;
	private long balance;
	// TODO - Username and Password
	
	public User(long userId, String forename, String surname, long balance) {
		this.userId = userId;
		this.balance = balance;
		this.forname = forename;
		this.surname = surname;
	}
	
	public Long getId() {
		return userId;
	}
	public void setId(Long userId) {
		this.userId = userId;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getForname() {
		return forname;
	}
	public void setForname(String forname) {
		this.forname = forname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
}
