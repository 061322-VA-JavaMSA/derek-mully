package DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import Models.Reimbursement;
import Utilities.HibernateUtil;

public class HibernateEmployee implements DAOEmployee{

	@Override
	public Reimbursement insertReimbursement(Reimbursement r) {
		r.setReimbId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(r);
			r.setReimbId(id);
			tx.commit();	
		} catch(ConstraintViolationException e) {
			//log it
		}
		return r;
	}
	public List<Reimbursement> getReimbursement(){
		List<Reimbursement> r = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()) {
			r = s.createQuery("from Reimbursement", Reimbursement.class).list();
		}
		return r;
		
	}
}