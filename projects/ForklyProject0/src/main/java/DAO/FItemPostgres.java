package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Item;

import ForklyUtil.ForklyConnect;

public class FItemPostgres implements FItemDAO {

	@Override
	public Item createItem(Item i) throws IOException {
		//SQL INSERT statement
		String sql = "insert into items (itemname, price) values (?,?) returning item_id;";
		//connects to database and wraps statement for query execution
		try(Connection c = ForklyConnect.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, i.getItemname());
			ps.setInt(2, i.getPrice());
			
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				i.setId(rs.getInt("item_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public List<Item> retrieveItems() throws SQLException, IOException {
		// TODO Auto-generated method stub
		//SQL SELECT statement
		String sql = "select * from items;";
		List<Item> items = new ArrayList<>();
		//connects to database and wraps statement for query execution
		try(Connection c = ForklyConnect.getConnectionFromFile();) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Item i = new Item();
				i.setId(rs.getInt("item_id"));
				i.setItemname(rs.getString("itemname"));
				i.setPrice(rs.getInt("price"));
				items.add(i);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return items;
	}
	
	public boolean deleteItemByid(int id) throws IOException {
		String sql = "delete from items where item_id = ?;";
		int rowsChanged = -1;
		//connects to database and wraps statement for query execution
		try(Connection c = ForklyConnect.getConnectionFromFile()){
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

	@Override
	public Item makeAnOffer(Item i) throws IOException {
		String sql = "insert into offers (user_id, item_id, offer) values (?,?,?) returning offer_id;";
		//connects to database and wraps statement for query execution
		try(Connection c = ForklyConnect.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, i.getUserId());
			ps.setInt(2, i.getId());
			ps.setInt(3, i.getOffer());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i.setId(rs.getInt("offer_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}



}