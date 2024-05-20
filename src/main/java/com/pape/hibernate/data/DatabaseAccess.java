package com.pape.hibernate.data;

import com.pape.hibernate.entity.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class DatabaseAccess {

	protected SessionFactory factory;
	
	public void createFactory() {
		final StandardServiceRegistry register = new StandardServiceRegistryBuilder().configure().build();
		
		try {
			factory = new MetadataSources(register).buildMetadata().buildSessionFactory();
			System.out.println("Factory created.");
		} catch (Exception e) {
			 	System.out.println("Factory couldn't be created.");
		}
	}
	
	public void disposeFactory() {
		if(factory == null)
			return;
		
		factory.close();
		System.out.println("Factory disposed.");
	}
	
	/* [C]RUD */
	
	public void createUser(String username, String password) {
		User user = new User(username, password);
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		System.out.println("New User " + username + " added.");
		session.close();
	}
	
	public void createUser(User instance) {
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(instance);
		session.getTransaction().commit();
		
		System.out.println("New User " + instance.getName() + " added.");
		session.close();
	}
	
}