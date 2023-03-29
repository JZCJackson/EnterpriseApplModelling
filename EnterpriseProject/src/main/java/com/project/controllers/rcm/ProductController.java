package com.project.controllers.rcm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.project.dao.rcm.ProductRepository;
import com.project.entities.User;
import com.project.entities.rcm.Product;

@Controller
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
    public String listProducts(HttpServletRequest request) {
		List<Product> products = productRepository.findAll();
		System.out.println(products.size());
        return "login";
    }
}
