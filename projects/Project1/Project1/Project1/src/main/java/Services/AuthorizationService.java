package Services;

import javax.security.auth.login.LoginException;

import DAO.DAOUser;
import DAO.HibernateUser;
import Models.User;
import Exceptions.UserNotFoundException;

public class AuthorizationService {
	private DAOUser du = new HibernateUser();
	
	public User login(String username, String password) throws UserNotFoundException, LoginException {
		
		User principal = du.getUserByUsername(username);
		
		if(principal == null) {
			throw new UserNotFoundException();
		}
		
		if(!principal.getPassword().equals(password)){
			throw new LoginException();
		}
		
		return principal;
	}
}