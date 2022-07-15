package daos;

import java.util.List;

import models.Reimbursement;
import models.ReimbursementStatus;
import models.Status;
import models.User;


public interface ReimbursementDao {
	Reimbursement createReimbursement(Reimbursement r);
	Reimbursement getReimbursementById(int id);
	Reimbursement getReimbursementbyStatus(Status status);
	Reimbursement getReimbursementByUsername(String username);
	List<Reimbursement> getReimbursements();
	List<Reimbursement>  getByAuthor(User u);
	boolean setStatusByID(int id,User resolver, ReimbursementStatus reimbursementStatus);


}