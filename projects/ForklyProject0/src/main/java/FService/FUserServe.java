package FService;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DAO.FUserDAO;
import DAO.FUserPostgres;
import Model.User;
//accesses users table in database and creates new user. Still don't have function for employee to make another employee admin via boolean
public class FUserServe {
private FUserDAO ud = new FUserPostgres();
private static Logger log = LogManager.getLogger(FUserServe.class);
	
	public User createUser(User u) throws IOException {
		log.info("User: " + u + "has been created.");
		return ud.createUser(u);
	}
	
}