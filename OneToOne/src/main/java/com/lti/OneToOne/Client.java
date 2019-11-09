package com.lti.OneToOne;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
	/*	Student student = new Student();
		student.setName("Deepak Patil");*/
		Address homeAddress = new Address();
		homeAddress.setStreet("MG Road2");
		homeAddress.setCity("Pune2");
		homeAddress.setState("Maharashtra2");
		homeAddress.setZipCode("411 01722");
		
		//inject address into student
		/*student.setAddress(homeAddress);*/
		
		//persist only student, no need to persist Address explicitly
		em.persist(homeAddress);
		em.getTransaction().commit();
		
		System.out.println("Added one student with address to database.");
		em.close();
		factory.close();
	}
}
