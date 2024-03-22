package com.vwits.bankapp.dto.response;


//DTO - Data Transfer Object
//It is used to transfer (send) data from one Layer to other
//this is DTO class which is used to send data (response) to client
public class AccountResponse {

	private int accountNumber;
	private float balance;
	private String owner;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

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