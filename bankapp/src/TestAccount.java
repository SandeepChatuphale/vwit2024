// Modify the application in such a way that application should be able to maintain the record of

//Multiple bank account

//and perform the operation(deposit and withdraw) based on user choice

//application must also show appropriate result(output) to end user

import java.util.InputMismatchException;

import java.util.Scanner;
import com.vwits.bankapp.dao.AccountDao;
import com.vwits.bankapp.dto.request.AccountRequest;
import com.vwits.bankapp.dto.response.AccountResponse;
import com.vwits.bankapp.entity.Account;
import com.vwits.bankapp.exception.AccountNotFoundException;
import com.vwits.bankapp.exception.LowBalanceException;
import com.vwits.bankapp.factory.BeanFactory;
import com.vwits.bankapp.service.AccountService;
import com.vwits.bankapp.service.impl.AccountServiceImpl;
import com.vwits.bankapp.util.Logger;
import com.vwits.bankapp.util.ModelMapper;
import com.vwits.bankapp.view.impl.AccountConsoleView;

public class TestAccount {

	public static void main(String[] args) throws Exception {

		// this is ARM feature added in jdk 1.7 - which automatically release the
		// resource
		// resource which we are using in ARM(Automatic Resource Management) MUST
		// implements "AutoCloseable" interface
		// ARM is also known as - try-with-resources

		// Creating resources
		// Coding to interface (Needed for loose coupling)

		try (Scanner scanner = new Scanner(System.in);
				AccountConsoleView view = new AccountConsoleView();
				AccountDao dao = BeanFactory.getDao();
				AccountService service = new AccountServiceImpl(dao); // we are passing dao object to constructor of
																		// AccountServiceImpl
		) {

			Account[] accounts = dao.findAll(); // this is call to dao Layer
												// this line of code shouldn't be affected

			view.displayHeader("welcome to bank app");

			int option = 0;

			do {
				view.displayMenu();

				option = scanner.nextInt(); //

				switch (option) {

				case 1: {

					view.displayMessage("Enter your account Number");

					int accountNumber = scanner.nextInt();

					view.displayMessage("please enter the amount to withddraw: ");

					float amount = scanner.nextFloat();

					boolean result;

					try {
						result = service.withdrawTransaction(amount, accountNumber);

						if (result) {
							view.displayMessage(amount + " is Withdrawal successfull.");
							Logger.writeLog(Logger.INFO, "withdrawTransaction");
						}
					} catch (LowBalanceException e) {
						e.printStackTrace();
						view.displayErrorMessage("Insufficient balance");
						Logger.writeLog(Logger.ERROR, "withdrawTransaction", e);
					} catch (AccountNotFoundException e) {
						e.printStackTrace();
						view.displayErrorMessage("Account NOT found");
						Logger.writeLog(Logger.ERROR, "withdrawTransaction", e);
					}
					break;
				}

				case 2: {

					view.displayMessage("Enter your account Number");

					int accountNumber = scanner.nextInt();

					view.displayMessage("please enter the amount deposit:");

					float amount = scanner.nextFloat();

					try 
					{
						boolean result = service.depositTransaction(amount, accountNumber);
						if (result)
							view.displayMessage(amount + " is deposited successfuly");
						else
							view.displayErrorMessage("Please Try again");
					}
					catch (AccountNotFoundException e) 
					{
						view.displayErrorMessage(e.getMessage());
						Logger.writeLog(Logger.ERROR, "depositTransaction", e);
					}
					break;
				}

				case 3: {

					// while calling display account pass array of AccountResponse instead of
					// account array
					accounts = dao.findAll();
					AccountResponse[] accountResponses = ModelMapper.convertFrom(accounts);
					view.displayAccount(accountResponses);
					break;

				}
				case 4:

					// We have received AccountRequest Object from View layer
					try 
					{
						AccountRequest accountRequest = view.acceptAccountDetails(scanner);
						// But to Dao we need to pass Object of Account
						// Hence we need to convert From AccountRequest to Account
						Account a = ModelMapper.convertToAccountFromAccountRequest(accountRequest);
						dao.createNewAccount(a);
					}
					catch (InputMismatchException e) 
					{
						// Writing blank catch is bad practice and it is known as - swallowing exception
						e.printStackTrace();
						Logger.writeLog(Logger.ERROR, "acceptAccountDetails",e);
					

					}
					break;

				case 5:
					int accountNumber = view.acceptAccountNumber(scanner);
					int result = dao.deleteById(accountNumber);

					if (result == 1) {
						view.displayMessage("Account with number " + accountNumber + "  deleted successfully");
					} else if (result == 0) {
						view.displayMessage("Account with number " + accountNumber + "  NOT Deleted");
					} else {
						view.displayMessage("Account with number " + accountNumber + "  NOT Found");
					}
					break;
				case 8:
					
					//Releasing offers to accounts maintaining balance > 10000
					//Predicate<Account> p = account -> account.getBalance() > 10000;
					service.releaseOffers(account -> account.getBalance() > 10000);//we are writing inline lambda
					
					//Releasing offers to accounts maintained since 5 years
					
				}
			} while (option != -1);
		}

		finally 
		{
				//if (view != null)
					//view.displayFooter("Thank you visit again");

				//if (scanner != null)
//					scanner.close(); // closing the resource is important and mandate to avoid resource leakage
		}
	}
}