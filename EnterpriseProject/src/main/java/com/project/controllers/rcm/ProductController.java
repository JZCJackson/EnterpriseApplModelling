package com.project.controllers.rcm;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.project.dao.rcm.ProductRepository;
import com.project.entities.User;
import com.project.entities.rcm.Product;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/")
    public String listProducts(HttpServletRequest request, Model m) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		List<Product> products = productRepository.findAll();
		m.addAttribute("products", products);
        return "products";
    }
	
	@GetMapping("/new")
	public String showform(Model m) {
		m.addAttribute("command", new Product());
		return "product-new";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Optional<Product> product = productRepository.findById(id);
		m.addAttribute("product", product.get());
		return "product-edit";
	}
	
	@PostMapping("/update")
	public String updateProduct(@ModelAttribute("product") Product product) {
		productRepository.save(product);
		return "redirect:/products/";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("product") Product product) {
		productRepository.save(product);
		return "redirect:/products/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		productRepository.deleteById(id);
		return "redirect:/products/";
	}
}
