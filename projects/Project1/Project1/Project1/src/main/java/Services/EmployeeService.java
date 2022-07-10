package Services;

import java.util.List;

import DAO.DAOEmployee;
import DAO.HibernateEmployee;
import Models.Reimbursement;

public class EmployeeService {
	private DAOEmployee de = new HibernateEmployee();
	
	public Reimbursement insertReimbursement(Reimbursement r) {
		return de.insertReimbursement(r);
	}
	
	public List<Reimbursement> getReimbursement(){
		return de.getReimbursement();
	}
}