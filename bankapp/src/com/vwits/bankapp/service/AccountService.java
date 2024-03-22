package com.vwits.bankapp.service;

import java.util.List;
import java.util.function.Predicate;

import com.vwits.bankapp.entity.Account;
import com.vwits.bankapp.exception.AccountNotFoundException;
import com.vwits.bankapp.exception.LowBalanceException;

public interface AccountService extends AutoCloseable {

	public boolean withdrawTransaction(float amount,int accountNumber) throws LowBalanceException, AccountNotFoundException;
	public boolean depositTransaction(float amount,int accountNumber) throws AccountNotFoundException;
	
	
	/**
	 * method responsible for releasing different offers based on different based condition
	 */
	
	void releaseOffers(Predicate<Account> p);
	
	
	/**
	 * method responsible for
	 */
	List<Account> findAllAccountsEligibleForOffers(Predicate<Account> p);
}
