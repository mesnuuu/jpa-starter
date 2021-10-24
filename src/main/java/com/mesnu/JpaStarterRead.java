package com.mesnu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaStarterRead {
	
	public static void main(String[] args) {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");	
	EntityManager entityManager = entityManagerFactory.createEntityManager();	

	
	Employee emp = entityManager.find(Employee.class, 2);
	
	System.out.println("************* Fetched Employee");
	System.out.println(emp.getName());
	
	System.out.println("************* Accessed Card");
	System.out.println(emp.getCard());
	
	}
}
