package com.mesnu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterMain {
	
	public static void main(String[] args) {
		System.out.println("ok");
		
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Foo");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		entityManager.persist(employee);
		
		transaction.commit();
	}

}
