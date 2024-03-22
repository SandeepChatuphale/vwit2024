package com.vwits.bankapp.dao;

import java.util.Optional;

import com.vwits.bankapp.entity.Account;

public interface AccountDao extends AutoCloseable{

	//these are method declarations ONLY
	//such methods are known as - abstract methods
	Account[] findAll();
	
	/**
	 * 
	 * @param accountNumber
	 * Optional is a class added in jdk 1.8
	 * It is used to avoid null pointer exceptions
	 */
	Optional<Account> findById(int accountNumber);
	Account createNewAccount(Account a);
	int deleteById(int accountNumber);
}
