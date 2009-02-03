package org.umlmda.test.combinedids.one2many.persistence.test;

import java.util.Set;

import javax.persistence.Query;

import org.umlmda.test.combinedids.one2many.persistence.impl.C2Impl;
import org.umlmda.test.combinedids.one2many.persistence.impl.C4Impl;
import org.umlmda.test.combinedids.one2many.persistence.impl.D2Impl;
import org.umlmda.test.combinedids.one2many.persistence.impl.D4Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class C4 extends AbstractTest{


	public C4(String name) {
		super(name);
	}

	public void testC4() throws Exception {
		try {
			Query q;
			C4Impl c4;
			D4Impl d4;
			
			
			// c2 mit "C2groupId1", "C2aId1" anlegen
			c4 = new C4Impl("C2groupId1", "C2aId1");
			em.persist(c4);
			c4 = em.find(C4Impl.class, new C4Impl.PKey("C2groupId1", "C2aId1"));
			assertNotNull(c4);

			// d2 mit Beziehung zu c2 anlegen
			d4 = new D4Impl("D2GroupId1", "D2bId1");
			d4.setA(c4);
			d4.setBAttr(Long.toString(System.currentTimeMillis()));
			em.persist(d4);

			//d2 mit Beziehung zu c2 anlegen
			d4 = new D4Impl("D2GroupId1", "D2bId2");
			d4.setA(c4);
			d4.setBAttr("zweite Zuordnung");
			em.persist(d4);

			//d2 ohne Beziehung zu c2 anlegen
			d4 = new D4Impl("D2GroupId2", "D2bId1");
			d4.setBAttr("nicht zugeordnet");
			em.persist(d4);
			
			em.flush();

			// Jetzt überprüfen ob c2 Beziehungen zu 2 d2 Datensätze besitzt
			em.refresh(c4);
			assertTrue(c4.getDs().size() == 2);
			
			em.flush();
			
			//Alle Beziehungen zu c2 auf null setzen
			removeParentRelation(c4.getDs());

			// c2 löschen, alle d2 sätze sollen bestehen bleiben (aggregation)
			em.remove(c4);
			
			em.flush();
			
			//Jetzt gibt es noch 3 d2 sätze und keinen c2 satz
			q = em.createQuery("SELECT d2 FROM D2Impl d2");
			assertTrue(q.getResultList().size()==3);
			
			q = em.createQuery("SELECT c2 FROM C2Impl c2");
			assertTrue(q.getResultList().size()==0);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);
		}

	}

	private void removeParentRelation(Set<D4Impl> d4Set ){
		for (D4Impl impl : d4Set) {
			impl.setA(null);
		}
	}
	
//	private void doNewTransaction(){
//		em.flush();
//		em.getTransaction().commit();
//		em.clear();
//		em.getTransaction().begin();
//	}
}
