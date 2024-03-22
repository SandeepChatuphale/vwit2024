package com.vwits.bankapp.service;


//this is NOT yet implemented
//TODO - improve method signature
//TODO - throw appropriate Exception
public interface EmailService {

	public boolean sendEmail(String toEmail,String subject,int accountNumber,float amount , String owner,String message);
}
