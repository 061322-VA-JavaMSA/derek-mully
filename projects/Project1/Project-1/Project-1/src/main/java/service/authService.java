package service;

import javax.security.auth.login.LoginException;


import dao.userDao;
import dao.userHibernate;
import Exceptions.userNotFoundException;
import model.user;

public class authService {
	private userDao ud = new userHibernate();
	
	public user login(String username, String password) throws userNotFoundException, LoginException {
		
		// principal refers to "currently logged in user"
		user principal = ud.getUserByUsername(username);
		
		if(principal == null) {
			throw new userNotFoundException();
		}
		
		if(!principal.getPassword().equals(password)){
			throw new LoginException();
		}
		
		return principal;
	}
}