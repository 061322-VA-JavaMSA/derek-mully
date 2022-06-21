package Forkly;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class SQLConnection {

	public static void main(String[] args) {
	
	String url = "jdbc:postgresql://forkly-login.cqcduviqwari.us-east-1.rds.amazonaws.com/";
	String username = "postgres";
	String password = "elephant";
	
	try {
		Connection c = DriverManager.getConnection(url, username, password);
				System.out.println(c.getMetaData().getDriverName());
				c.close();
	} catch (SQLException e) {
		//TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}