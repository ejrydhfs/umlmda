package org.umlmda.test.combinedids.one2many.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.umlmda.test.combinedids.one2many.persistence.C2;

public class Quicktest {

	
	public static void main(String[] args) throws Exception {
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q=em.createQuery("SELECT c2 FROM C2Impl c2");
		List<C2> liste = q.getResultList();
		
		em.getTransaction().rollback();
	}	
}
