package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import model.user;
import utilities.hibernateUtil;

public class userHibernate implements userDao {
	@Override
	public user getUserByUsername(String username) {
		user user = null;
		
		try(Session s = hibernateUtil.getSessionFactory().openSession();){

			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<user> cq = cb.createQuery(user.class);

			Root<user> root = cq.from(user.class);
			

			Predicate predicateForUsername = cb.equal(root.get("username"), username);

			
			cq.select(root).where(predicateForUsername);
			
			user = (user) s.createQuery(cq).getSingleResult();
		}
		
		return user;
	}
	
	public List<user> getUsers() {
		List<user> users = null;
		
		try(Session s = hibernateUtil.getSessionFactory().openSession()){
			users = s.createQuery("from User", user.class).list();
		}
		
		return users;
	}

	@Override
	public void updateUser(user u) {
		try(Session s = hibernateUtil.getSessionFactory().openSession()) {
			String str = "Update User set email = :email," + "firstName = :fname," + "lastName = :lname " + "where id = :id";
			Transaction txn = s.beginTransaction();
			Query query = s.createQuery(str);
			
			query.setParameter("email", u.getEmail());
			query.setParameter("fname", u.getFirstName());
			query.setParameter("lname", u.getLastName());
			query.setParameter("id", u.getId());
			query.executeUpdate();
			txn.commit();
			
		}
		
	}
}