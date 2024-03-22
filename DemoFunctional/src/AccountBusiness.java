import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
class Account{
	String owner;
	float balance;
	
}
public class AccountBusiness {

	public static void main(String[] args) {
		
		List<Account> accounts = new ArrayList<>();
		Account a1 = new Account();
		a1.balance = 10000;
		a1.owner = "Amit";
		
		Account a2 = new Account();
		a2.balance = 2000;
		a2.owner = "Ajay";
		
		Account a3 = new Account();
		a3.balance = 5000;
		a3.owner = "Sachin";
		
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);
		
		//Print all accounts balance > 5000
		//print(accounts, a -> a.balance > 5000);
		//Print all accounts owner start with 'A'
		//print(accounts, a -> a.owner.startsWith("A"));
		
		//findall accounts eligible for offers-
		//Old Approach - Traditional Approach (Before JDK 8)
		List<Account> eligibleAccounts = new ArrayList<>();
		for (Account account : eligibleAccounts) {
			if(account.balance > 10000)
			{
				eligibleAccounts.add(account);
			}
		}
		//System.out.println(eligibleAccounts);
		
		//using streams - new approach from jdk 8 and above
		Stream<Account> s =  accounts.stream();	//Step 1
		long count = s.count();	//this is terminal operation
		System.out.println(count);
				
		//using streams - new approach from jdk 8 and above
		Stream<Account> ss  =  accounts.stream();								//getting stream from source
		Stream<Account> filteredStream =  ss.filter(a -> a.balance > 10000);	//invoking intermediate operation returns Stream
		List<Account> filteredList = filteredStream.toList();					//invoking terminal operation returns result
		
		
		List<Account> result = accounts.stream()
									   .filter(a -> a.balance>5000)
									   .toList();
		
		
		//filter		intermediate
		//count			terminal
		//toList()		terminal
		
		
		
	}
	
	static void print(List<Account> accounts , Predicate<Account> p)
	{
		for (Account account : accounts) {
			if(p.test(account))
				System.out.println(account.balance +"      " + account.owner );
		}
	}	
}
