package com.project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entities.User;

@Repository
@Transactional
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public User getUserById(int user_id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, user_id);
		return user;
	}

	public User getUserByEmailAndPassword(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User WHERE email = :email AND password = :password";
		List<User> users = session.createQuery(hql, User.class).setParameter("email", email)
				.setParameter("password", password).getResultList();
		if (!users.isEmpty()) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);
	}
}