package ForklyUtil;

import java.util.Properties;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ForklyConnect{
	private static Connection c;

	//grabs connection from properties file created in resources folder
	//url, username, password grabbed from properties files
	public static Connection getConnectionFromFile() throws SQLException, IOException {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream("config.properties"));
		//url, username, password grabbed from properties files
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
		}
		//loops connection attempt
		return c;
	}
	
	//still trying to figure out how local connection can be established via environment variables
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