package com.vwits.bankapp.view.impl;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.vwits.bankapp.dto.request.AccountRequest;
import com.vwits.bankapp.dto.response.AccountResponse;

//AutoCloseable - from java.lang package
public class AccountConsoleView implements AutoCloseable {

	public void displayHeader(String header) {
		// code specific to header
		displayMessage(header);
	}

	public void displayFooter(String footer) {
		// code specific to footer
		displayMessage(footer);
	}

	public void displayMenu() {
		System.out.println("---------------------------------------");
		System.out.println("1 Withdraw");
		System.out.println("2 Deposit");
		System.out.println("3 Display all Accounts");
		System.out.println("4 Open an Account");
		System.out.println("5 Close an account");
		System.out.println("6 Transfer Fund");
		System.out.println("7 View Balance");
		System.out.println("8.Release Offers");//this should be visible and accessible to admin
		System.out.println("-1 exit\n");
		System.out.println("---------------------------------------");
	}

	public void displayMessage(String message) {
		System.out.println(message);
	}

	public void displayErrorMessage(String message) {
		System.err.println(message);
	}

	public AccountRequest acceptAccountDetails(Scanner scanner) {
		displayMessage("Enter Balance");
		float balance = 0;
		String owner = null;
		
		try
		{
			balance = scanner.nextFloat();
		}
		catch (InputMismatchException e)
		{
			displayErrorMessage("Balance MUST be float type"); // presentation logic
																// log this error message
			scanner.next(); // consume given I/P
			throw e; // re-throwring an exception so that it can be handled again for logging by
						// another layer
			// logging needed BUT should NOT be done here - as it is NOT responsibility of
			// view layer
		}

		displayMessage("Enter Owner");
		
		try
		{
			owner = scanner.next();
		} 
		catch (InputMismatchException e) {
			displayErrorMessage("Name is NOT correct");
			scanner.next(); // consume WRONG I/P
			throw e; // re-throwring an exception so that it can be handled again for logging by
						// another layer
		}
		// assigning I/P to request Object
		AccountRequest request = new AccountRequest();
		request.setOwner(owner);
		request.setBalance(balance);
		return request;
	}

	public int acceptAccountNumber(Scanner sc) {
		System.out.println("Enter Account Number");
		int accountNumber = sc.nextInt();
		return accountNumber;
	}

	public void displayAccount(AccountResponse[] accounts) {
		System.out.println("---------------------------------------");
		System.out.println("Number \t Balance \t Owner");
		System.out.println("---------------------------------------");
		
		for (AccountResponse account : accounts) {
			if (account != null)
				System.out.println(account.getAccountNumber() + "\t" + account.getBalance() + "\t\t" + account.getOwner());
		}

		System.out.println("---------------------------------------");
	}

	// this method is from AutoCloasable interface
	// this is needed for ARM
	@Override
	public void close() throws Exception {
		displayFooter("Thank you visit again");
	}
}
