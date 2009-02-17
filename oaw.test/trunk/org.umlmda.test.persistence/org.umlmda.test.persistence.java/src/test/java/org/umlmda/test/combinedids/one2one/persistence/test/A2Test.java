package org.umlmda.test.combinedids.one2one.persistence.test;

import javax.persistence.Query;

import org.umlmda.test.combinedids.one2one.persistence.impl.A2Impl;
import org.umlmda.test.combinedids.one2one.persistence.impl.B2Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class A2Test extends AbstractTest{


	public A2Test(String name) {
		super(name);
	}

	private void doInserts(){
		A2Impl a2;
		B2Impl b2;
		
		
		// new a2 row
		a2 = new A2Impl("Group 1", "Id 1");
		em.persist(a2);
		a2 = em.find(A2Impl.class, new A2Impl.PKey("Group 1", "Id 1"));
		assertNotNull(a2);

		// new b2 row with relation to a2
		b2 = new B2Impl("Group 1", "Id 2");
		b2.setA(a2);
		b2.setBAttr(Long.toString(System.currentTimeMillis()));
		em.persist(b2);
		
		em.flush();

		//new b2 without any relation
		b2 = new B2Impl("Group 2", "Id 3");
		b2.setBAttr("no relation");
		em.persist(b2);
		
		em.flush();

		// check relation to b2
		em.refresh(a2);
		assertNotNull(a2.getB());
		
		em.flush();
	}
	
	private void doDeletes(){
		Query q;
		A2Impl a2;
		
		//remove a2
		a2 = em.find(A2Impl.class, new A2Impl.PKey("Group 1", "Id 1"));
		assertNotNull(a2);
		a2.getB().setA(null);
		em.remove(a2);
		em.flush();
		
		//no delete cascade
		q = em.createQuery("SELECT b2 FROM B2Impl b2");
		assertTrue(q.getResultList().size()==2);
		
		//delete all b2
		for(Object o:q.getResultList()){
			em.remove((B2Impl) o);
		}
		em.flush();

		q = em.createQuery("SELECT a2 FROM A2Impl a2");
		assertTrue(q.getResultList().size()==0);
		
		
		
	}
	
	public void testA2() throws Exception {
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
