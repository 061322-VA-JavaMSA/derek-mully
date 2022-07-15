package services;

import java.util.List;

import daos.ReimbursementDao;
import daos.ReimbursementHibernate;
import daos.ReimbursementStatusDao;
import daos.ReimbursementStatusHibernate;
import daos.UserDao;
import daos.UserHibernate;
import exceptions.ReimbursementNotCreatedException;
import exceptions.ReimbursementNotFoundException;
import exceptions.ReimbursementNotUpdatedException;
import exceptions.UserNotFoundException;
import models.Reimbursement;
import models.ReimbursementStatus;
import models.User;

public class ReimbursementService {
	
	private ReimbursementDao rd = new ReimbursementHibernate();
	private ReimbursementStatusDao rsd = new ReimbursementStatusHibernate();
	private UserDao ud = new UserHibernate();
	
	public Reimbursement createReimbursement(Reimbursement r) throws ReimbursementNotCreatedException {
		
		Reimbursement newReimbursement = rd.createReimbursement(r);
		return newReimbursement;
		
		
	}
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = rd.getReimbursements();
		return reimbursements;
	}
	
	public Reimbursement getReimbursementById(int id) throws UserNotFoundException {
		Reimbursement r = rd.getReimbursementById(id);
		if (r == null) {
			throw new UserNotFoundException();
		}
			
		return r;
	}
	public ReimbursementStatus getReimbursementStatusById(int id) {
		ReimbursementStatus status = rsd.getReimbursementStatusById(id);
		return status;
	}

	public boolean setStatusByID(int id, int user_id, String status) throws ReimbursementNotUpdatedException {
 		ReimbursementStatus rs = rsd.getReimbursementByStatus(status);
 		User user = ud.getUserById(user_id);
		boolean checkUpdate = rd.setStatusByID(id, user, rs);
		if (checkUpdate == false) {
			throw new ReimbursementNotUpdatedException();
		}		 
		return checkUpdate;
	}
		
		
	}