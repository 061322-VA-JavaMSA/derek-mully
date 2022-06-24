package ForklyServices;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Forkly.Customer;
import ForklyDAOs.CustomerDAO;
import ForklyDAOs.ForklyCustomerPostgresSQL;

public class ForklyCustomers {
		
		private static Logger log = LogManager.getLogger(ForklyCustomers.class);
		private CustomerDAO cd = new ForklyCustomerPostgresSQL();
		
		public List<Customer> getUsers(){
			return cd.retrieveUsers();
		}
		
		public Customer createUser(Customer cu) {
			cu = cd.createUser(cu);
			Customer customer = cd.createUser(cu);
			log.info("User: " + customer + " was created.");
			return cd.createUser(cu);
		}
}