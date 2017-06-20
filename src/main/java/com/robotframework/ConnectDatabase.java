package com.robotframework;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectDatabase {
	
	public void initConnect(String usr, String pass, String url, String driverClass) {
		
	}

	public static void main(String[] args) {
		EntityManagerFactory devFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");

		EntityManager devManager = devFactory.createEntityManager();
		devManager.getTransaction().begin();

		Device device1 = new Device();
		Device device2 = new Device();

		device1.setDeviceName("QDAW3");
		device1.setPort(8080);
		
		device2.setDeviceName("QDAW4");
		device2.setPort(8181);
		
		devManager.persist(device1);
		devManager.flush();
		
		devManager.persist(device2);
		devManager.flush();
		
		devManager.getTransaction().commit();

		devManager.close();
		devFactory.close();
	}
}
