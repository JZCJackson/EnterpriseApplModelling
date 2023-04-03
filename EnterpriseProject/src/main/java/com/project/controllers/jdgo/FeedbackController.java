// Define package for the FeedbackController
package com.project.controllers.jdgo;

// Import necessary Java and project classes
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dao.jdgo.FeedbackRepository;
import com.project.dao.rcm.ProductRepository;
import com.project.entities.User;
import com.project.entities.jdgo.Feedback;
import com.project.entities.rcm.Categories;
import com.project.entities.rcm.Product;
import com.project.entities.rcm.Suppliers;

// Annotate the FeedbackController as a Spring Controller and set the request mapping
@Controller
@RequestMapping("/feedback")
public class FeedbackController {

	// Autowire the FeedbackRepository and ProductRepository for data access
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	ProductRepository productRepository;

	// Define a GET method for listing all feedbacks
	@GetMapping("/list")
	public String listFeedbacks(HttpServletRequest request, Model m) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		List<Feedback> feedbacks = feedbackRepository.findAll();
		m.addAttribute("feedbacks", feedbacks);

		return "feedback-list";
	}

	// Define a GET method for showing the add feedback form
	@GetMapping("/add/{productId}")
	public String showAddFeedbackForm(HttpServletRequest request, @PathVariable int productId, Model m) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		Product product = productRepository.findById(productId).orElse(null);
		if (product == null) {
			return "redirect:/products";
		}
		m.addAttribute("user", user);
		m.addAttribute("product", product);
		m.addAttribute("command", new Feedback());
		return "feedback-add";
	}

	// Define a POST method for saving a new feedback
	@PostMapping("/save")
	public String saveFeedback(@ModelAttribute("feedback") Feedback feedback, BindingResult bindingResult ) {
		feedback.setFeedbackDate(new Date());
		feedbackRepository.save(feedback);

		return "redirect:/feedback/list";
	}

	// Define a GET method for deleting a feedback by ID
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		feedbackRepository.deleteById(id);
		return "redirect:/feedback/list";
	}

	// Define a GET method for editing a feedback by ID
    @GetMapping("/edit/{id}")
    public String edit(HttpServletRequest request, @PathVariable int id, Model m) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        Optional<Feedback> feedbackOptional = feedbackRepository.findById(id);
        if (!feedbackOptional.isPresent()) {
            return "redirect:/feedback/list";
        }

        Feedback feedback = feedbackOptional.get();

        m.addAttribute("feedback", feedback);
        return "feedback-edit";
    }
}