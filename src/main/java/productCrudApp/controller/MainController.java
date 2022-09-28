package productCrudApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productCrudApp.dao.ProductDao;
import productCrudApp.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String Home(Model m)
	{
		List<Product> products = productDao.getProducts();
		
		m.addAttribute("product",products);
		
		return "index";
	}
	
	//show add product form
	@RequestMapping("/add-product")
	public String addProduct(Model m)
	{
		m.addAttribute("title","Add Product");
		return "add_productForm";
	}
	
	
	//handle add product form
	@RequestMapping(value = "/handle-product",method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest req)
	{
		System.out.println(product);
		productDao.createproduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath()+"/");
		return redirectView;
	}
	
	
	//delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int pid,HttpServletRequest req)
	{
		this.productDao.deleteProduct(pid);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath()+"/");
		return redirectView;
	}
	
	
	//update a product by id
	@RequestMapping("/update/{productId}")
	public String updateForm(@PathVariable("productId") int pid,Model m)
	{
		Product products = this.productDao.getProduct(pid);
		
		m.addAttribute("product",products);
		
		return "update_form";
	}
	
}
