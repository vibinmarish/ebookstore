package com.niit.shoppingkartfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCartBackend.DAO.BillingaddressDAO;
import com.niit.ShoppingCartBackend.Model.Billingaddress;

@Controller
public class BillingaddressController {


	@Autowired
	private BillingaddressDAO billingaddressDAO;
	
	@RequestMapping("billingaddressPage")
	public ModelAndView newBillingaddress(){
		
		ModelAndView mv = new ModelAndView("NewBillingaddress");
		return mv;
	}
	
	@RequestMapping("addBillingaddress")
	public String addBillingaddress(@ModelAttribute Billingaddress billingaddress){
		billingaddressDAO.saveOrUpdate(billingaddress);
		return "ViewBillingaddress";
		
	}
}
