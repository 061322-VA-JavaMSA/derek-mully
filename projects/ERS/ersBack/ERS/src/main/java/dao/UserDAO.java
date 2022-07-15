package dao;

import java.util.List;

import models.Role;
import models.User;
 
public interface UserDAO {
	User insertUser(User u);
	User getUserById(int id);
	User getUserByUsername(String username);
	boolean updatetUser(User u);
	List<User> getByRole(Role role);
}