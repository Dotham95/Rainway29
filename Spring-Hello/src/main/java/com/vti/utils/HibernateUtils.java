package com.vti.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;

public class HibernateUtils {

	private final static SessionFactory FACTORY;

	static {
		// load file config
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		// add entity
		cfg.addAnnotatedClass(Account.class);
		cfg.addAnnotatedClass(Position.class);
		cfg.addAnnotatedClass(Department.class);

		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

		FACTORY = cfg.buildSessionFactory(registry);

	}

	public static SessionFactory getFactory() {
		return FACTORY;
	}

}