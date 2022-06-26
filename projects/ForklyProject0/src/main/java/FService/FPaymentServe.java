package FService;

import java.io.IOException;
import java.util.List;

import Model.Payment;
import DAO.FPaymentDAO;
import DAO.FPaymentPostgres;


public class FPaymentServe {

	private FPaymentDAO pd = new FPaymentPostgres();
	
	public Payment createPayment(Payment p) throws IOException {
		return pd.createPayment(p);
	}
	
	public List<Payment> checkPaymentInfo(int userId) throws IOException {
		return pd.retrivePaymentByUserId(userId);
	}
}