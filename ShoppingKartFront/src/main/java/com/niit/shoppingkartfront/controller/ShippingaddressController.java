package com.niit.shoppingkartfront.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCartBackend.DAO.CartDAO;
import com.niit.ShoppingCartBackend.DAO.ShippingaddressDAO;
import com.niit.ShoppingCartBackend.DAO.UserDAO;
import com.niit.ShoppingCartBackend.Model.Cart;
import com.niit.ShoppingCartBackend.Model.Shippingaddress;
import com.niit.ShoppingCartBackend.Model.User;



@Controller
public class ShippingaddressController {
	@Autowired
	private ShippingaddressDAO shippingaddressDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private Cart cart;

	@RequestMapping("shippingaddressPage")
	public ModelAndView newShippingaddress(){
		
		ModelAndView mv = new ModelAndView("UserLogin");
		mv.addObject("newShippingaddressClicked", "true");
		return mv;
	}
	@RequestMapping("addShippingaddress")
	public String addShippingaddress(Principal p, @ModelAttribute Shippingaddress shippingaddress){
		String email = p.getName();
		User user = userDAO.getByEmailId(email);
		shippingaddress.setUserId(user.getUserId());
		shippingaddress.setEmailId(email);
		shippingaddressDAO.saveOrUpdate(shippingaddress);
		return "redirect:proceed";
		
	}
	
	@RequestMapping("proceed")
	public String Proceed(Principal p, Model model){
		String email = 	p.getName();
		List<Shippingaddress> shippingList = shippingaddressDAO.list(email);
		model.addAttribute("shippingList", shippingList);
		model.addAttribute("viewShippingAddressClicked", true);
	 return "UserLogin";
	}
	@RequestMapping("shippingAddress")
	public String shippingAddress(@RequestParam("shippingId") int shippingId, Principal p, Model model){
		
		String email = p.getName();
		
		/*cartDAO.updateshipping(email, shippingId);*/
		model.addAttribute("thankyouPage", true);
		
		List<Cart> cartList = cartDAO.getByEmailId(email);
		
		for(Cart c : cartList){
			c.setShippingId(shippingId);
			cartDAO.save(c);
		}
		
		return "UserLogin";
		
	}
	@RequestMapping("deleteshippingAddress")
	public String deleteshippingAddress(@RequestParam("shippingId") int shippingId, Model model){
		shippingaddressDAO.delete(shippingId);
		return "redirect:proceed";
		
	}
	@RequestMapping("editshippingAddress")
	public String editshippingAddress(@RequestParam("shippingId")int shippingId,Model model){
	Shippingaddress shippingaddress=	shippingaddressDAO.getByShippingId(shippingId);
		model.addAttribute("shippingaddress", shippingaddress);
		model.addAttribute("editShippingAddressClicked", true);
		return "UserLogin";
		
	}
	@RequestMapping("editShippingaddress")
	public String editShippingAddress(Principal p, @ModelAttribute Shippingaddress shippingaddress, Model model){
		
		String email = p.getName();
		User user = userDAO.getByEmailId(email);
		
		shippingaddress.setEmailId(email);
		shippingaddress.setUserId(user.getUserId());
		
		shippingaddressDAO.saveOrUpdate(shippingaddress);
		return "redirect:proceed";
	}
	
	@ModelAttribute
	public void commonToUser(Model model){
		model.addAttribute("userLoggedIn", "true");
	}
}
