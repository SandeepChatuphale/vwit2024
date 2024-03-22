package com.vwits.bankapp.entity;

public class Account {

	private final static int MINIMUM_BALANCE = 500;
	private static int count;						//this is used to count total of accounts
	
	// instance variable
	private int accountNumber;
	private float balance;
	private String owner;

	// no arg constructor
//	private Account() {
//		accountNumber = 1;
//		balance = 2283774.8f;
//		owner = "Salil";
//		System.out.println("in constructor");
//	}

	public Account(float balance, String owner) {
		count++;								//incrementing count
		this.accountNumber = count;
		this.balance = balance;
		this.owner = owner;
		
	}

	public float getBalance() {
		return this.balance;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	public String getOwner() {
		return this.owner;
	}

	// define a method withdraw which allows amount from the account
	public boolean withdraw(float amount)  {
		if (balance - amount >= MINIMUM_BALANCE) {// business requirement to maintain minimum balance 500
			balance -= amount;
			return true;
		} 
		else {
			return false;
		}
	}

	public boolean deposit(float amount) {
		if (amount > 0) {
			balance += amount;
			return true;
		} else {
			return false;
		}
	}
}