
package com.vwits.bankapp.util;

import com.vwits.bankapp.entity.Account;
import com.vwits.bankapp.web.response.AccountResponse;

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
		Account a = new Account(response.getAccountNumber(), 
								response.getBalance(), 
								response.getOwner());
		return a;
	}
	
	
	
	
	
	
	
	
	
	
}