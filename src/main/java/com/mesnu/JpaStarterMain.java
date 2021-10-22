package com.mesnu;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterMain {
	
	public static void main(String[] args) {

		
		
		Employee employee1 = new Employee(
											2, 
											"sam", 
											"1234", 
											new Date(),
											EmployeeType.CONTRACTOR );
				
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
			
		entityManager.persist(employee1);

		transaction.commit();
	}

}
