package org.umlmda.test.combinedids.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;

public abstract class AbstractTest extends TestCase {

	protected EntityManager em;
	
	public AbstractTest(String name){
		super(name);
	}

	protected void setUp() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		assertFalse(em.getTransaction().getRollbackOnly());
	}

	protected void tearDown() {
		em.getTransaction().commit();
	}
	
}
