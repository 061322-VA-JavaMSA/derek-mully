package dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.reimbursement;
import utilities.hibernateUtil;

public class employerHibernate implements employerDao {
	public List<reimbursement> getReimbursement(){
		List<reimbursement> r = null;
		try(Session s = hibernateUtil.getSessionFactory().openSession()) {
			r = s.createQuery("from Reimbursement", reimbursement.class).list();
		}
		return r;
		
	}
	
	public void updateReimbursement(reimbursement r) {
		
		try(Session s = hibernateUtil.getSessionFactory().openSession()) {
			String str = "Update Reimbursement set reimbResolved = :res," + "reimbStatusId = :sid " + "where reimbId = :id";
			Transaction txn = s.beginTransaction();
			Query query = s.createQuery(str);
			
			query.setParameter("res", r.getReimbResolved());
			query.setParameter("sid", r.getReimbStatusId());
			query.setParameter("id", r.getReimbId());
			query.executeUpdate();
			txn.commit();
			
		}
	
	}

}
