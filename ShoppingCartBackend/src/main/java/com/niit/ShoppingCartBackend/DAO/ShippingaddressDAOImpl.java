package com.niit.ShoppingCartBackend.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCartBackend.Model.Shippingaddress;

@Repository("ShippingaddressDAO")
public class ShippingaddressDAOImpl implements ShippingaddressDAO {
	
	public ShippingaddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Shippingaddress> list() {
		@SuppressWarnings({ "unchecked" })
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) sessionFactory.getCurrentSession().createCriteria(Shippingaddress.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listShippingaddress;
	}

	@Transactional
	public Shippingaddress getByShippingAddress(String shippingaddress) {
		String hql = "from Shippingaddress where ShippingAddress ='" + shippingaddress + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;
	}

	@Transactional
	public Shippingaddress getByShippingId(int shippingid) {
		String hql = "from Shippingaddress where ShippingId='" + shippingid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;
	}

	@Transactional
	public Shippingaddress getByUserName(String username) {
		String hql = "from Shippingaddress where UserName='" + username + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;
	}

	@Transactional
	public Shippingaddress getByUserId(int userid) {
		String hql = "from Shippingaddress where UserId='" + userid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(Shippingaddress shippingaddress) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(shippingaddress);

	}

	@Transactional
	public void delete(int shippingId) {
		Shippingaddress shippingaddressToDelete = new Shippingaddress();
		shippingaddressToDelete.setShippingId(shippingId);
		sessionFactory.getCurrentSession().delete(shippingaddressToDelete);
		
	}

	@Transactional
	public void editShippingAddress(Shippingaddress shippingaddress) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	public List<Shippingaddress> list(String EmailId) {
		String hql = "from Shippingaddress where EmailId ='" + EmailId +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> list = (List<Shippingaddress>) query.list();
		
		return list;
	}

}