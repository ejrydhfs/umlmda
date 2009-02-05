package org.umlmda.test.combinedids.many2many.persistence.test;

import javax.persistence.Query;

import org.umlmda.test.combinedids.many2many.persistence.impl.E1Impl;
import org.umlmda.test.combinedids.many2many.persistence.impl.F1Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class E1Test extends AbstractTest{


	public E1Test(String name) {
		super(name);
	}

	private void doInserts(){
		Query q;
		E1Impl e1;
		E1Impl e1Second;
		F1Impl f1;
		F1Impl f1Second;
		
		
		// new e1
		e1 = new E1Impl("Group 1", "Id 1");
		em.persist(e1);

		// new e1
		e1Second = new E1Impl("Group 2", "Id 1");
		e1Second.setAAttr("a");
		em.persist(e1Second);

		// new f1
		f1 = new F1Impl("Group 3", "Id 1");
		f1.setBAttr(Long.toString(System.currentTimeMillis()));
		em.persist(f1);

		// new f2
		f1Second = new F1Impl("Group 4", "Id 1");
		f1Second.setBAttr(Long.toString(System.currentTimeMillis()));
		em.persist(f1Second);
		


		//do relations
		e1.getFs().add(f1);
		e1.getFs().add(f1Second);
		e1Second.getFs().add(f1);
		e1Second.getFs().add(f1Second);
		
		em.flush();
	}
	
	private void doDeletes(){
		Query q;
		E1Impl e1;
		F1Impl f1;
		
		//remove e1
		e1 = em.find(E1Impl.class, new E1Impl.PKey("Group 1", "Id 1"));
		assertNotNull(e1);
		e1.setFs(null);
		em.remove(e1);
		em.flush();
		
		//remove second e1
		e1 = em.find(E1Impl.class, new E1Impl.PKey("Group 2", "Id 1"));
		assertNotNull(e1);
		e1.setFs(null);
		em.remove(e1);
		em.flush();
		
		//remove f1
		f1 = em.find(F1Impl.class, new F1Impl.PKey("Group 3", "Id 1"));
		assertNotNull(f1);
		em.remove(f1);
		em.flush();
		
		//remove second f1
		f1 = em.find(F1Impl.class, new F1Impl.PKey("Group 4", "Id 1"));
		assertNotNull(f1);
		em.remove(f1);
		em.flush();
		
		//no delete cascade
		q = em.createQuery("SELECT e1 FROM E1Impl e1");
		assertTrue(q.getResultList().size()==0);
		
		q = em.createQuery("SELECT f1 FROM F1Impl f1");
		assertTrue(q.getResultList().size()==0);
	}
	
	public void testE1() throws Exception {
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
