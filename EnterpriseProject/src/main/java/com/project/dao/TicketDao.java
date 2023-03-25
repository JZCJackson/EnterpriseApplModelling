package com.project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entities.Ticket;

@Repository
@Transactional
public class TicketDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Ticket> getAllTickets() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Ticket> tickets = session.createQuery("from Ticket").getResultList();
		return tickets;
	}

	public Ticket getTicketById(int ticket_id) {
		Session session = sessionFactory.getCurrentSession();
		Ticket ticket = session.get(Ticket.class, ticket_id);
		return ticket;
	}
	public int addTicket(Ticket ticket) {
		Session session = sessionFactory.getCurrentSession();
		session.save(ticket);
		return ticket.getTicket_id();
	}
}
