package DAO;

import java.sql.Connection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ForklyUtil.ForklyConnect;
import Model.Payment;


public class FPaymentPostgres implements FPaymentDAO {
	public Payment createPayment(Payment p) throws IOException {
		String sql = "insert into payments (user_id, item_id, offer) values (?,?,?) returning payment_id;";
		try(Connection c = ForklyConnect.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, p.getUserId());
			ps.setInt(2, p.getItemId());
			ps.setInt(3, p.getOffer());
			
			ResultSet rs = ps.executeQuery(); // return the id generated by the database
			if(rs.next()) {
				p.setPaymentId(rs.getInt("payment_id") + 1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	public List<Payment> retrivePaymentByUserId(int userId) throws IOException{
		String sql = "select * from payments where user_id = ?;";
		List<Payment> payments = new ArrayList<Payment>();
		
		try(Connection c = ForklyConnect.getConnectionFromFile();) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Payment p = new Payment();
				p.setPayment(rs.getInt("payment_id"));
				p.setItemId(rs.getInt("item_id"));
				p.setOffer(rs.getInt("offer"));
				p.setPayment(rs.getInt("payment"));
				payments.add(p);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return payments;
	}
}