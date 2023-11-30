package com.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.bean.Employee;

public class EmployeeDao {
	public static int registerEmp(Employee e) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		int i = (int)session.save(e);
		session.getTransaction().commit();
		session.close();
		factory.close();
		return i;
	}
}
