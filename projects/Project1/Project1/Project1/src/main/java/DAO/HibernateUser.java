package DAO;

import java.util.List;

import org.hibernate.Session;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import Models.User;
import Utilities.HibernateUtil;

public class HibernateUser implements DAOUser {
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
	
	public List<User> getUsers() {
		List<User> users = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			users = s.createQuery("from User", User.class).list();
		}
		
		return users;
	}
}