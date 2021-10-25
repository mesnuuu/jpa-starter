package com.mesnu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaStarterRead {
	
	public static void main(String[] args) {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");	
	EntityManager entityManager = entityManagerFactory.createEntityManager();	

	
//	AccessCard card = entityManager.find(AccessCard.class, 1);
//	System.out.println(card);
//	
//	Employee emp = entityManager.find(Employee.class, 31);
//	System.out.println(emp);
		
	// unable to fix defaul tostring call in this case
	
	PayStub payStub = entityManager.find(PayStub.class, 3);
	System.out.println(payStub.getEmployee().getCard());
	
	AccessCard card	= payStub.getEmployee().getCard() ;
	System.out.println(card);
	
	Employee emp = entityManager.find(Employee.class, 31);
	System.out.println(emp.getPayStub());

	
	}
}
