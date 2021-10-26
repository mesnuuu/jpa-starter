package com.mesnu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterUpdate {

	public static void main(String[] args) {
		
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");	
	EntityManager entityManager = entityManagerFactory.createEntityManager();	
	EntityTransaction transaction = entityManager.getTransaction();
	
	Employee employee = entityManager.find(Employee.class, 42);
	
	EmailGroup emailGroup = entityManager.find(EmailGroup.class, 6);
	emailGroup.addMember(employee);
	employee.addEmailSubscription(emailGroup);
		
	transaction.begin();			
	
	entityManager.persist(employee);
	entityManager.persist(emailGroup);
						
	transaction.commit();
	entityManager.close();
	entityManagerFactory.close();
	
	
	}
}
