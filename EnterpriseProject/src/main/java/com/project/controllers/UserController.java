package com.project.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.project.dao.ReservationDao;
import com.project.dao.TicketDao;
import com.project.dao.UserDao;
import com.project.entities.Reservation;
import com.project.entities.Ticket;
import com.project.entities.User;

@Controller
public class UserController {

	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private ReservationDao reservationDao;

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
		userDao.addUser(user);
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
		User user = userDao.getUserByEmailAndPassword(email, password);
		RedirectView redirectView = new RedirectView();
		if (user != null) {
			request.getSession().setAttribute("user", user);
			redirectView.setUrl(request.getContextPath() + "/tickets");
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
		List<Reservation> reservations = reservationDao.getReservationByUserId(user.getUser_id());
		Map<Integer, Ticket> ticketMap = new HashMap<Integer, Ticket>();
		for (Reservation reservation : reservations) {
			Ticket ticket = ticketDao.getTicketById(reservation.getTicket_id());
			ticketMap.put(reservation.getTicket_id(), ticket);
		}
		model.addAttribute("reservations", reservations);
		model.addAttribute("ticketMap", ticketMap);
		return "profile";
	}
}
