package org.umlmda.test.combinedids.one2one.persistence.test;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.umlmda.test.combinedids.one2one.persistence.impl.A4Impl;
import org.umlmda.test.combinedids.one2one.persistence.impl.B4Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class A4Test extends AbstractTest{


	public A4Test(String name) {
		super(name);
	}

	private void doInserts(){
		A4Impl a4;
		B4Impl b4;
		
		
		// new a4 row
		a4 = new A4Impl("Group 1", "Id 1");

		// new b4 row with relation to a2
		b4 = new B4Impl("Group 1", "Id 2");
		b4.setA(a4);
		b4.setBAttr(Long.toString(System.currentTimeMillis()));
		a4.setB(b4);
		em.persist(a4);
		em.flush();
		em.persist(b4);
		
		em.flush();

		// check relation to b4
		em.refresh(a4);
		assertNotNull(a4.getB());
		
		em.flush();
	}
	
	private void doDeletes(){
		Query q;
		A4Impl a4;
		
		//remove a4 (delete cascade)
		a4 = em.find(A4Impl.class, new A4Impl.PKey("Group 1", "Id 1"));
		assertNotNull(a4);
		em.remove(a4);
		em.flush();
		
		//delete cascade
		q = em.createQuery("SELECT b4 FROM B4Impl b4");
		assertTrue(q.getResultList().size()==0);
		
		q = em.createQuery("SELECT a4 FROM A4Impl a4");
		assertTrue(q.getResultList().size()==0);
	}

	private void doNegativeTests(){
		
		//without parent
		B4Impl b4 = new B4Impl("Group 1","Id 2");
		try{
			em.persist(b4);
			assertTrue(false);
		}catch(PersistenceException e){
			//ok
		}finally{
			em.close();
			setUp();
		}
		
		//remove relation
		A4Impl a4 = new A4Impl("Group 1","Id 1");
		b4.setA(a4);
		a4.setB(b4);
		em.persist(a4);
		em.persist(b4);
		em.flush();
		a4.setB(null);
		b4.setA(null);
		try{
			em.flush();
			assertTrue(false);
		}catch (PersistenceException e) {
			//ok
		}finally{
			em.close();
			setUp();
		}
		
		
	}
	
	public void testA4() throws Exception {
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

}
