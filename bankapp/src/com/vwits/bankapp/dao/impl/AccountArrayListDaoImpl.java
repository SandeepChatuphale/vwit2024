package com.vwits.bankapp.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vwits.bankapp.dao.AccountDao;
import com.vwits.bankapp.entity.Account;

//we are NOT suppose to change methods signature but we can change implementation
//this is going make layers loosely coupled
public class AccountArrayListDaoImpl implements AccountDao {

	private List<Account> accounts;

	public AccountArrayListDaoImpl() {
		this.accounts = new ArrayList<Account>();
	}

	public Account[] findAll() {
		return this.accounts.toArray(new Account[] {});
	}

	public Optional<Account> findById(int accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				return Optional.of(account);
				// return account;
			}
		}
		// return null;
		return Optional.empty();
	}

	public int deleteById(int accountNumber) {

		Optional<Account> optional = findById(accountNumber);
		boolean isDeleted = false;

		if (optional.isPresent()) {
			Account account = optional.get(); // get() is a method of Optional class
			isDeleted = this.accounts.remove(account); // remove() is built-in method
		} else
			return -1;

		if (isDeleted)
			return 1;
		else
			return 0;
	}

	public Account createNewAccount(Account a) {
		accounts.add(a); // this is added in ArrayList (add() is a built-in method)
							// size automatically increases if needed
		return a;
	}
	
	@Override
	public void close() throws Exception {
		this.accounts.clear();
	}
}