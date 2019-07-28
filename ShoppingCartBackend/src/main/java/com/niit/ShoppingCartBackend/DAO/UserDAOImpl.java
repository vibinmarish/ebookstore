package com.niit.ShoppingCartBackend.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCartBackend.Model.Supplier;
import com.niit.ShoppingCartBackend.Model.User;

@Repository("UserDAO")
public class UserDAOImpl  implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> list() {
		@SuppressWarnings({ "unchecked" })
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}

	@Transactional
	public User getByUserId(int userid) {
		String hql = "from User where userId ='" + userid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) (query).list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}

	

	@Transactional
	public User getByEmailId(String emailid) {
		String hql = "from User where emailId ='" + emailid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) (query).list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		
	}
		return null;
	}
	
	@Transactional
	public User getByPassword(String password) {
		String hql = "from User where password ='" + password + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) (query).list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}
	
	public User getByConformPassword(String conformpassword) {
		String hql = "from User where conformPassword ='" + conformpassword + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) (query).list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		
	}
		return null;
	}

	@Transactional
	public User getByContactNumber(int contactnumber) {
		String hql = "from User where contactNumber ='" + contactnumber + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) (query).list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}

	@Transactional
	public User getByAddress(String address) {
		String hql = "from User where address ='" + address + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) (query).list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}
	
	
	@Transactional
	public User getByZipcode(int zipcode) {
		String hql = "from User where zipcode ='" + zipcode + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) (query).list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		
	}
		return null;
	}
	
	public User getByRole(String role) {
		String hql = "from User where role ='" + role + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) (query).list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		
	}
		return null;
	}
	

	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().save(user);
		
	}

	@Transactional
	public void delete(int Userid) {
		User userToDelete = new User();
		userToDelete.setUserId(Userid);
		sessionFactory.getCurrentSession().delete(userToDelete);
		
	}

	public User getByUserName(String username) {
		String hql = "from User where userName ='" + username + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) (query).list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		
	}
		return null;
	}
	@Transactional
	public boolean isAllReadyRegister(String email, boolean b) {
		
		String hql = "from User where emailId ='"+ email +"'";
				
					
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;

	}
	

}