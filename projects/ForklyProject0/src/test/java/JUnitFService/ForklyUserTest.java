package JUnitFService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Model.User;

class ForklyUserTest { 
	@Test
	public void usersTest() {
		User u = new User();
		u.setUsername("hello");
		assertNotNull(u);
	}

}