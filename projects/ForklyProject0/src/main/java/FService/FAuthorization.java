package FService;


import Model.User;

import java.io.IOException;

import DAO.FUserDAO;
import DAO.FUserPostgres;
import FException.LoginException;

public class FAuthorization {
private FUserDAO ud = new FUserPostgres();
	
	public User login(String username, String password) throws LoginException, IOException {
		// if username/password passed are null, throws an exception
		if(username == null || password == null) {
			throw new LoginException();
		}
		
		User u = ud.retriveUserByUsername(username);
		// if no user of that name has been retrieved/if pass don't match, throw an exception
		if(u == null || !u.getPassword().equals(password)) {
			throw new LoginException();
		}
		return u;
	};
	
	public boolean checkAdmin(String username) throws IOException {
		User u = ud.retriveUserByUsername(username);
		return u.getAdmin();
		
	}
	
	public int checkid(String username) throws IOException {
		User u = ud.retriveUserByUsername(username);
		return u.getId();
	}
}