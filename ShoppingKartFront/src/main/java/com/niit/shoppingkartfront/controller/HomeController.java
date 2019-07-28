package com.niit.shoppingkartfront.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCartBackend.DAO.CategoryDAO;
import com.niit.ShoppingCartBackend.DAO.ProductDAO;
import com.niit.ShoppingCartBackend.DAO.SupplierDAO;
import com.niit.ShoppingCartBackend.Model.Category;
import com.niit.ShoppingCartBackend.Model.Product;
import com.niit.ShoppingCartBackend.Model.Supplier;

@Controller
public class HomeController {

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("/")
	public String homePage(Model model) {
		List<Product> productList = productDAO.list();
		model.addAttribute("productList", productList);

		return "home";
	}
@RequestMapping("home")
public String HomePage(Model model){
	List<Product> productList = productDAO.list();
	model.addAttribute("productList", productList);

	return "home";
}
	@RequestMapping("signupPage")
	public ModelAndView newSignup() {

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("signupButtonClicked", true);
		return mv;
	}

	@RequestMapping("cartPage")
	public ModelAndView newCart() {

		ModelAndView mv = new ModelAndView("NewCart");
		return mv;
	}

	@RequestMapping("/loginpage")
	public ModelAndView loginpage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		ModelAndView mv = new ModelAndView("home");

		if (error != null) {
			model.addAttribute("error", "Mail Id or Password Incorrect");
		}

		if (logout != null) {
			model.addAttribute("logout", "Logged out Successfully");
		}

		mv.addObject("loginButtonClicked", true);
		return mv;
	}

	@RequestMapping("loginPage")
	public ModelAndView newLogin() {

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("loginButtonClicked", true);
		return mv;
	}

}
