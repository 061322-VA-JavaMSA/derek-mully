package dao;

import java.util.List;

import model.reimbursement;

public interface employerDao {
	List<reimbursement> getReimbursement();
	void updateReimbursement(reimbursement r);
	//Reimbursement getReimbursementbyId(int id);
}