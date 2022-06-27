package FService;

import java.io.IOException;

import DAO.FUserDAO;
import DAO.FUserPostgres;
import Model.User;
//accesses users table in database and creates new user. Still don't have function for employee to make another employee admin via boolean
public class FUserServe {
private FUserDAO ud = new FUserPostgres();
	
	public User createUser(User u) throws IOException {
		return ud.createUser(u);
	}
	
}