package com.webosmotic.HibernateCrudDemo.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.webosmotic.HibernateCrudDemo.modal.User;

public class HibernateConfig {

	private static SessionFactory factory;

	private HibernateConfig() {}

	public static SessionFactory getFactory() {

		if (factory == null) {

			Configuration configuration = new Configuration();

			Properties prop = new Properties();
			prop.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			prop.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatedb");
			prop.put(Environment.USER, "root");
			prop.put(Environment.PASS, "root");

			prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			prop.put(Environment.SHOW_SQL, "true");
			prop.put(Environment.HBM2DDL_AUTO, "update");

			configuration.setProperties(prop);
			configuration.addAnnotatedClass(User.class);

			StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder();
			StandardServiceRegistry build = serviceRegistry.applySettings(configuration.getProperties()).build();

			factory = configuration.buildSessionFactory(build);

		}

		return factory;

	}

}
