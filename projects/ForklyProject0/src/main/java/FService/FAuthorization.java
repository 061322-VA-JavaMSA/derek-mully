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
		
		User u = ud.retriveUserByUsername(username);
		if(u == null || !u.getPassword().equals(password)) {
			throw new LoginException();
		}
		return u;
	}
	
	public boolean checkAdmin(String username) throws IOException {
		User u = ud.retriveUserByUsername(username);
		return u.getAdmin();
		
	}
	
	public int checkid(String username) throws IOException {
		User u = ud.retriveUserByUsername(username);
		return u.getId();
	}
}