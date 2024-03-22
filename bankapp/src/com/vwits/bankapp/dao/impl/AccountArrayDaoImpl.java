//Dao- Data access object

// responsible for connecting to data store
// Typical operation implement by Dao's are-CRUD

package com.vwits.bankapp.dao.impl;

import java.util.Optional;

import com.vwits.bankapp.dao.AccountDao;
import com.vwits.bankapp.entity.Account;

public class AccountArrayDaoImpl implements AccountDao {

	private Account[] accounts;

	public AccountArrayDaoImpl() 
	{
		Account account2 = new Account(5679.67f, "Mahesh");
		Account account3 = new Account(2653.67f, "Mohan");
		// Account account4 = new Account(23, 7889.67f, "Roahn");

	
		this.accounts[0] = account2;
		this.accounts[1] = account3;
		// this.accounts[2]=account4;
	}

	// R- Read operation
	public Account[] findAll() {
		return this.accounts;
	}

	// R- Read
	public Optional<Account> findById(int accountNumber) {
		for (Account account : accounts) {
			if (account != null) {
				if (account.getAccountNumber() == accountNumber) {
					//return account; // return account details if account number matches
					return Optional.of(account);
				}
			}
		}
		//return null; // return null if accountNumber not found
		return Optional.empty();
	}

	// C - Create
	public Account createNewAccount(Account a) {
		this.accounts[2] = a;
		return a;
	}

	// D - Delete
	public int deleteById(int accountNumber) {
		
		Optional<Account> optional = findById(accountNumber);
		
		if(optional.isPresent()) 						// checking if account exists
		{
			Account foundAccount = optional.get();		//get account from Optional
			
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i] != null) {
					if (foundAccount.getAccountNumber() == accounts[i].getAccountNumber()) { // finding index for the
																								// account
						accounts[i] = null; // making it null
						return 1;			// return 1 to account deleted
					}
				}
			}
		}
				
		if(optional.isEmpty())
			return -1;										//Account not found

		return 0; 											// 0 account found but couldn't be deleted
	}

	@Override
	public void close() throws Exception {
		this.accounts = null;
	}
}