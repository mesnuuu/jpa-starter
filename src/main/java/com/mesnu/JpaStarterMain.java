package com.mesnu;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterMain {
	
	public static void main(String[] args) {

		
		
		Employee emp1 = new Employee(1,"sam", "1234", new Date(), EmployeeType.CONTRACTOR );			
		Employee emp2 = new Employee(2, "john", "4567", new Date(), EmployeeType.FULL_TIME );
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");	
		EntityManager entityManager = entityManagerFactory.createEntityManager();	
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();	
		
		// CREATE
		entityManager.persist(emp1);
		entityManager.persist(emp2);
		System.out.println("Creating Emplyoees ");
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println("*******************");
		
		// READ
		Employee empR = entityManager.find(Employee.class, 1);
		System.out.println("Reading Emplyoee whose id=1");
		System.out.println(empR);
		System.out.println("*******************");
		
		// UPDATE
		Employee empU = entityManager.find(Employee.class, 2);
		System.out.println("Update Emplyoee whose id=2");
		empU.setName("John Smith");
		System.out.println(empU);
		System.out.println("*******************");
		
		// DELETE
		Employee empD = entityManager.find(Employee.class, 1);
		System.out.println("Delete Emplyoee whose id=1");
		entityManager.remove(empD);
		System.out.println("*******************");
		
//		List<Employee> employees= entityManager.createQuery("from EMPLOYEE_DATA").getResultList();
//		System.out.println(employees);
		
		AccessCard card1 = new AccessCard(new Date(), true, "1.0.0");		
		AccessCard card2 = new AccessCard(new Date(), false, "1.2.0");
		entityManager.persist(card1);
		entityManager.persist(card2);
		
		
		transaction.commit();
			

		
	}

}
