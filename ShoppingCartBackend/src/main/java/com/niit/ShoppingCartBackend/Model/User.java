package com.niit.ShoppingCartBackend.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table(name = "user")
@Entity
@Component
public class User {

@Id
@Column(name="UserId")
@GeneratedValue
private int userId;

private String userName;

private String emailId;

private String password;

private int contactNumber;

private String address;

private int zipcode;

private boolean enabled;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="UserId")

private Role role;

public Role getRole()
{
	return role;
}

public void setRole(Role role)
{
	this.role=role;
}

public boolean isEnabled() {
	return enabled;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getContactNumber() {
	return contactNumber;
}

public void setContactNumber(int contactNumber) {
	this.contactNumber = contactNumber;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getZipcode() {
	return zipcode;
}

public void setZipcode(int zipcode) {
	this.zipcode = zipcode;
}



}

