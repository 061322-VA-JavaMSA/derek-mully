package Utilities;
import javax.servlet.http.HttpServletResponse;

public class CorsFix {
	public static void addCorsHeader(String requestURI, HttpServletResponse rs) {
		rs.addHeader("Access-Control-Allow-Origin", "http://"); //INSERT ADDRESS HERE
		rs.addHeader("Access-Control-Allow-Origin", "*");
		rs.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		rs.addHeader("Access-Control-Allow-Credentials", "true");
		rs.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
		rs.addHeader("Access-Control-Expose-Headers", "Content-Type, Accept");
	}
}