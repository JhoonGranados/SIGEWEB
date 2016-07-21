package br.com.owl.infraestrutura.fabricas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sige-persist");
	private EntityManager entityManager;
	
	public EntityManager getEntityManeger(){
		if (entityManager == null) {
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
}
