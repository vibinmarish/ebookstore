package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCartBackend.DAO.BillingaddressDAO;
import com.niit.ShoppingCartBackend.DAO.CartDAO;
import com.niit.ShoppingCartBackend.DAO.CategoryDAO;
import com.niit.ShoppingCartBackend.DAO.ProductDAO;
import com.niit.ShoppingCartBackend.DAO.RoleDAO;
import com.niit.ShoppingCartBackend.DAO.ShippingaddressDAO;
import com.niit.ShoppingCartBackend.DAO.SupplierDAO;
import com.niit.ShoppingCartBackend.DAO.UserDAO;
import com.niit.ShoppingCartBackend.DAO.WishlistDAO;
import com.niit.ShoppingCartBackend.Model.Billingaddress;
import com.niit.ShoppingCartBackend.Model.Cart;
import com.niit.ShoppingCartBackend.Model.Category;
import com.niit.ShoppingCartBackend.Model.User;
import com.niit.ShoppingCartBackend.Model.Whishlist;
import com.niit.ShoppingCartBackend.Model.Product;
import com.niit.ShoppingCartBackend.Model.Role;
import com.niit.ShoppingCartBackend.Model.Shippingaddress;
import com.niit.ShoppingCartBackend.Model.Supplier;

public class CategoryTest {

	private static Cart productid;

	public static void main (String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("CategoryDAO");
		UserDAO userDAO = (UserDAO) context.getBean("UserDAO");
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		BillingaddressDAO billingaddressDAO = (BillingaddressDAO) context.getBean("BillingaddressDAO");
		CartDAO cartDAO = (CartDAO) context.getBean("CartDAO");
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
		WishlistDAO wishlistDAO = (WishlistDAO) context.getBean("WishlistDAO");
		ShippingaddressDAO shippingaddressDAO = (ShippingaddressDAO) context.getBean("ShippingaddressDAO");
		RoleDAO roleDAO = (RoleDAO) context.getBean("RoleDAO");
		
		Category category = (Category) context.getBean("category");
		User user = (User) context.getBean("user");
		Product product = (Product) context.getBean("product");
		Billingaddress billingaddress = (Billingaddress) context.getBean("billingaddress");
		Cart cart = (Cart) context.getBean("cart");
		Supplier supplier = (Supplier) context.getBean("supplier");
		Whishlist whishlist = (Whishlist) context.getBean("whishlist");
		Shippingaddress shippingaddress = (Shippingaddress) context.getBean("shippingaddress");
		Role role = (Role) context.getBean("role");
		
		
		category.setCategoryName("Watches");
		
		categoryDAO.saveOrUpdate(category);
		
		
		user.setUserName("skfr");
		user.setEmailId("jhvd@gmail.com");
		user.setPassword("jfkd");
		
		user.setContactNumber(98765);
		user.setAddress("s12,sejkajdh");
		user.setZipcode(75426);

		role.setUserName("kjgdffd");
		role.setEmailId("hgfshdghj");
		role.setContactNumber(6567);
		
		user.setRole(role);
		role.setUser(user);
		
		userDAO.saveOrUpdate(user);
		roleDAO.saveOrUpdate(role);
		
		
		product.setProductName("fdknmfg");
		productDAO.saveOrUpdate(product);
		
		billingaddress.setAddress("hfdjdufuinv");
		billingaddress.setContactNumber(897465);
		billingaddressDAO.saveOrUpdate(billingaddress);
		
		
		cart.setProductName("dfhjj");
		cartDAO.save(cart);
		
		
		supplier.setSupplierName("hddsjk");
		supplier.setContactNumber(87968764);
		supplierDAO.saveOrUpdate(supplier);
		
		
		whishlist.setProductName("dhjf");
		whishlist.setPrice(87);
		wishlistDAO.saveOrUpdate(whishlist);
		
		shippingaddress.setAddress("fdgfs");
		shippingaddress.setUserName("jkfgjd");
		shippingaddressDAO.saveOrUpdate(shippingaddress);
		
		
	}

}
