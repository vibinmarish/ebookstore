package com.niit.ShoppingCartBackend.DAO;

import java.util.List;

import com.niit.ShoppingCartBackend.Model.Supplier;

public interface SupplierDAO {
	
	public List<Supplier> list();
	
	public Supplier getBySupplierName(String suppliername);		
	
	public Supplier getBySupplierId(int supplierid);	
	
    public Supplier getByContactNumber(int contactnumber);
    
	public void saveOrUpdate(Supplier supplier);
		
	public void delete(int supplierid);

	}


