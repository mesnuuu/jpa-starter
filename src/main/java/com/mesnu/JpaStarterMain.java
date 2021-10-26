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
		
		emp1.addPayStub(payStub1);
		emp1.addPayStub(payStub2);
		
		EmailGroup group1 = new EmailGroup("Company Water cooler discussion");
		EmailGroup group2 = new EmailGroup("Engineering");

		group1.addMember(emp1);
		group1.addMember(emp2);
		emp1.addEmailSubscription(group1);
		emp2.addEmailSubscription(group1);
		
		group2.addMember(emp1);
		emp1.addEmailSubscription(group2);
		
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
		
		entityManager.persist(group1);
		entityManager.persist(group2);
							
		transaction.commit();
		


		
	}

}
