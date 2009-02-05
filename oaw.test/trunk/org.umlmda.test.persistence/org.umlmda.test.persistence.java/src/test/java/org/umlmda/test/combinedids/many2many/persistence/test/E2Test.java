package org.umlmda.test.combinedids.many2many.persistence.test;

import javax.persistence.Query;

import org.umlmda.test.combinedids.many2many.persistence.impl.E2Impl;
import org.umlmda.test.combinedids.many2many.persistence.impl.F2Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class E2Test extends AbstractTest{


	public E2Test(String name) {
		super(name);
	}

	private void doInserts(){
		E2Impl e2First;
		E2Impl e2Second;
		F2Impl f2First;
		F2Impl f2Second;
		
		
		// new e2
		e2First = new E2Impl("Group 1", "Id 1");
		em.persist(e2First);

		// new e2
		e2Second = new E2Impl("Group 2", "Id 1");
		e2Second.setAAttr("a");
		em.persist(e2Second);

		// new f2
		f2First = new F2Impl("Group 3", "Id 1");
		f2First.setBAttr(Long.toString(System.currentTimeMillis()));
		em.persist(f2First);

		// new f2
		f2Second = new F2Impl("Group 4", "Id 1");
		f2Second.setBAttr(Long.toString(System.currentTimeMillis()));
		em.persist(f2Second);
		
		//do relations
		f2First.getEs().add(e2First);
		f2First.getEs().add(e2Second);
		f2Second.getEs().add(e2First);
		f2Second.getEs().add(e2Second);
		em.flush();
		
		// check relations
		em.refresh(e2First);
		em.refresh(e2Second);
		assertTrue(e2First.getFs().size()==2);
		assertTrue(e2Second.getFs().size()==2);
		
		em.flush();
	}
	
	private void doDeletes(){
		Query q;
		E2Impl e2;
		F2Impl f2;
		
		//remove both f2's
		f2 = em.find(F2Impl.class, new F2Impl.PKey("Group 3", "Id 1"));
		assertNotNull(f2);
		for(Object o:f2.getEs()){
			((E2Impl)o).getFs().remove(f2);
		}
		f2.getEs().clear();
		em.remove(f2);
		em.flush();
		
		f2 = em.find(F2Impl.class, new F2Impl.PKey("Group 4", "Id 1"));
		assertNotNull(f2);
		for(Object o:f2.getEs()){
			((E2Impl)o).getFs().remove(f2);
		}
		f2.getEs().clear();
		em.remove(f2);
		em.flush();
		
		//no delete cascade
		q = em.createQuery("SELECT e2 FROM E2Impl e2");
		assertTrue(q.getResultList().size()==2);
		
		//remove both e2's
		e2 = em.find(E2Impl.class, new E2Impl.PKey("Group 1", "Id 1"));
		assertNotNull(e2);
		e2.getFs().clear();
		em.remove(e2);
		em.flush();
		
		e2 = em.find(E2Impl.class, new E2Impl.PKey("Group 2", "Id 1"));
		assertNotNull(e2);
		e2.getFs().clear();
		em.remove(e2);
		em.flush();

		//no delete cascade
		q = em.createQuery("SELECT e2 FROM E2Impl e2");
		assertTrue(q.getResultList().size()==0);

		q = em.createQuery("SELECT f2 FROM F2Impl f2");
		assertTrue(q.getResultList().size()==0);
	}
	
	public void testE2() throws Exception {
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
