package DAO;

import java.util.List;

import Models.Reimbursement;

public interface DAOEmployee {
	Reimbursement insertReimbursement(Reimbursement r);
	List<Reimbursement> getReimbursement();
}