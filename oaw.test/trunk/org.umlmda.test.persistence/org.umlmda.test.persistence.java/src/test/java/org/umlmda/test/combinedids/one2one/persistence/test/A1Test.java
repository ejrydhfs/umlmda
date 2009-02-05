package org.umlmda.test.combinedids.one2one.persistence.test;

import javax.persistence.Query;

import org.umlmda.test.combinedids.one2one.persistence.impl.A1Impl;
import org.umlmda.test.combinedids.one2one.persistence.impl.B1Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class A1Test extends AbstractTest{


	public A1Test(String name) {
		super(name);
	}

	private void doInserts(){
		Query q;
		A1Impl a1;
		B1Impl b1;
		
		
		// new a1 row
		a1 = new A1Impl("Group 1", "Id 1");
		em.persist(a1);
		a1 = em.find(A1Impl.class, new A1Impl.PKey("Group 1", "Id 1"));
		assertNotNull(a1);

		// new b1 row with relation to a1
		b1 = new B1Impl("Group 1", "Id 1");
		b1.setBAttr(Long.toString(System.currentTimeMillis()));
		em.persist(b1);
		a1.setB(b1);
		
		em.flush();

		//new b1 without any relation
		b1 = new B1Impl("Group 1", "Id 2");
		b1.setBAttr("no relation");
		em.persist(b1);
		
		em.flush();

		// check relation to b4
		em.refresh(a1);
		assertNotNull(a1.getB());
		
		em.flush();
	}
	
	private void doDeletes(){
		Query q;
		A1Impl a1;
		B1Impl b1;
		
		//remove a1
		a1 = em.find(A1Impl.class, new A1Impl.PKey("Group 1", "Id 1"));
		assertNotNull(a1);
		a1.setB(null);
		em.remove(a1);
		em.flush();
		
		//remove b4 id2
		b1 = em.find(B1Impl.class, new B1Impl.PKey("Group 1", "Id 2"));
		assertNotNull(b1);
		em.remove(b1);
		
		
		//no delete cascade
		q = em.createQuery("SELECT b1 FROM B1Impl b1");
		assertTrue(q.getResultList().size()==1);
		
		b1 = em.find(B1Impl.class, new B1Impl.PKey("Group 1", "Id 1"));
		em.remove(b1);
		
		q = em.createQuery("SELECT b1 FROM B1Impl b1");
		assertTrue(q.getResultList().size()==0);
		
		q = em.createQuery("SELECT a4 FROM A4Impl a4");
		assertTrue(q.getResultList().size()==0);
		
		
	}
	
	public void testA1() throws Exception {
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
