package org.umlmda.test.combinedids.one2many.persistence.test;

import java.util.Set;

import javax.persistence.Query;

import org.umlmda.test.combinedids.one2many.persistence.impl.C2Impl;
import org.umlmda.test.combinedids.one2many.persistence.impl.D2Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class C2 extends AbstractTest{


	public C2(String name) {
		super(name);
	}

	public void testC2() throws Exception {
		try {
			Query q;
			C2Impl c2;
			D2Impl d2;
			
			
			// c2 mit "C2groupId1", "C2aId1" anlegen
			c2 = new C2Impl("C2groupId1", "C2aId1");
			em.persist(c2);
			c2 = em.find(C2Impl.class, new C2Impl.PKey("C2groupId1", "C2aId1"));
			assertNotNull(c2);

			// d2 mit Beziehung zu c2 anlegen
			d2 = new D2Impl("D2GroupId1", "D2bId1");
			d2.setA(c2);
			d2.setBAttr(Long.toString(System.currentTimeMillis()));
			em.persist(d2);

			//d2 mit Beziehung zu c2 anlegen
			d2 = new D2Impl("D2GroupId1", "D2bId2");
			d2.setA(c2);
			d2.setBAttr("zweite Zuordnung");
			em.persist(d2);

			//d2 ohne Beziehung zu c2 anlegen
			d2 = new D2Impl("D2GroupId2", "D2bId1");
			d2.setBAttr("nicht zugeordnet");
			em.persist(d2);
			
			em.flush();

			// Jetzt überprüfen ob c2 Beziehungen zu 2 d2 Datensätze besitzt
			em.refresh(c2);
			assertTrue(c2.getDs().size() == 2);
			
			em.flush();
			
			//Alle Beziehungen zu c2 auf null setzen
			removeParentRelation(c2.getDs());

			// c2 löschen, alle d2 sätze sollen bestehen bleiben (aggregation)
			em.remove(c2);
			
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

	private void removeParentRelation(Set<D2Impl> d2Set ){
		for (D2Impl impl : d2Set) {
			impl.setA(null);
		}
	}
}
