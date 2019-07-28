package com.niit.ShoppingCartBackend.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCartBackend.Model.Product;
import com.niit.ShoppingCartBackend.Model.Supplier;

@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO{
	
	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Supplier> list() {
		@SuppressWarnings({ "unchecked" })
		List<Supplier> listSupplier = (List<Supplier>) sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listSupplier;
	}

	@Transactional
	public Supplier getBySupplierName(String suppliername) {
		String hql = "from Supplier where SupplierName ='" + suppliername + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) (query).list();

		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		return null;
	}

	@Transactional
	public Supplier getBySupplierId(int supplierid) {
		String hql = "from Supplier where SupplierId='" + supplierid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) (query).list();

		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		return null;
	}

	@Transactional
	public Supplier getByContactNumber(int contactnumber) {
		String hql = "from Supplier where ContactNumber='" + contactnumber + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) (query).list();

		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		
	}

	@Transactional
	public void delete(int supplierid) {
		Supplier supplierToDelete = new Supplier();
		supplierToDelete.setSupplierId(supplierid);
		sessionFactory.getCurrentSession().delete(supplierToDelete);
		
	}

	

}
