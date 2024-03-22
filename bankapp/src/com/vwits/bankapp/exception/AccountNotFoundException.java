package com.vwits.bankapp.exception;

public class AccountNotFoundException extends Exception {

	public AccountNotFoundException(int acccountNumber,String message) {
		
		super(message + "  "+acccountNumber);	//we are calling Exception super class constructor		
	}	
}