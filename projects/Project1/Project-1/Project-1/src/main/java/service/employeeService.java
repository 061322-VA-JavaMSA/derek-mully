package service;

import java.util.List;

import dao.employeeDao;
import dao.employeeHibernate;
import model.reimbursement;

public class employeeService {
	private employeeDao ed = new employeeHibernate();
	
	public reimbursement insertReimbursement(reimbursement r) {
		return ed.insertReimbursement(r);
	}
	
	public List<reimbursement> getReimbursement(){
		return ed.getReimbursement();
	}
}