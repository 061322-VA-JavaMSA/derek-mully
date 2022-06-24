package DAO;

import java.io.IOException;

import Model.User;

public interface FUserDAO {
	User createUser(User u) throws IOException;
	User retriveUserByUsername(String username) throws IOException;
}