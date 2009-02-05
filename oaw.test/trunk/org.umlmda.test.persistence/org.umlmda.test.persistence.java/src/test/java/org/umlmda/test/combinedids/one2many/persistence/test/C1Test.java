package org.umlmda.test.combinedids.one2many.persistence.test;

import javax.persistence.Query;

import org.umlmda.test.combinedids.one2many.persistence.impl.C1Impl;
import org.umlmda.test.combinedids.one2many.persistence.impl.D1Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class C1Test extends AbstractTest{


	public C1Test(String name) {
		super(name);
	}
	
	private void doInserts(){
		C1Impl c1;
		D1Impl d1;
		
		
		// insert new c1 object with "C1groupId1", "C1aId1"
		c1 = new C1Impl("C1groupId1", "C1aId1");
		em.persist(c1);
		c1 = em.find(C1Impl.class, new C1Impl.PKey("C1groupId1", "C1aId1"));
		assertNotNull(c1);

		// insert new d1 object with relation to c1
		d1 = new D1Impl("D1GroupId1", "D1bId1");
		d1.setBAttr(Long.toString(System.currentTimeMillis()));
		em.persist(d1);
		c1.getDs().add(d1);

		// insert new d1 object with relation to c1
		d1 = new D1Impl("D1GroupId1", "D1bId2");
		d1.setBAttr("2nd relation");
		em.persist(d1);
		c1.getDs().add(d1);

		em.flush();
		// insert new d1 object with relation to c1
		d1 = new D1Impl("D1GroupId2", "D1bId1");
		d1.setBAttr("3rd relation");
		em.persist(d1);
		c1.getDs().add(d1);
		
		//should be ok
		em.flush();
		
		// check if c1 has three childs 
		em.refresh(c1);
		assertTrue(c1.getDs().size() == 3);
		
		em.flush();
	}

	private void doDeletes(){
		Query q;
		C1Impl c1;
		
		// remove c1 (composition)
		c1 = em.find(C1Impl.class, new C1Impl.PKey("C1groupId1", "C1aId1"));
		assertNotNull(c1);
		em.remove(c1);

		//no delete cascade
		q = em.createQuery("SELECT d1 FROM D1Impl d1");
		assertTrue(q.getResultList().size()==3);
		
		for(Object o:q.getResultList()){
			em.remove((D1Impl) o);
		}
		
		em.flush();
		
		q = em.createQuery("SELECT c1 FROM C1Impl c1");
		assertTrue(q.getResultList().size()==0);
	}
	public void testC1() throws Exception {
		try {
			doInserts();
			doDeletes();
			doInserts();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);
		}

	}
}
