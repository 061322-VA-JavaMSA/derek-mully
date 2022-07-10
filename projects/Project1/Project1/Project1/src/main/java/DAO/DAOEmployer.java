package DAO;

import java.util.List;

import Models.Reimbursement;

public interface DAOEmployer {
	List<Reimbursement> getReimbursement();
	void updateReimbursement(Reimbursement r);
}