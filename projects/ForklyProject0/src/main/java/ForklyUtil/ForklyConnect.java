package ForklyUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ForklyConnect {
	// using c as a variable to prevent redundancies
	private static Connection c;

	public static Connection getHardcodedConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "elephant";

		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
		}
		
		return c;
	}
	
	public static Connection getConnectionFromFile() throws SQLException, IOException {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream("connection.properties"));
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
		}
		
		return c;
	}
	
	public static Connection getConnectionFromEnv() throws SQLException {
		
		String url = System.getenv("DB_URL");
		String username = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");
		
		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
		}
		
		return c;
	}
}