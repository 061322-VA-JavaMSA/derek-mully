package dao;

import java.util.List;


import model.user;

public interface userDao {
	List<user> getUsers();

	user getUserByUsername(String username);
	void updateUser(user u);
}