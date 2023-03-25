package com.project.controllers;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.project.dao.ReservationDao;
import com.project.entities.Reservation;

@Controller
public class ReservationController {
	@Autowired
	private ReservationDao reservationDao;

	@PostMapping("/book-ticket")
	public RedirectView bookTicket(@ModelAttribute("reservation") Reservation reservation, HttpServletRequest request)
			throws ParseException {
		this.reservationDao.addReservation(reservation);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/profile");
		return redirectView;
	}
}
