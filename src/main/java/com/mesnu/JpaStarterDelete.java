package com.mesnu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterDelete {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		Employee employee = entityManager.find(Employee.class, 31);

		transaction.begin();

		entityManager.remove(employee);

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();

	}
}
