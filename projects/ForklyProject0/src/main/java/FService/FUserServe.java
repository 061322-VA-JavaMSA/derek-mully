package FService;

import java.io.IOException;
import java.util.List;

import DAO.FUserDAO;
import DAO.FUserPostgres;
import Model.User;

public class FUserServe {
private FUserDAO ud = new FUserPostgres();
	
	public User createUser(User u) throws IOException {
		return ud.createUser(u);
	}
	
}