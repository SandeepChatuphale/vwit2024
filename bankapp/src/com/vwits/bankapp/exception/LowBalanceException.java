package com.vwits.bankapp.exception;

//this is inheriting from Exception class
//Exception is a super-class 
//LowBalanceException is a sub-class
public class LowBalanceException extends Exception{

	private String message;
	
	public LowBalanceException(String message) {
		super(message);
		this.message = message;
	}
	
	
	public String toString()
	{
		return message +" Please maintain balance";
	}
	
}
