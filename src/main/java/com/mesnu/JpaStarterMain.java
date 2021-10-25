package com.mesnu;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterMain {
	
	public static void main(String[] args) {
	
		
		AccessCard card1 = new AccessCard(new Date(), true, "1.0.0");		
		AccessCard card2 = new AccessCard(new Date(), false, "1.2.0");
		
		Employee emp1 = new Employee(31,"sam", "1234", new Date(), EmployeeType.CONTRACTOR, card1 );			
		Employee emp2 = new Employee(42, "john", "4567", new Date(), EmployeeType.FULL_TIME, card2 );

		card1.setOwner(emp1);
		emp1.setCard(card1);
		card2.setOwner(emp2);
		emp2.setCard(card2);
		
		PayStub payStub1 = new PayStub(new Date(), new Date(), 1000, emp1);
		PayStub payStub2 = new PayStub(new Date(), new Date(), 5530, emp1);
		
		emp1.setPayStub(List.of(payStub1, payStub2));
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");	
		EntityManager entityManager = entityManagerFactory.createEntityManager();	
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();			
		
		entityManager.persist(emp1);
		entityManager.persist(emp2);
		
		entityManager.persist(card1);
		entityManager.persist(card2);
		
		entityManager.persist(payStub1);
		entityManager.persist(payStub2);
							
		transaction.commit();
		


		
	}

}
