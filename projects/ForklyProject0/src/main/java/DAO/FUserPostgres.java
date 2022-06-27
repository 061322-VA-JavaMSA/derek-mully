package DAO;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ForklyUtil.ForklyConnect;
import Model.User;


public class FUserPostgres implements FUserDAO {
	public static void main(String[] args) {
	}

	public User createUser(User u) throws IOException {
		//SQL INSERT statement into users table to insert user input username and password, and returning their newly made serial primary key
		String sql = "insert into users (username, password) values (?,?) returning user_id;";
		//connects to database and wraps statement for query execution
		try(Connection c = ForklyConnect.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u.setId(rs.getInt("user_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}



	public User retriveUserByUsername(String username) throws IOException {
		//SQL SELECT all statement from users table where username column is the same value as a user input for login
		String sql = "select * from users where username  = ?;";
		User u = null;
		//connects to database and wraps statement for query execution
		try (Connection c = ForklyConnect.getConnectionFromFile();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, username); 

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt("user_id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setEmployee(rs.getBoolean("isEmployee"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;

	
	}

}