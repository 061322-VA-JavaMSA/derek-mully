package service;

import java.util.List;

import dao.userDao;
import dao.userHibernate;
import model.user;

public class userService {
	public userDao ud = new userHibernate();
	public List<user> getUsers() {
		List<user> users = ud.getUsers();
		return users;
	}
	
	public user getUsersByUsername(String u) {
		return ud.getUserByUsername(u);
	}
	
	public void updateUserInfo(user u) {
		ud.updateUser(u);
	}
}