package com.robotframework;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectDatabase {
	
	public String initConnect(String usr, String pass, String persistenceUnit) {
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.user", usr);
		properties.put("javax.persistence.jdbc.password", pass);
		properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		try {
			EntityManagerFactory devFactory = Persistence.createEntityManagerFactory(persistenceUnit, properties);
			EntityManager devManager = devFactory.createEntityManager();
			devManager.getTransaction().begin();
			return "Connected";
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
	public static void main(String[] args) {
		
		new ConnectDatabase().initConnect("root", "admin", "Hibernate_JPA");
		
	}
}
