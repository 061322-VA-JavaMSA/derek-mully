package FService;

import java.io.IOException;

import Model.User;
import DAO.FUserDAO;
import DAO.FUserPostgres;
import FException.LoginException;

public class FAuthorization {
private FUserDAO ud = new FUserPostgres();
	//login with exceptions that require user input
	public User login(String username, String password) throws LoginException, IOException {
		if(username == null || password == null) {
			throw new LoginException();
		}
		User u = ud.retriveUserByUsername(username);
		if(u == null || !u.getPassword().equals(password)) {
			throw new LoginException();
		}
		return u;
	}
	//Employee in users table is checked by column isEmployee boolean. If value is 1, then the user is an employee.
	public boolean checkEmployee(String username) throws IOException {
		User u = ud.retriveUserByUsername(username);
		return u.getEmployee();
		
	}
	//grabs auto-generated primary key
	public int checkid(String username) throws IOException {
		User u = ud.retriveUserByUsername(username);
		return u.getId();
	}
}