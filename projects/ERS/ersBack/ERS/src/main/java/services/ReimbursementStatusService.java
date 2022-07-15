package services;

import dao.ReimbursementStatusDAO;
import dao.ReimbursementStatusHibernate;
import exceptions.ReimbursementStatusNotFoundException;
import models.Reimbursement;
import models.ReimbursementStatus;

public class ReimbursementStatusService {
	ReimbursementStatusDAO rh = new ReimbursementStatusHibernate();
	public ReimbursementStatus getReimbursementStatusById(int id) throws ReimbursementStatusNotFoundException { 
		ReimbursementStatus status = rh.getReimbursementStatusById(id);
		return status;
	}
}