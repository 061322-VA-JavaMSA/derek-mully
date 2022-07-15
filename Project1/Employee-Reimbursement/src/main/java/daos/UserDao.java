package daos;

import java.util.List;

import models.Role;
import models.User;

public interface UserDao {
	
	User insertUser(User u);
	User getUserById(int id);
	User getUserbyRole(Role role);
	User getUserByUsername(String username);
	List<User> getUsers();
}
