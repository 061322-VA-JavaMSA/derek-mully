package services;

import java.util.List;

import daos.UserDao;
import daos.UserHibernate;
import exceptions.UserNotCreatedException;
import exceptions.UserNotFoundException;
import models.Role;
import models.User;

public class UserService {
	
private UserDao ud = new UserHibernate();
	
	public User createUser(User u) throws UserNotCreatedException {
		// by default, created account will be basic Users
		//u.setRole(Role.employee);
		
		User createdUser = ud.insertUser(u);
		if(createdUser.getId() == -1) {
			throw new UserNotCreatedException();
		}
		return createdUser;
	}
	
	public User getUserById(int id) throws UserNotFoundException {
		User u = ud.getUserById(id);
		if (u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}	
	
	public List<User> getUsers() {
		List<User> users = ud.getUsers();
		return users;
	}
	public User getUserByRole(Role role) throws UserNotFoundException {
		User u = ud.getUserbyRole(role);
		if (u == null) {
			throw new UserNotFoundException();
		}
		return u;

}
}