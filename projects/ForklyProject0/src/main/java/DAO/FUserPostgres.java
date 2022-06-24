package DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import ForklyUtil.ForklyConnect;
import Model.User;


public class FUserPostgres implements FUserDAO {
	public static void main(String[] args) {
	}
	
	

	public User createUser(User u) throws IOException {
		String sql = "insert into users (username, password) values (?,?) returning user_id;";
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
		String sql = "select * from users where username  = ?;";
		User u = null;
		
		try (Connection c = ForklyConnect.getConnectionFromFile();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, username); 

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt("user_id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setAdmin(rs.getBoolean("isAdmin"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;

	
	}

}