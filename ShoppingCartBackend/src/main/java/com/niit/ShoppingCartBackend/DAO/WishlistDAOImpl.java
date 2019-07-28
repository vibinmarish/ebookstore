package com.niit.ShoppingCartBackend.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCartBackend.Model.Category;
import com.niit.ShoppingCartBackend.Model.User;
import com.niit.ShoppingCartBackend.Model.Whishlist;

@Repository("WishlistDAO")
public class WishlistDAOImpl implements WishlistDAO {
	
	public WishlistDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Whishlist> list() {
		@SuppressWarnings({ "unchecked" })
		List<Whishlist> listWhishlist = (List<Whishlist>) sessionFactory.getCurrentSession().createCriteria(Whishlist.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listWhishlist;
	}


	@Transactional
	public Whishlist getByProductName(String productname) {
		String hql = "from Whishlist where ProductName ='" + productname + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Whishlist> listWhishlist = (List<Whishlist>) (query).list();

		if (listWhishlist != null && !listWhishlist.isEmpty()) {
			return listWhishlist.get(0);
		}
		return null;
	}

	@Transactional
	public Whishlist getByProductId(int productid) {
		String hql = "from Whishlist where ProductId ='" + productid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Whishlist> listWhishlist = (List<Whishlist>) (query).list();

		if (listWhishlist != null && !listWhishlist.isEmpty()) {
			return listWhishlist.get(0);
		}
		return null;
	}

	@Transactional
	public Whishlist getByPrice(String price) {
		String hql = "from Whishlist where Price ='" + price + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Whishlist> listWhishlist = (List<Whishlist>) (query).list();

		if (listWhishlist != null && !listWhishlist.isEmpty()) {
			return listWhishlist.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(Whishlist wishlist) {
		sessionFactory.getCurrentSession().saveOrUpdate(wishlist);
		
	}

	@Transactional
	public void delete(String Productname) {
		Whishlist wishlistToDelete = new Whishlist();
		wishlistToDelete.setProductName(Productname);
		sessionFactory.getCurrentSession().delete(wishlistToDelete);
	}
		
}
