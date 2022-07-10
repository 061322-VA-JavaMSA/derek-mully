package Services;

import java.util.List;

import DAO.DAOEmployer;
import DAO.HibernateEmployer;
import Models.Reimbursement;

public class EmployerService {
	private DAOEmployer de = new HibernateEmployer();
	public List<Reimbursement> getReimbursement(){
		return de.getReimbursement();
	}
	
	public void updateReimbursement(Reimbursement r) {
		de.updateReimbursement(r);
	}
	
	
}