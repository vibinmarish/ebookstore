package com.niit.shoppingkartfront.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCartBackend.DAO.SupplierDAO;
import com.niit.ShoppingCartBackend.Model.Supplier;


@Controller
public class SupplierController {
	
	@Autowired
	private SupplierDAO supplierDAO;
	@RequestMapping("supplierPage")
	public ModelAndView newSupplier(){
		
		ModelAndView mv = new ModelAndView("AdminLogin");
		mv.addObject("AddSupplierButtonClicked", true);
		return mv;
	}
	
	
	@RequestMapping("addSupplier")
	public String addSupplier(@ModelAttribute Supplier supplier){
		supplierDAO.saveOrUpdate(supplier);
		return "redirect:viewSupplier";
		
	}
	
	@RequestMapping("viewSupplier")
	public String viewSupplier(Model model){
		
		List<Supplier> supplierList = supplierDAO.list();
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("ViewSupplierButtonClicked", true);
		
		return "AdminLogin";
		
	}
	
	@RequestMapping("deleteSupplier")
	public String deleteSupplier(@RequestParam("supplierId") int supplierid ,Model model){
		
		supplierDAO.delete(supplierid);
		return "redirect:viewSupplier";
		
	}
	
	@RequestMapping("editSupplier")
	public String editSupplier(@RequestParam ("supplierId") int supplierId, Model model){
		Supplier supplier = supplierDAO.getBySupplierId(supplierId);
		model.addAttribute("supplier", supplier);
		model.addAttribute("editSupplierClicked", true);
		return "AdminLogin";
		
	}
	@RequestMapping("supplierEdited")
	public String supplierEdited(@ModelAttribute Supplier supplier){
		
		supplierDAO.saveOrUpdate(supplier);
		return "redirect:viewSupplier";
	}

 }