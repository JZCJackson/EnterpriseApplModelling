package com.project.controllers.rcm;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.project.dao.rcm.CategoriesRepository;
import com.project.dao.rcm.ProductRepository;
import com.project.dao.rcm.SuppliersRepository;
import com.project.entities.User;
import com.project.entities.rcm.Categories;
import com.project.entities.rcm.Product;
import com.project.entities.rcm.Suppliers;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoriesRepository categoryRepository;
	
	@Autowired
	SuppliersRepository suppliersRepository;
	
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
	public String showform(HttpServletRequest request, Model m) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (!user.getRole().equals("supplier")) {
			return "redirect:/profile";
		}
		List<Categories> categories = categoryRepository.findAll();
		Map<Integer, String> catItems = new LinkedHashMap<Integer, String>();
		for (int i = 0; i < categories.size(); i++) {
			String tag = categories.get(i).getName();
			catItems.put(categories.get(i).getCategory_id(),  tag);
		}
		List<Suppliers> suppliers = suppliersRepository.findAll();
		Map<Integer, String> supItems = new LinkedHashMap<Integer, String>();
		for (int i = 0; i < suppliers.size(); i++) {
			String tag = suppliers.get(i).getName();
			supItems.put(suppliers.get(i).getSupplier_id(),  tag);
		}
		m.addAttribute("categories", catItems);
		m.addAttribute("suppliers", supItems);
		m.addAttribute("command", new Product());
		return "product-new";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(HttpServletRequest request, @PathVariable int id, Model m) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		if (!user.getRole().equals("supplier")) {
			return "redirect:/profile";
		}
		List<Categories> categories = categoryRepository.findAll();
		Map<Integer, String> catItems = new LinkedHashMap<Integer, String>();
		for (int i = 0; i < categories.size(); i++) {
			String tag = categories.get(i).getName();
			catItems.put(categories.get(i).getCategory_id(),  tag);
		}
		List<Suppliers> suppliers = suppliersRepository.findAll();
		Map<Integer, String> supItems = new LinkedHashMap<Integer, String>();
		for (int i = 0; i < suppliers.size(); i++) {
			String tag = suppliers.get(i).getName();
			supItems.put(suppliers.get(i).getSupplier_id(),  tag);
		}
		m.addAttribute("categories", catItems);
		m.addAttribute("suppliers", supItems);
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
	public String save(@ModelAttribute("product") Product product, BindingResult bindingResult) {
		productRepository.save(product);
		return "redirect:/products/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		productRepository.deleteById(id);
		return "redirect:/products/";
	}
}
