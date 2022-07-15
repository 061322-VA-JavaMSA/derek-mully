package services;

import daos.ReimbursementTypeDao;
import daos.ReimbursementTypeHibernate;
import models.ReimbursementType;

public class ReimbursementTypeService {

	ReimbursementTypeDao rtd = new ReimbursementTypeHibernate();
	
	public ReimbursementType getReimbursementTypeById(int id) {
		ReimbursementType type = rtd.getReimbursementTypeById(id);
		
		return type;
	}
}