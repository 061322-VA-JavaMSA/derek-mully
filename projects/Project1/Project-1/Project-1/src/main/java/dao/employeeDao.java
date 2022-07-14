package dao;

import java.util.List;


import model.reimbursement;

public interface employeeDao {
	reimbursement insertReimbursement(reimbursement r);
	List<reimbursement> getReimbursement();
	
}