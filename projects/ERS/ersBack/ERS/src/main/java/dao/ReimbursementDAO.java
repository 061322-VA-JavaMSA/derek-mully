package dao;

import java.util.List;

import models.Reimbursement;
import models.ReimbursementStatus;
import models.User;

 
 
public interface ReimbursementDAO {
	List<Reimbursement> getReimbursements();
	List<Reimbursement>  getByAuthor(User u);
	Reimbursement insertReimbursement(Reimbursement r);
	Reimbursement getByID(int id);
	boolean setStatusByID(int id,User approverUser, ReimbursementStatus status);
 
}