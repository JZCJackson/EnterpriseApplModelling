package com.project.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.project.dao.UserRepository;
import com.project.entities.User;

/**

The UserController class defines the HTTP request handling methods for user-related functionalities
*/

@Controller
public class UserController {


	@Autowired
    private UserRepository userRepository;


	/**

	This method handles the GET request for the home page.
	@return the name of the view to be rendered, in this case, "index".
	*/
	@GetMapping("/")
	public String home() {
		return "index";
	}

	/**

	This method handles the GET request for logging out the user.
	@param request the HttpServletRequest object for the current request
	@return the name of the view to be rendered, in this case, "login".
	*/
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "login";
	}

	
	/**

	This method handles the GET request for displaying the registration form.
	@param request the HttpServletRequest object for the current request
	@return the name of the view to be rendered, depending on whether a user is currently logged in or not.
	*/
	@GetMapping("/register")
	public String registerForm(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "register";
		} else {
			return "profile";
		}
	}

	/**

	This method handles the POST request for registering a new user.
	@param user the User object to be registered
	@param request the HttpServletRequest object for the current request
	@return a RedirectView object that redirects the user to the login page after registration.
	*/
	@PostMapping("/register")
    public RedirectView registerUser(@ModelAttribute("user") User user, HttpServletRequest request) {
        userRepository.save(user);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/login");
        return redirectView;
    }

	/**

	This method handles the GET request for displaying the login form.
	@param request the HttpServletRequest object for the current request
	@return the name of the view to be rendered, depending on whether a user is currently logged in or not.
	*/
	@GetMapping("/login")
	public String loginForm(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		} else {
			return "profile";
		}
	}

	/**

	This method handles the POST request for logging in a user.
	@param email the email address of the user
	@param password the password of the user
	@param request the HttpServletRequest object for the current request
	@param model the Model object used for passing data to the view
	@return a RedirectView object that redirects the user to the profile page after successful login, or to the login page if login fails.
	*/
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

	/**

	This method handles the GET request for displaying the user profile.
	@param model the Model object used for passing data to the view
	@param request the HttpServletRequest object for the current request
	@return the name of the view to be rendered, depending on whether a user is currently logged in or not.
	*/
	@GetMapping("/profile")
	public String profile(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		return "profile";
	}
	
	/**

	This method handles the GET request for displaying the form for editing user profile.
	@param id the id of the user to be edited
	@param model the Model object used for passing data to the view
	@param request the HttpServletRequest object for the current request
	@return the name of the view to be rendered, depending on whether a user is currently logged in or not and whether the specified user exists.
	*/
	@GetMapping("profile/edit/{id}")
	public String editProfileForm(@PathVariable int id, Model model, HttpServletRequest request) {
	    User sessionUser = (User) request.getSession().getAttribute("user");
	    if (sessionUser == null) {
	        return "redirect:/login";
	    }
	    Optional<User> userOptional = userRepository.findById(id);
	    if (userOptional.isPresent()) {
	        User user = userOptional.get();
	        model.addAttribute("user", user);
	        return "edit_profile";
	    } else {
	        return "redirect:/profile";
	    }
	}
	

	/**
	
	This method handles the POST request for updating user profile.
	@param user the User object containing updated user information
	@param request the HttpServletRequest object for the current request
	@return a RedirectView object that redirects the user to the profile page after successful update.
	*/
	@PostMapping("/profile/update")
	public RedirectView updateProfile(@ModelAttribute("user") User user, HttpServletRequest request) {
	    User updatedUser = userRepository.save(user);
	    request.getSession().setAttribute("user", updatedUser); // Update the session attribute with the updated user information
	    RedirectView redirectView = new RedirectView();
	    redirectView.setUrl(request.getContextPath() + "/profile");
	    return redirectView;
	}


	/**

	This method handles the POST request for deleting a user profile.
	@param id the id of the user to be deleted
	@param request the HttpServletRequest object for the current request
	@return a RedirectView object that redirects the user to the login page after successful deletion.
	*/
	@PostMapping("profile/delete/{id}")
	public RedirectView deleteProfile(@PathVariable int id, HttpServletRequest request) {
	    userRepository.deleteById(id);
	    request.getSession().removeAttribute("user");
	    RedirectView redirectView = new RedirectView();
	    redirectView.setUrl(request.getContextPath() + "/login");
	    return redirectView;
	}

	
	

	
	
}
