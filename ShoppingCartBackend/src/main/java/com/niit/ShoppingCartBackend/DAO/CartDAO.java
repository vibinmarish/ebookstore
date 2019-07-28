package com.niit.ShoppingCartBackend.DAO;

import java.util.List;

import com.niit.ShoppingCartBackend.Model.Cart;


public interface CartDAO {
	
public List<Cart> list();

public Cart getByCartId(int cartid);

public Cart getByProductId(int productid);		

public  List<Cart> getByEmailId(String email);

public Cart getByProductName(String productname);	

public void save(Cart cart);

public void saveOrUpdate(Cart cart);
	
public void delete(int cartId);

public Long getTotalAmount(int id);

public boolean itemAlreadyExist(String emailId, int productId, boolean b);

public Cart getByUserandProduct(String emailId, int productId);

public void updateshipping(String emailId, int shippingId);
}
