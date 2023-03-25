package com.project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entities.Reservation;

@Repository
@Transactional
public class ReservationDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Reservation> getReservationByUserId(int user_id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Reservation r WHERE r.user_id = :user_id";
		List<Reservation> reservations = session.createQuery(hql, Reservation.class).setParameter("user_id", user_id)
				.getResultList();
		return reservations;
	}

	public void addReservation(Reservation reservation) {
		Session session = sessionFactory.getCurrentSession();
		session.save(reservation);
	}
}
