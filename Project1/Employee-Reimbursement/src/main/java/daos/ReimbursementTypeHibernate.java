package daos;

import org.hibernate.Session;

import models.ReimbursementType;
import util.HibernateUtil;

public class ReimbursementTypeHibernate implements ReimbursementTypeDao {

	@Override
	public ReimbursementType getReimbursementTypeById(int id) {
		ReimbursementType type = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			type = s.get(ReimbursementType.class, id);
		}
		
		return type;
	}

}