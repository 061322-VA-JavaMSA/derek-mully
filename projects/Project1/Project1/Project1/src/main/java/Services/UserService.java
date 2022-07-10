package Services;

import java.util.List;

import DAO.DAOUser;
import DAO.HibernateUser;
import Models.User;

public class UserService {
	public DAOUser du = new HibernateUser();
	public List<User> getUsers() {
		List<User> users = du.getUsers();
		return users;
	}
}