package JUnitFService;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;
import java.io.IOException;

import FService.FPaymentServe;

class paymentTest {
	public static FPaymentServe p = new FPaymentServe();
	@Test
	public void retrivePaymentTest() throws IOException {
		assertNotNull(p.retrivePaymentByPaymentId(9));
	}
	@Test
	public void checkOwnItem() throws IOException {
		assertNotNull(p.checkOwnedItems(0));
	}
	
	@Test
	public void checkPaymentHistory() throws IOException {
		assertNotNull(p.checkPaymentHistory());
	}
	@Test
	public void checkPaymentInfo() throws IOException {
		assertNotNull(p.checkPaymentInfo(0));
	}
	@Test
	public void checkWeekPayment() throws IOException {
		assertNotNull(p.checkWeeklyPayment());
	}
	
}