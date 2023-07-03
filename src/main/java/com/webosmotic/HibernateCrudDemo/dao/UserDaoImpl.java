package com.webosmotic.HibernateCrudDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.webosmotic.HibernateCrudDemo.config.HibernateConfig;
import com.webosmotic.HibernateCrudDemo.modal.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory factory = HibernateConfig.getFactory();

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		}

	}

	public User getUserById(String id) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		User user = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			user = session.get(User.class, id);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null)
				transaction.rollback();
		}

		return user;
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		List<User> users = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			session.createQuery("from User").list();
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null)
				transaction.rollback();
		}

		return users;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null)
				transaction.rollback();
		}

	}

	public void deleteByUserId(String id) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try {
			Session session = factory.openSession();
			transaction = session.beginTransaction();
			User user = session.get(User.class, id);
			session.delete(user);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null)
				transaction.rollback();
		}

	}

}
