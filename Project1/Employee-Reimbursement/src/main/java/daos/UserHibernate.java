package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import models.Role;
import models.User;
import util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class UserHibernate implements UserDao {

	@Override
	public User insertUser(User u) {
		u.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			@SuppressWarnings("deprecation")
			int id = (int) s.save(u);
			u.setId(id);
			tx.commit();	
		} catch(ConstraintViolationException e) {
			//log it
		}
		return u;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			user = s.get(User.class, id);
		}
		
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){

			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);

			Root<User> root = cq.from(User.class);
			

			Predicate predicateForUsername = cb.equal(root.get("username"), username);

			
			cq.select(root).where(predicateForUsername);

			user = (User) s.createQuery(cq).getSingleResult();
		}
		
		return user;
	}

	@Override
	public List<User> getUsers() {
		List<User> users = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			users = s.createQuery("from User", User.class).list();
		}
		
		return users;
	}

	@Override
	public User getUserbyRole(Role role) {
	User user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			user = s.get(User.class, role);
		}
		
		return user;
	}

}