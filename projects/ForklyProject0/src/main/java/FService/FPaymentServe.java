package FService;

import java.io.IOException;
import java.util.List;

import Model.Payment;
import DAO.FPaymentDAO;
import DAO.FPaymentPostgres;

//right now all payment info has no difference to offer info...must config 
public class FPaymentServe {

	private FPaymentDAO pd = new FPaymentPostgres();
	
	public Payment createPayment(Payment p) throws IOException {
		return pd.createPayment(p);
	}
	
	public List<Payment> checkPaymentInfo(int userId) throws IOException {
		return pd.retrivePaymentByUserId(userId);
	}
}