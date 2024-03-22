
package com.vwits.bankapp.util;

import com.vwits.bankapp.dto.request.AccountRequest;
import com.vwits.bankapp.dto.response.AccountResponse;
import com.vwits.bankapp.entity.Account;

public class ModelMapper {
	public static AccountResponse[] convertFrom(Account[] accounts) {

		AccountResponse[] accountResponses = new AccountResponse[accounts.length];

		int i = 0;
		
		for (Account account : accounts) {
			if (account != null) {
				accountResponses[i] = new AccountResponse();
				accountResponses[i].setAccountNumber(account.getAccountNumber());
				accountResponses[i].setBalance(account.getBalance());
				accountResponses[i].setOwner(account.getOwner());
				i++;
			}
		}
		return accountResponses;
	}

	public static Account convertToAccountFromAccountResponse(AccountResponse response)
	{
		Account a = new Account(
								response.getBalance(), 
								response.getOwner());
		return a;
	}
	
	public static Account convertToAccountFromAccountRequest(AccountRequest request)
	{
		Account a = new Account(request.getBalance(), request.getOwner());
		return a;
	}
	
	
	
	
	
	
	
	
}