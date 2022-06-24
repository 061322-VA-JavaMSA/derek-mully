package ForklyServices;

import ForklyDAOs.CustomerDAO;
import ForklyDAOs.ForklyCustomerPostgresSQL;
import ForklyExceptions.LoginException;
import Forkly.Customer;

public class ForklyAuthorization {

	private CustomerDAO cd = new ForklyCustomerPostgresSQL();
	
	public Customer login(String username, String password) throws LoginException{
		if(username == null || password == null) {
			throw new LoginException();
			//if customers don't have input then an exception is thrown
		}
		
		Customer cu = cd.retrieveUserByUsername(username);
		if(cu == null || !cu.getPassword().equals(password)) {
			throw new LoginException();
			// if customer input is incorrect then an exception is thrown
		}
		return cu;
	}
}