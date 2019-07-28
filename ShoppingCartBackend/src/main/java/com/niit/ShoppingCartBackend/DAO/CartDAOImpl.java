package com.niit.ShoppingCartBackend.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCartBackend.Model.Cart;
import com.niit.ShoppingCartBackend.Model.Category;

@Repository("CartDAO")
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private Object cart;
	
	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Cart> list() {
		@SuppressWarnings({ "unchecked" })
		List<Cart> listCart = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCart;
	}


	@Transactional
	public Cart getByCartId(int cartid) {
		String hql = "from Cart where cartId ='" + cartid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) (query).list();

		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}
		return null;
	}

	@Transactional
	public Cart getByProductId(int productid) {
		String hql = "from Cart where ProductId ='" + productid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) (query).list();

		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}
		return null;
	}

	@Transactional
	public Cart getByProductName(String productname) {
		String hql = "from Cart where ProductName ='" + productname + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) (query).list();

		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}
		return null;

	}
	
	@Transactional
	public  List<Cart> getByEmailId(String email) {
		String hql = "from Cart where EmailId ='" + email +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		
		return list;
	}
	
	@Transactional
	public Long getTotalAmount(int id) {
	String hql = "select sum(total) from Cart where userId = " + "'" + id + "'" + "and status = '" + "N" +"'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	Long sum = (Long) query.uniqueResult();
		return sum;
	}

	@Transactional
	public void save(Cart cart) {
		
		
		sessionFactory.getCurrentSession().save(cart);
	}

	@Transactional
	public void delete(int cartId) {
		Cart cartToDelete = new Cart();
		cartToDelete.setCartId(cartId);
		sessionFactory.getCurrentSession().delete(cartToDelete);
		
	}
	@Transactional
	public boolean itemAlreadyExist(String emailId, int productId, boolean b) {
		String hql = "from Cart where emailId= '" + emailId + "' and " + " productId ='" + productId+"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}
	@Transactional
	public Cart getByUserandProduct(String emailId, int productId) {
		String hql = "from Cart where emailId= '" + emailId + "' and " + " productId ='" + productId+"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) query.list();
		
		if (listCart != null && !listCart.isEmpty()){
			return listCart.get(0);
		}
		return null;
	}
	@Transactional
	public void updateshipping(String emailId, int shippingId) {
		String hql = " update Cart set shippingId = '" + shippingId + "' where emailId = '" + emailId + "'";
		sessionFactory.getCurrentSession().createQuery(hql);
	
	}

	@Transactional
	public void saveOrUpdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}
	
	

}	