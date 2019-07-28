package com.niit.ShoppingCartBackend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Table(name = "Product")
@Entity
@Component
public class Product {
	
@Id
@GeneratedValue
private int productId;

private String productName;

private String productDescription;

private int stock;

private int price;

private String category;

private String supplierName;

@Transient
private MultipartFile image;



public MultipartFile getImage() {
	return image;
}

public void setImage(MultipartFile image) {
	this.image = image;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getProductDescription() {
	return productDescription;
}

public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getSupplierName() {
	return supplierName;
}

public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}



}
