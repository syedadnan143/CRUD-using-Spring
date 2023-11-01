package productcrudapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudappdao.ProductDao;
import productcrudappmodel.Product;

@ComponentScan(basePackages = "productcrudappdao") // Specify the correct package name
@Controller

public class MainController {
	
	
	 @Autowired 
	 private ProductDao productDao;
	 
 
	@RequestMapping("/")
	public String home(Model m) {
		
		  List<Product>products=productDao.getProducts();
		  m.addAttribute("products",products);
		 
		return "index";
	}
	// show the add product-form
    @RequestMapping("/addproduct")
	public String addproduct(Model m) {
    	m.addAttribute("title", "add product");
		return "add-product-form";
	}
    // handle add product form
    @RequestMapping( value="/handle-product", method = RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request) {
    	
    	RedirectView redirectView = new RedirectView();
    	this.productDao.createProduct(product);
    	System.out.println(product);
    	redirectView.setUrl(request.getContextPath()+ "/");
    	return redirectView;
    }
    
    // create a delete handler
    @RequestMapping("/delete/{productz}")
    public RedirectView deleteProduct(@PathVariable("productz")int productz, HttpServletRequest request) {
    this.productDao.deleteProduct(productz);	
     RedirectView redirectView = new RedirectView();
    redirectView.setUrl(request.getContextPath()+ "/");
	return redirectView;
    }
    
    // update the handler
    @RequestMapping("/update/{productid}")
    public String updateform(@PathVariable("productid")int pid, Model m) {
        Product product =  this.productDao.getProduct(pid);
        m.addAttribute("product", product);
    	return "update-form";
    }
}
