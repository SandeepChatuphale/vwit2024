package com.vwits.bankapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.vwits.bankapp.dao.AccountDao;
import com.vwits.bankapp.entity.Account;
import com.vwits.bankapp.exception.AccountNotFoundException;
import com.vwits.bankapp.exception.LowBalanceException;
import com.vwits.bankapp.service.AccountService;
import com.vwits.bankapp.service.EmailService;

//this class is responsible for handling business logic, exceptions, transactions etc
//dependent on dao
public class AccountServiceImpl implements AccountService{

	//coding to interface
	//dependency
	private AccountDao dao;
	
	//not assigned any object yet
	private EmailService emailService;
	
	//dependency injection - gives us "loose coupling"
	//we are passing an object of AccountDao implementation at runtime so that there is no tight coupling
	public AccountServiceImpl(AccountDao dao) {
		//this.dao = new AccountArrayListDaoImpl();	//this leads to tight coupling
		this.dao = dao;
	}
	
	/**
	 * @return result - boolean 
	 * @throws LowBalanceException, AccountNotFoundException
	 * @param float amount
	 * @param int accountNumber
	 */
	public boolean withdrawTransaction(float amount,int accountNumber) throws LowBalanceException, AccountNotFoundException
	{
		Account fromAccount = findAccountByAccountNumber(accountNumber);
		boolean result = fromAccount.withdraw(amount);
		
		/**
		 * Step3.1 - If withdraw return false - throw LowBalanceException
		 */
		if(!result)
		{
			LowBalanceException e = new LowBalanceException("500 Minimum balance Needed");		//this is business exception
			throw e;
		}
		
		/**
		 * Step 4 - sendEmail - TODO
		this.emailService.sendEmail("sandeep@gmail.com","Withdraw Transaction", accountNumber, amount,fromAccount.getOwner(), "Dear Customer ");
		 * sendSMS - NOT IMPLEMENTED
		 */
		
		/**
		 * Step3.2 - If withdraw return true - return true
		 */
		return result;
		
	}
	
	@Override
	public boolean depositTransaction(float amount, int accountNumber) throws AccountNotFoundException {
		
		Account toAccount = findAccountByAccountNumber(accountNumber);		//call helper method
		boolean result = toAccount.deposit(amount);
		return result;
	}
	
	/**
	 * Helper method
	 * @param accountNumber
	 * @return
	 * @throws AccountNotFoundException
	 */
	private Account findAccountByAccountNumber(int accountNumber) throws AccountNotFoundException
	{
		/**
		 * Step1 - findAccount from DB using accountNumber
		 */
		Optional<Account> optional = this.dao.findById(accountNumber);
		
		/**
		 * Step2.1- If accountNotFound - throw Exception
		 */
		if(optional.isEmpty())
		{
			AccountNotFoundException ex = new AccountNotFoundException(accountNumber, "Account Not found with number ");	//this is business exception
			throw ex;
		}

		/**
		 * Step2.2 - If account found invoke withdraw method
		 * send sms ask OTP - NOT Implemented
		 */
		Account account = optional.get();
		return account;
	}
	
	//this method is accessible ONLY to admin user
	@Override
	public void releaseOffers(Predicate<Account> p) {
		
		//fetch all records
		for (Account a : this.dao.findAll()) {
			//check condition
			if(p.test(a))
			{
				//release offer - sendEmail
				this.emailService.sendEmail("", "", 0, 0, null, null);
			}
		}
	}
	
	
	@Override
	public List<Account> findAllAccountsEligibleForOffers(Predicate<Account> p) {
				
		/**
		 * this is old style coding (before jdk 8)
		 */
		//Step 1 - create arraylist object to store result
		List<Account> eligibleAccounts = new ArrayList<>();
	
		//step 2- iterate over data 
		for (Account account : this.dao.findAll()) {
			if (p.test(account)) {						//step 3- checking condition
				eligibleAccounts.add(account);			//step 4- manually adding data to created arraylist
			}
		}
		return eligibleAccounts;
	}

	@Override
	public void close() throws Exception {
	}

	

	
	
}











