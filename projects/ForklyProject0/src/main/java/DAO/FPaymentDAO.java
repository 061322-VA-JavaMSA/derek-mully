package DAO;

import java.io.IOException;
import java.util.List;

import Model.Payment;

public interface FPaymentDAO {
	Payment createPayment(Payment p) throws IOException;
	List<Payment> retrivePaymentByUserId(int userId) throws IOException;
}