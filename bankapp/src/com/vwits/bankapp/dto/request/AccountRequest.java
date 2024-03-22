package com.vwits.bankapp.dto.request;

//this is DTO class which is used to accept data (request) from client
public class AccountRequest {

	private float balance;
	private String owner;

	public float getBalance() {
		return balance;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
