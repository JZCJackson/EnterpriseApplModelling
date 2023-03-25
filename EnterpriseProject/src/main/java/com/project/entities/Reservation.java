package com.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservation_id;
	private int user_id;
	private int ticket_id;
	private int num_of_passangers;
	private String departure_date;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int reservation_id, int user_id, int ticket_id, int num_of_passangers, String departure_date) {
		super();
		this.reservation_id = reservation_id;
		this.user_id = user_id;
		this.ticket_id = ticket_id;
		this.num_of_passangers = num_of_passangers;
		this.departure_date = departure_date;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public int getNum_of_passangers() {
		return num_of_passangers;
	}

	public void setNum_of_passangers(int num_of_passangers) {
		this.num_of_passangers = num_of_passangers;
	}

	public String getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}

}
