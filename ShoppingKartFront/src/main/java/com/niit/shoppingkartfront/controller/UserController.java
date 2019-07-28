package com.niit.shoppingkartfront.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ShoppingCartBackend.DAO.BillingaddressDAO;
import com.niit.ShoppingCartBackend.DAO.ProductDAO;
import com.niit.ShoppingCartBackend.DAO.RoleDAO;
import com.niit.ShoppingCartBackend.DAO.ShippingaddressDAO;
import com.niit.ShoppingCartBackend.DAO.UserDAO;
import com.niit.ShoppingCartBackend.Model.Billingaddress;
import com.niit.ShoppingCartBackend.Model.Product;
import com.niit.ShoppingCartBackend.Model.Role;
import com.niit.ShoppingCartBackend.Model.Shippingaddress;
import com.niit.ShoppingCartBackend.Model.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ShippingaddressDAO shippingaddressDAO;
	@Autowired
	private BillingaddressDAO billingaddressDAO;
	
	@Autowired
	private ProductDAO productDAO;

	
	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private Role role;

	@RequestMapping("addNewUser")
	public String addUser(@ModelAttribute User user, @ModelAttribute Shippingaddress shippingaddress, @ModelAttribute Billingaddress billingaddress, Model model) {
		
		String message;
		
		if(userDAO.isAllReadyRegister(user.getEmailId(), true)){
			message = "Your emailId is Alread registered you have to login";
			
		}
		else{
			
		
		user.setEnabled(true);
		role.setEmailId(user.getEmailId());
		role.setRole("ROLE_USER");
		role.setUserName(user.getUserName());
		role.setContactNumber(user.getContactNumber());

		user.setRole(role);
		role.setUser(user);

		userDAO.saveOrUpdate(user);
		roleDAO.saveOrUpdate(role);
		
		shippingaddress.setUserId(user.getUserId());
		shippingaddressDAO.saveOrUpdate(shippingaddress);
		
		billingaddress.setUserId(user.getUserId());
		billingaddressDAO.saveOrUpdate(billingaddress);
		
		message = "You have Successfully Registered";
		}
		model.addAttribute("message", message);
		model.addAttribute("loginButtonClicked", true);
		return "home";

	}
	@RequestMapping("/afterlogin")
	public String loginProcess(Principal p, Model model){
		
		String email = p.getName();
		
		User user = userDAO.getByEmailId(email);
	
		Role role = roleDAO.getByEmailId(email);
		
		String role1 = role.getRole();
		
		if(role1.equals("ROLE_ADMIN")){
			
			return "AdminLogin";
		}
		else if(role1.equals("ROLE_USER")){
			List<Product> productList = productDAO.list();
			model.addAttribute("productList", productList);
			model.addAttribute("userLoggedIn", "true");
			return "UserLogin";
		}
		else{		
		
		return "NewLogin";
		}
	}
	
}
