package com.project.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.project.dao.UserRepository;
import com.project.entities.User;

@Controller
public class UserController {


	@Autowired
    private UserRepository userRepository;


	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "login";
	}

	@GetMapping("/register")
	public String registerForm(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "register";
		} else {
			return "profile";
		}
	}

	@PostMapping("/register")
    public RedirectView registerUser(@ModelAttribute("user") User user, HttpServletRequest request) {
        userRepository.save(user);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/login");
        return redirectView;
    }

	@GetMapping("/login")
	public String loginForm(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		} else {
			return "profile";
		}
	}

	@PostMapping("/login")
    public RedirectView loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
            HttpServletRequest request, Model model) {
        Optional<User> userOptional = userRepository.findByEmailAndPassword(email, password);
        RedirectView redirectView = new RedirectView();
        if (userOptional.isPresent()) {
            request.getSession().setAttribute("user", userOptional.get());
            redirectView.setUrl(request.getContextPath() + "/profile");
        } else {
            redirectView.setUrl(request.getContextPath() + "/login");
        }
        return redirectView;
    }

	@GetMapping("/profile")
	public String profile(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		return "profile";
	}
}
