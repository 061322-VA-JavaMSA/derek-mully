import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ForklyExceptions.LoginException;
import Forkly.Customer;
import ForklyServices.ForklyAuthorization;
import ForklyServices.ForklyCustomers;

public class ForklyDriver {
	
	static Scanner scan;
	static ForklyAuthorization fa;
	static ForklyCustomers fu;
	private static Logger log = LogManager.getLogger(ForklyDriver.class);
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		fa = new ForklyAuthorization();
		fu = new ForklyCustomers();
		
		String username = null;
		String password = null;
		
		System.out.println("Enter your username here:");
		username = scan.nextLine();
		System.out.println("Enter your password here:");
		password = scan.nextLine();
		
		try {
			
			System.out.println(fa.login(username, password));
		} catch (LoginException e) {
			System.out.println("That doesn't look right. Please try again.");
			log.error("Login exception was thrown: " + e.fillInStackTrace());
			e.printStackTrace();
		}

		
		List<Customer> users = fu.getUsers();
		for(Customer fu : users) {
			System.out.println(fu);
		}	
		System.out.println("Create, username:");
		String name = scan.nextLine();
		System.out.println("Create, password:");
		String pass = scan.nextLine();
		Customer userTBC = new Customer();
		userTBC.setUsername(name);
		userTBC.setPassword(pass);
		System.out.println(fu.createUser(userTBC));
				
		scan.close();
	}

}