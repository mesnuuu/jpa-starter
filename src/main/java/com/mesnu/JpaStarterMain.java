package com.mesnu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterMain {
	
	public static void main(String[] args) {

		
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		Employee employee3 = new Employee();
		
		employee1.setId(1);
		employee1.setName("Foo");
		employee2.setId(2);
		employee2.setName("Barr");
		employee3.setId(3);
		employee3.setName("Tim");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.persist(employee3);
		
		transaction.commit();
	}

}
