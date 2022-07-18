package daos;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.NativeQuery;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import models.Reimbursement;
import models.ReimbursementStatus;
import models.Status;
import models.User;
import util.HibernateUtil;

public class ReimbursementHibernate implements ReimbursementDao {

	@Override
	public Reimbursement createReimbursement(Reimbursement r) {
		r.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			@SuppressWarnings("deprecation")
			int id = (int) s.save(r);
			r.setId(id);
			tx.commit();	
		} catch(ConstraintViolationException e) {
			
		}
		return r;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
			Reimbursement reimbursement = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			reimbursement = s.get(Reimbursement.class, id);
		}
		
		return reimbursement;
	}

	@Override
	public Reimbursement getReimbursementbyStatus(Status status) {

		return null;
	}

	@Override
	public Reimbursement getReimbursementByUsername(String username) {

		return null;
	}

	@Override
	public List<Reimbursement> getReimbursements() {
			List<Reimbursement> reimbursement = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			reimbursement = s.createQuery("from Reimbursement ", Reimbursement.class).list();
		}
		
		return reimbursement;
	}

	@Override
	public List<Reimbursement> getByAuthor(User u) {

		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean setStatusByID(int id, User resolver, ReimbursementStatus status) {
		int rowsChanged = -1;
		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			System.out.println(id);
			System.out.println(resolver.toString());
			System.out.println(status.toString());
			@SuppressWarnings("unused")
			Transaction trans = s.beginTransaction();
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaUpdate<Reimbursement> cu = cb.createCriteriaUpdate(Reimbursement.class);
			Root<Reimbursement> root  = cu.from(Reimbursement.class);

			
			String sql = "update reimbursement set resolver_id = :resolver_id, reimbursement_status_id = :reimbursement_status_id  where id = :id ;";
			NativeQuery<User> nq = s.createNativeQuery(sql, User.class);
			nq.setParameter("id", id);
			nq.setParameter("resolver_id", resolver.getId());
			nq.setParameter("reimbursement_status_id", status.getId());
			rowsChanged = nq.executeUpdate();
			
			if (rowsChanged < 1) {
				return false;
			}
		}
		return true;	
	
	}
	}
	
	
