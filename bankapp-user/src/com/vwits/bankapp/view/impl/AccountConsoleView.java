package com.vwits.bankapp.view.impl;

import java.util.Scanner;

import com.vwits.bankapp.web.response.AccountResponse;

public class AccountConsoleView {
 	
	public void displayHeader(String header) {
		// code specific to header
		displayMessage(header); 
	}
 
	public void displayFooter(String footer) {
		// code specific to footer
		displayMessage(footer);
	}
 
	public void displayMenu() 
	{
		System.out.println("1 withdraw");
		System.out.println("2 deposit");
		System.out.println("3 display");
		System.out.println("4. Create a new Account");
		System.out.println("-1 exit\n");
	}
 
	public void displayMessage(String message) {
		System.out.println(message);
	}
	
	public AccountResponse acceptAccountDetails(Scanner scanner)
	{
		//Accepting I/P from User
		displayMessage("Enter Account Number");
		int accountNumber = scanner.nextInt();
		
		displayMessage("Enter Balance");
		float balance = scanner.nextFloat();
		
		displayMessage("Enter Owner");
		String owner = scanner.next();
		
		//Assigning it to AccountResponse object
		AccountResponse response = new AccountResponse();
		response.setAccountNumber(accountNumber);
		response.setBalance(balance);
		response.setOwner(owner);
		
		return response;
	}
	
 
	public void displayAccount(AccountResponse[] accounts) {
		System.out.println("number balance owner");
		for (AccountResponse account : accounts) {
			if(account != null)
				System.out.println(account.getAccountNumber() + " " + account.getBalance() + " " + account.getOwner());
		}
	}
}
 