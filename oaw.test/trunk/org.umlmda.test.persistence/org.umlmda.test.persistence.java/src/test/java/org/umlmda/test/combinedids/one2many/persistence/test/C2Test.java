package org.umlmda.test.combinedids.one2many.persistence.test;

import java.util.Set;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.umlmda.test.combinedids.one2many.persistence.C2;
import org.umlmda.test.combinedids.one2many.persistence.D2;
import org.umlmda.test.combinedids.one2many.persistence.impl.C2Impl;
import org.umlmda.test.combinedids.one2many.persistence.impl.D2Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class C2Test extends AbstractTest{
	private static Logger log = Logger.getLogger(C2Test.class);

	public C2Test(String name) {
		super(name);
	}

	private void doInserts(){
		C2Impl c2;
		D2Impl d2;
		
		
		// c2 mit "C2groupId1", "C2aId1" anlegen
		c2 = new C2Impl("Group 1", "Id 1");
		em.persist(c2);
		c2 = em.find(C2Impl.class, new C2Impl.PKey("Group 1", "Id 1"));
		assertNotNull(c2);

		// d2 mit Beziehung zu c2 anlegen
		d2 = new D2Impl();
		c2.getDs().add(d2);
		d2.setA(c2);
		d2.setBAttr(Long.toString(System.currentTimeMillis()));
		d2.setD2Pkey(new D2Impl.PKey("Group 1", "Id 2"));
		em.persist(d2);
		em.persist(c2);

		//d2 mit Beziehung zu c2 anlegen
		d2 = new D2Impl("Group 1", "Id 3");
		d2.setA(c2);
		d2.setBAttr("zweite Zuordnung");
		em.persist(d2);
		c2.getDs().add(d2);
		em.persist(c2);

		//d2 ohne Beziehung zu c2 anlegen
		d2 = new D2Impl("Group 2", "Id 4");
		d2.setBAttr("nicht zugeordnet");
		em.persist(d2);
		
		em.flush();

		// Jetzt überprüfen ob c2 Beziehungen zu 2 d2 Datensätze besitzt
		em.refresh(c2);
		assertTrue(c2.getDs().size() == 2);
		
		// PK erst am ende zuweisen
		c2 = new C2Impl();
		d2 = new D2Impl();
		
		c2.getDs().add(d2);
		d2.setA(c2);
		
		d2.setD2Pkey(new D2Impl.PKey("Group 3", "Id 2"));
		c2.setC2Pkey(new C2Impl.PKey("Group 3", "Id 1"));

		em.persist(c2);
		em.persist(d2);
		em.flush();
		
		// Jetzt überprüfen ob c2 Beziehungen zu 2 d2 Datensätze besitzt
		em.refresh(c2);
		assertTrue(c2.getDs().size() == 1);
		
		em.flush();
		
		Query q = em.createQuery("SELECT d2 FROM D2Impl d2 WHERE d2.aId=:id").setParameter("id", "Id 1");
		for(Object o:q.getResultList()){
			log.info("Group ID: "+((D2Impl)o).getGroupId());
		}
		assertTrue(q.getResultList().size()==3);
		em.flush();
	}
	
	private void doDeletes(){
		Query q;
		C2Impl c2First;
		C2Impl c2Second;
		
		//Alle Beziehungen zu c2 auf null setzen
		c2First = em.find(C2Impl.class, new C2Impl.PKey("Group 1", "Id 1"));
		c2Second = em.find(C2Impl.class, new C2Impl.PKey("Group 3", "Id 1"));
		assertNotNull(c2First);
		assertNotNull(c2Second);
		
		removeChildRelation(c2First.getDs());
		removeChildRelation(c2Second.getDs());

		c2First.getDs().clear();
		c2Second.getDs().clear();
		
		// c2 löschen, alle d2 sätze sollen bestehen bleiben (aggregation)

		em.remove(c2First);
		em.remove(c2Second);
		em.flush();
		
		//Jetzt gibt es noch 3 d2 sätze und keinen c2 satz
		q = em.createQuery("SELECT d2 FROM D2Impl d2");
		assertTrue(q.getResultList().size()==4);
		
		//alle verbliebenen löschen
		for(Object o:q.getResultList()){
			em.remove((D2Impl) o);
		}
		em.flush();

		q = em.createQuery("SELECT c2 FROM C2Impl c2");
		assertTrue(q.getResultList().size()==0);
	}

	private void doNegativeTests() {
		C2 c2 = new C2Impl("Group 888","Id 1");
		D2 d2 = new D2Impl("Group 999", "Id 2");
		
		c2.getDs().add(d2);
		try{
			d2.setA(c2);
			em.persist(c2);
			em.persist(d2);
			assertTrue(false);
		}catch (RuntimeException e) {
			//ok
			log.info(e.getMessage());
			assertTrue(e.getMessage().equals("java.lang.AssertionError: different groupId"));
		}
		
		em.clear();
		em.close();
		setUp();
		
		
	}
	
	public void testC2() throws Exception {
		try {
			doNegativeTests();
			doInserts();
			doDeletes();
			doInserts();
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);
		}

	}


	private void removeChildRelation(Set<D2> d2Set ){
		for (D2 d2 : d2Set) {
			d2.setA(null);
		}
	}
}
