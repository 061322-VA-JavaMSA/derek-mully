package utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtil {
private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory() {
		
		if(sf == null || sf.isClosed() == true) {
			sf = new Configuration()
					.configure()
					.buildSessionFactory();
		}
		return sf;
	}
}