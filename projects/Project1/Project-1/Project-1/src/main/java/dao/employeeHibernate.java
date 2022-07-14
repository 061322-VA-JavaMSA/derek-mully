package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import model.reimbursement;
import utilities.hibernateUtil;

public class employeeHibernate implements employeeDao{

	@Override
	public reimbursement insertReimbursement(reimbursement r) {
		r.setReimbId(-1);
		try(Session s = hibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(r);
			r.setReimbId(id);
			tx.commit();	
		} catch(ConstraintViolationException e) {
			//log it
		}
		return r;
	}
	public List<reimbursement> getReimbursement(){
		List<reimbursement> r = null;
		try(Session s = hibernateUtil.getSessionFactory().openSession()) {
			r = s.createQuery("from Reimbursement", reimbursement.class).list();
		}
		return r;
		
	}
	

}