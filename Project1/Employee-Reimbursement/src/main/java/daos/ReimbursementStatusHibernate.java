package daos;

import org.hibernate.Session;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import models.ReimbursementStatus;
import util.HibernateUtil;

public class ReimbursementStatusHibernate implements ReimbursementStatusDao {

	@Override
	public ReimbursementStatus getReimbursementStatusById(int id) {
		ReimbursementStatus status = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			status = s.get(ReimbursementStatus.class, id);
		}
		
		return status;
	}

	@Override
	public ReimbursementStatus getReimbursementByStatus(String reimbursement_status) {
		ReimbursementStatus status = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<ReimbursementStatus> cq = cb.createQuery(ReimbursementStatus.class);
			Root<ReimbursementStatus> root = cq.from(ReimbursementStatus.class);
			Predicate predicateForReimbursementStatusname = cb.equal(root.get("reim_status"), reimbursement_status);
			 
			cq.select(root).where(predicateForReimbursementStatusname);
 			
			status = (ReimbursementStatus) s.createQuery(cq).getSingleResult();
			
		
	}
		return status;
	}

}