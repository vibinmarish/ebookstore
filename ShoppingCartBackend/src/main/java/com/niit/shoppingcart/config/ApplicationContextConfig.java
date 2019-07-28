package com.niit.shoppingcart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ShoppingCartBackend.DAO.BillingaddressDAO;
import com.niit.ShoppingCartBackend.DAO.BillingaddressDAOImpl;
import com.niit.ShoppingCartBackend.DAO.CartDAO;
import com.niit.ShoppingCartBackend.DAO.CartDAOImpl;
import com.niit.ShoppingCartBackend.DAO.CategoryDAO;
import com.niit.ShoppingCartBackend.DAO.CategoryDAOImpl;
import com.niit.ShoppingCartBackend.DAO.ProductDAO;
import com.niit.ShoppingCartBackend.DAO.ProductDAOImpl;
import com.niit.ShoppingCartBackend.DAO.RoleDAO;
import com.niit.ShoppingCartBackend.DAO.RoleDAOImpl;
import com.niit.ShoppingCartBackend.DAO.ShippingaddressDAO;
import com.niit.ShoppingCartBackend.DAO.ShippingaddressDAOImpl;
import com.niit.ShoppingCartBackend.DAO.SupplierDAO;
import com.niit.ShoppingCartBackend.DAO.SupplierDAOImpl;
import com.niit.ShoppingCartBackend.DAO.UserDAO;
import com.niit.ShoppingCartBackend.DAO.UserDAOImpl;
import com.niit.ShoppingCartBackend.DAO.WishlistDAO;
import com.niit.ShoppingCartBackend.DAO.WishlistDAOImpl;
import com.niit.ShoppingCartBackend.Model.Billingaddress;
import com.niit.ShoppingCartBackend.Model.Cart;
import com.niit.ShoppingCartBackend.Model.Category;
import com.niit.ShoppingCartBackend.Model.Product;
import com.niit.ShoppingCartBackend.Model.Role;
import com.niit.ShoppingCartBackend.Model.Shippingaddress;
import com.niit.ShoppingCartBackend.Model.Supplier;
import com.niit.ShoppingCartBackend.Model.User;
import com.niit.ShoppingCartBackend.Model.Whishlist;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/ShoppingKart");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		
		return dataSource;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Billingaddress.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Whishlist.class);
		sessionBuilder.addAnnotatedClass(Shippingaddress.class);
		sessionBuilder.addAnnotatedClass(Role.class);
		return sessionBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired(required = true)
	@Bean(name = "CategoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
		return new CategoryDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "UserDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "ProductDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory) {
		return new ProductDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "BillingaddressDAO")
	public BillingaddressDAO getBillingaddresstDAO(SessionFactory sessionFactory) {
		return new BillingaddressDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "CartDAO")
	public CartDAO getCartDAO(SessionFactory sessionFactory) {
		return new CartDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "SupplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory) {
		return new SupplierDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "WishlistDAO")
	public WishlistDAO getWishlistDAO(SessionFactory sessionFactory) {
		return new WishlistDAOImpl(sessionFactory);
	}
	
	@Autowired(required = true)
	@Bean(name = "ShippingaddressDAO")
	public ShippingaddressDAO getShippingaddressDAO(SessionFactory sessionFactory) {
		return new ShippingaddressDAOImpl(sessionFactory);
	}
	@Autowired(required = true)
	@Bean(name = "RoleDAO")
	public RoleDAO getRoleDAO(SessionFactory sessionFactory) {
		return new RoleDAOImpl(sessionFactory);
	}
}











