package org.umlmda.test.combinedids.one2one.persistence.test;

import javax.persistence.Query;

import org.umlmda.test.combinedids.one2one.persistence.impl.A3Impl;
import org.umlmda.test.combinedids.one2one.persistence.impl.B3Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class A3Test extends AbstractTest{


	public A3Test(String name) {
		super(name);
	}

	private void doInserts(){
		A3Impl a3;
		B3Impl b3;
		
		
		// new a3 row
		a3 = new A3Impl("Group 1", "Id 1");
		em.persist(a3);
		a3 = em.find(A3Impl.class, new A3Impl.PKey("Group 1", "Id 1"));
		assertNotNull(a3);

		// new b3 row with relation to a3
		b3 = new B3Impl("Group 1", "Id 1");
		b3.setBAttr(Long.toString(System.currentTimeMillis()));
		em.persist(b3);
		a3.setB(b3);
		
		em.flush();

		//new b3 without any relation
		b3 = new B3Impl("Group 1", "Id 2");
		b3.setBAttr("no relation");
		em.persist(b3);
		
		em.flush();

		// check relation to b4
		em.refresh(a3);
		assertNotNull(a3.getB());
		
		em.flush();
	}
	
	private void doDeletes(){
		Query q;
		A3Impl a3;
		B3Impl b3;
		
		//remove a3 (delete cascade)
		a3 = em.find(A3Impl.class, new A3Impl.PKey("Group 1", "Id 1"));
		assertNotNull(a3);
		em.remove(a3);
		em.flush();
		
		//remove b3 id2
		b3 = em.find(B3Impl.class, new B3Impl.PKey("Group 1", "Id 2"));
		assertNotNull(b3);
		em.remove(b3);
		em.flush();
		
		//delete cascade
		q = em.createQuery("SELECT b3 FROM B3Impl b3");
		assertTrue(q.getResultList().size()==0);
		
		q = em.createQuery("SELECT a3 FROM A3Impl a3");
		assertTrue(q.getResultList().size()==0);
		
	}
	
	public void testA3() throws Exception {
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
