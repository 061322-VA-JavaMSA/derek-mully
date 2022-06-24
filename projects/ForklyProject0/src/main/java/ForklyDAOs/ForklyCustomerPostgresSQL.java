package ForklyDAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Forkly.Customer;
import ForklyUtil.ForklyConnect;

public class ForklyCustomerPostgresSQL implements CustomerDAO{

	@Override
	public Customer createUser(Customer cu) {
		String sql = "insert into users (username, password) values (?,?) returning id;";
		try(Connection c = ForklyConnect.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, cu.getUsername());
			ps.setString(2, cu.getPassword());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				cu.setId(rs.getInt("id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cu;
	}

	@Override
	public Customer retrieveUserById(int id) {
		String sql = "select * from users where id = ?;";
		Customer user = null;
		
		try(Connection c = ForklyConnect.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new Customer();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<Customer> retrieveUsers() {
		String sql = "select * from users;";
		List<Customer> users = new ArrayList<>();
		
		try(Connection c = ForklyConnect.getConnectionFromEnv()){
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Customer cu = new Customer();
				cu.setId(rs.getInt("id"));
				cu.setUsername(rs.getString("username"));
				cu.setPassword(rs.getString("password"));
				
				users.add(cu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public Customer retrieveUserByUsername(String username) {
		String sql = "select * from users where username  = ?;";
		Customer cu = null;
		
		try (Connection c = ForklyConnect.getConnectionFromEnv();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, username); 

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cu = new Customer();
				cu.setId(rs.getInt("id"));
				cu.setUsername(rs.getString("username"));
				cu.setPassword(rs.getString("password"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cu;
	}

	@Override
	public boolean updateUser(Customer cu) {
		String sql = "update users set username = ?, password = ? where id = ?;";
		int rowsChanged = -1;
		
		try(Connection c = ForklyConnect.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, cu.getUsername());
			ps.setString(2, cu.getPassword());
			ps.setInt(3, cu.getId());
			
			rowsChanged = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(rowsChanged < 1) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteUserById(int id) {
		String sql = "delete from users where id = ?;";
		int rowsChanged = -1;
		try(Connection c = ForklyConnect.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(rowsChanged < 1) {
			return false;
		}
		return true;
	}

}