package ForklyDAOs;

import java.util.List;

import Forkly.Customer;

public interface CustomerDAO {
	Customer createUser(Customer cu);
	Customer retrieveUserById(int id);
	List<Customer> retrieveUsers();
	Customer retrieveUserByUsername(String username);
	boolean updateUser(Customer cu);
	boolean deleteUserById(int id);
}