package com.mesnu;

import java.util.Date;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterMain {
	
	public static void main(String[] args) {
	
		
		AccessCard card1 = new AccessCard(new Date(), true, "1.0.0");		
		AccessCard card2 = new AccessCard(new Date(), false, "1.2.0");
		
		Employee emp1 = new Employee(1,"sam", "1234", new Date(), EmployeeType.CONTRACTOR, card1 );			
		Employee emp2 = new Employee(2, "john", "4567", new Date(), EmployeeType.FULL_TIME, card2 );

		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");	
		EntityManager entityManager = entityManagerFactory.createEntityManager();	
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();			
		
		entityManager.persist(emp1);
		entityManager.persist(emp2);
		entityManager.persist(card1);
		entityManager.persist(card2);
							
		transaction.commit();
			

		
	}

}
