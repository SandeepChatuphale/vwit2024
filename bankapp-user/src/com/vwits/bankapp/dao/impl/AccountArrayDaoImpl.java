//Dao- Data access object

// responsible for connecting to data store
// Typical operation implement by Dao's are-CRUD

package com.vwits.bankapp.dao.impl;

import com.vwits.bankapp.entity.Account;

public class AccountArrayDaoImpl {
 
	private Account[] accounts;
	
	public AccountArrayDaoImpl() {
		Account account2 = new Account(2, 5679.67f, "Mahesh");
		Account account3 = new Account(25, 2653.67f, "Mohan");
		//Account account4 = new Account(23, 7889.67f, "Roahn");
		
		this.accounts=new Account[3];
		this.accounts[0]=account2;
		this.accounts[1]=account3;
		//this.accounts[2]=account4;
	}
	//R- Read operation
	public Account[] findAll() {
		return this.accounts;
	}
	
	//R- Read
	public Account findById(int accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				return account; // return account details if account number matches
			}
		}
		return null; // return null  if accountNumber  not found
	}
	
	//C - Create
	public Account createNewAccount(Account a)
	{
		this.accounts[2] = a;
		return a;
	}
}