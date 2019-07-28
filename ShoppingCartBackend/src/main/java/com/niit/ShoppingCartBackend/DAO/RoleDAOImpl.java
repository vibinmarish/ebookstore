package com.niit.ShoppingCartBackend.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCartBackend.Model.Billingaddress;
import com.niit.ShoppingCartBackend.Model.Role;

@Repository("RoleDAO")
public class RoleDAOImpl implements RoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public RoleDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
	@Transactional
	public List<Role> list() {
		@SuppressWarnings({ "unchecked" })
		List<Role> listRole = (List<Role>) sessionFactory.getCurrentSession().createCriteria(Role.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listRole;
	}
 
	@Transactional
	public Role getByUserName(String username) {
		String hql = "from Role where userName ='" + username + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Role> listRole = (List<Role>) (query).list();

		if (listRole != null && !listRole.isEmpty()) {
			return listRole.get(0);
		}
		return null;
	}

	@Transactional
	public Role getByEmailId(String emailid) {
		String hql = "from Role where emailId ='" + emailid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Role> listRole = (List<Role>) (query).list();

		if (listRole != null && !listRole.isEmpty()) {
			return listRole.get(0);
		}
		return null;
	}

	@Transactional
	public Role getByContactNumber(int contactnumber) {
		String hql = "from Role where contactNumber ='" + contactnumber + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Role> listRole = (List<Role>) (query).list();

		if (listRole != null && !listRole.isEmpty()) {
			return listRole.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
		
	}

	@Transactional
	public void delete(String username) {
		Role roleToDelete = new Role();
		roleToDelete.setUserName(username);
		sessionFactory.getCurrentSession().delete(roleToDelete);
		
	}

	}