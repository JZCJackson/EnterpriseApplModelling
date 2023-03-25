package com.project.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.project.dao.TicketDao;
import com.project.entities.Ticket;

@Controller
public class TutorController {

	@Autowired
	private TicketDao ticketDao;

	@GetMapping("/tickets")
	public String ticketsPage(Model model) {
		List<Ticket> tickets = ticketDao.getAllTickets();
		model.addAttribute("tickets", tickets);
		return "tickets";
	}

	@GetMapping("/add-ticket")
	public String addTicketsPage() {
		return "add-ticket";
	}

	@PostMapping("/ticket")
	public RedirectView addTicket(@ModelAttribute("ticket") Ticket ticket, HttpServletRequest request) {
		ticketDao.addTicket(ticket);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/tickets");
		return redirectView;
	}

	@GetMapping("/book-ticket/{ticket_id}")
	public String bookTicketForm(@PathVariable("ticket_id") int ticket_id, Model model, HttpServletRequest request) {
		Ticket ticket = ticketDao.getTicketById(ticket_id);
		model.addAttribute("ticket", ticket);
		return "book-ticket";
	}

}
