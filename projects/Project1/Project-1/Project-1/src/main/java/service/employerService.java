package service;

import java.util.List;

import dao.employerDao;
import dao.employerHibernate;
import model.reimbursement;

public class employerService {
	private employerDao ed = new employerHibernate();
	public List<reimbursement> getReimbursement(){
		return ed.getReimbursement();
	}
	
	public void updateReimbursement(reimbursement r) {
		ed.updateReimbursement(r);
	}
	
	
}