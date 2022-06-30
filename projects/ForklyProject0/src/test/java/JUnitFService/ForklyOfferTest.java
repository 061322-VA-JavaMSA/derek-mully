package JUnitFService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.sql.SQLException;

import FService.FOfferServe;

class ForklyOfferTest {
	public static FOfferServe o = new FOfferServe();
	@Test
	void getOfferByIdTest() throws SQLException, IOException {
		assertNull(o.retrieveOfferById(0));
	}
	@Test
	void rejectTest() throws IOException {
		assertNotNull(o.rejectPendingOffers(0));
	}
	@Test
	void getOfferTest() throws SQLException, IOException {
		assertNotNull(o.getOffers());
	}

}