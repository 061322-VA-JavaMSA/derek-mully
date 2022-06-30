package JUnitFService;

import java.io.IOException;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import FService.FItemServe;

class ForklyItemTest {
	
	public static FItemServe i = new FItemServe();
	
	@Test
	void checkDelete() throws IOException {
		assertFalse(i.deleteItem(0));
	}
	@Test
	void getItemTest() throws SQLException, IOException {
		assertNotNull(i.getItems());
	}
	@Test
	void checkEqual() {
		assertNotNull(i.equals(i));
	}
	
	@BeforeAll
	public static void createItem() {
		
	}
	
	@AfterAll
	public static void deleteItem() {
		
	}

}