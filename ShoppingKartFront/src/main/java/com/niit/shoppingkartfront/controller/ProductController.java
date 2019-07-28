package com.niit.shoppingkartfront.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCartBackend.DAO.CategoryDAO;
import com.niit.ShoppingCartBackend.DAO.ProductDAO;
import com.niit.ShoppingCartBackend.DAO.SupplierDAO;
import com.niit.ShoppingCartBackend.Model.Category;
import com.niit.ShoppingCartBackend.Model.Product;
import com.niit.ShoppingCartBackend.Model.Supplier;


@Controller
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@RequestMapping("ViewProduct")
	public String ViewProduct(){
		
		return "ViewProduct";
	}
	@RequestMapping("productPage")
	public ModelAndView newProduct(){
		
		ModelAndView mv = new ModelAndView("AdminLogin");
		List<Category> categoryList = categoryDAO.list();
		List<Supplier> supplierList = supplierDAO.list();
		mv.addObject("supplierList", supplierList);
		mv.addObject("categoryList", categoryList);
		mv.addObject("AddProductButtonClicked", true);
		return mv;
	}
	@RequestMapping("addProduct")
	public String addProduct(@ModelAttribute Product product, @RequestParam("file") MultipartFile file ,Model model){
		productDAO.saveOrUpdate(product);
		
		String path = "D://DT/ShoppingKartFront/src/main/webapp/WEB-INF/resources/image/products/";
		FileUtil.upload(path, file, product.getProductId()+".jpg");
		
		model.addAttribute("ViewProductButtonClicked", true);
		
		return "redirect:viewProduct";
		
	}
	@RequestMapping("viewProduct")
	public String viewProducts(Model model){
		
		List<Product> productList = productDAO.list();
		model.addAttribute("productList", productList);
		model.addAttribute("ViewProductButtonClicked", true);
		return "AdminLogin";
		
		
	}
	
	@RequestMapping("deleteProduct")
	public String deleteProducts(@RequestParam("productId") int productid, Model model){
		
		productDAO.delete(productid);
		return "redirect:viewProduct";
	}
	
	@RequestMapping("editProduct")
	public String editProduct(@RequestParam ("productId") int productId, Model model){
		Product product = productDAO.getByProductId(productId);
		model.addAttribute("product", product);
		model.addAttribute("editProductClicked", true);
		return "AdminLogin";
		
	}
	@RequestMapping("productEdited")
	public String productEdited(@ModelAttribute Product product){
		
		productDAO.saveOrUpdate(product);
		return "redirect:viewProduct";
	}

}
