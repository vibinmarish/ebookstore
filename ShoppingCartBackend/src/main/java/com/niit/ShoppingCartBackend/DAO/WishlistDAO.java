package com.niit.ShoppingCartBackend.DAO;

import java.util.List;

import com.niit.ShoppingCartBackend.Model.Whishlist;

public interface WishlistDAO {
	
	public List<Whishlist> list();
	
	public Whishlist getByProductName(String productname);		
	
	public Whishlist getByProductId(int productid);	
	
    public Whishlist getByPrice(String price);
	
	public void saveOrUpdate(Whishlist wishlist);
		
	public void delete(String Productname);

}
