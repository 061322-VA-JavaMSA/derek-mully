package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Offer;
import ForklyUtil.ForklyConnect;

public class FOfferPostgres implements FOfferDAO {

	public List<Offer> retrieveOffers() throws SQLException, IOException {
		//SQL SELECT statement from offers table retreiving all offers with corresponding column values
		String sql = "select * from offers;";
		List<Offer> offers = new ArrayList<>();
		//connects to database and wraps statement for query execution
		try(Connection c = ForklyConnect.getConnectionFromFile();) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Offer o = new Offer();
				o.setOfferId(rs.getInt("offer_id"));
				o.setItemID(rs.getInt("item_id"));
				o.setUserId(rs.getInt("user_id"));
				o.setPrice(rs.getInt("offer"));
				offers.add(o);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return offers;
	}
	
	public Offer retrieveOffersById(int id) throws SQLException, IOException {
		//SQL SELECT all statement from offers table and setting all values in relevant columns
		String sql = "select * from offers;";
		Offer o = null;
		//connects to database and wraps statement for query execution
		try(Connection c = ForklyConnect.getConnectionFromFile();) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				o = new Offer();
				o.setOfferId(rs.getInt("offer_id"));
				o.setItemID(rs.getInt("item_id"));
				o.setUserId(rs.getInt("user_id"));
				o.setPrice(rs.getInt("offer"));
				o.setStatus(rs.getInt("status"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@Override
	public boolean updateOffer(Offer o) throws SQLException, IOException {
		//SQL UPDATE statement grabbing status and offer_id from database and changing
		String sql = "update offers set status = ? where offer_id = ?";
		int rowsChanged = -1;
		
		//connects to database and wraps statement for query execution
		try(Connection c = ForklyConnect.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, o.getStatus());
			ps.setInt(2, o.getOfferId());
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged < 1) {
			return false;
		} else {
			System.out.println("The status of the offer has been changed");
		}
		return true;
	}
	
	public boolean rejectPendingOffer(int itemId) throws IOException {
		//SQL DELETE statement accessing relevant value from item_id column
		String sql = "delete from offers where item_id = ?";
		int rowsChanged = -1;
		
		//connects to database and wraps statement for query execution
		try(Connection c = ForklyConnect.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);	
			ps.setInt(1, itemId);
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged < 1) {
			return false;
		} else {
			System.out.println("all the pending offers have been rejected");
		}
		return true;
		
	}
	



}