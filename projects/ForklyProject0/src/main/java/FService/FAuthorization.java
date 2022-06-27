package FService;

import java.io.IOException;

import Model.User;
import DAO.FUserDAO;
import DAO.FUserPostgres;
import FException.LoginException;

public class FAuthorization {
private FUserDAO ud = new FUserPostgres();
	
	public User login(String username, String password) throws LoginException, IOException {
		if(username == null || password == null) {
			throw new LoginException();
		}
		//still need to figure out how to return to login if LoginException is triggered
		User u = ud.retriveUserByUsername(username);
		if(u == null || !u.getPassword().equals(password)) {
			throw new LoginException();
		}
		return u;
	}
	//checks to see if isAdmin clumn in users menu is not null. Only "derek" account in users is not null
	public boolean checkAdmin(String username) throws IOException {
		User u = ud.retriveUserByUsername(username);
		return u.getAdmin();
		
	}
	//grabs auto-generated primary key
	public int checkid(String username) throws IOException {
		User u = ud.retriveUserByUsername(username);
		return u.getId();
	}
}