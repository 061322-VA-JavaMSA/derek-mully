package ForklyServices;

import java.util.List;

import Forkly.Customer;
import ForklyDAOs.CustomerDAO;
import ForklyDAOs.ForklyCustomerPostgresSQL;

public class ForklyCustomers {
		
		private CustomerDAO cd = new ForklyCustomerPostgresSQL();
		
		public List<Customer> getUsers(){
			return cd.retrieveUsers();
		}
		
		public Customer createUser(Customer cu) {
			cu = cd.createUser(cu);
			return cd.createUser(cu);
		}
}