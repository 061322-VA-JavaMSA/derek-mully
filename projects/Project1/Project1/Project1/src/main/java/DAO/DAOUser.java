package DAO;

import java.util.List;

import Models.User;

public interface DAOUser {
	List<User> getUsers();

	User getUserByUsername(String username);
}