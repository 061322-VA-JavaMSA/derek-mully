package services;

import java.util.List;

import dao.ReimbursementTypeDAO;
import dao.ReimbursementTypeHibernate;
import exceptions.ReimbursementTypeNotFoundException;
import models.ReimbursementType;

public class ReimbursementTypeService {
	ReimbursementTypeDAO rt = new ReimbursementTypeHibernate()  ;
	
	public ReimbursementType getReimbursementTypeById(int id) throws ReimbursementTypeNotFoundException {
		ReimbursementType type = rt.getReimbursementTypeById(id);
		return type;
	}
	
	public List<ReimbursementType> getReimbursementType() {
		return rt.getReimbursementType();
	} 
}