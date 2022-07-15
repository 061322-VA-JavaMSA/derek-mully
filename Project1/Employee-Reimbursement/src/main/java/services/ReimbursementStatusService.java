package services;

import daos.ReimbursementStatusDao;
import daos.ReimbursementStatusHibernate;
import models.ReimbursementStatus;

public class ReimbursementStatusService {
	
	ReimbursementStatusDao rsd = new ReimbursementStatusHibernate();
	
	public ReimbursementStatus getReimbursementStatusById(int id) {
		ReimbursementStatus status = rsd.getReimbursementStatusById(id);
		return status;
	}
}