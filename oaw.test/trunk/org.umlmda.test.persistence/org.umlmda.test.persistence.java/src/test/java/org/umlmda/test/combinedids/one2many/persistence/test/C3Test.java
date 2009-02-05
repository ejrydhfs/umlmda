package org.umlmda.test.combinedids.one2many.persistence.test;

import javax.persistence.Query;

import org.umlmda.test.combinedids.one2many.persistence.impl.C3Impl;
import org.umlmda.test.combinedids.one2many.persistence.impl.D3Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class C3Test extends AbstractTest{


	public C3Test(String name) {
		super(name);
	}

	private void doInserts(){
		C3Impl c3;
		D3Impl d3;
		
		// insert new c3 object with "C3groupId1", "C3aId1"
		c3 = new C3Impl("C3groupId1", "C3aId1");
		em.persist(c3);
		c3 = em.find(C3Impl.class, new C3Impl.PKey("C3groupId1", "C3aId1"));
		assertNotNull(c3);

		// insert new d3 object with relation to c3
		d3 = new D3Impl("D3GroupId1", "D3bId1");
		
		d3.setBAttr(Long.toString(System.currentTimeMillis()));
		em.persist(d3);
		c3.getDs().add(d3);

		// insert new d3 object with relation to c3
		d3 = new D3Impl("D3GroupId1", "D3bId2");
		d3.setBAttr("zweite Zuordnung");
		em.persist(d3);
		c3.getDs().add(d3);

		em.flush();
		// insert new d3 object with relation to c3
		d3 = new D3Impl("D3GroupId2", "D3bId1");
		d3.setBAttr("3rd relation");
		em.persist(d3);
		c3.getDs().add(d3);
		
		//should be ok
		em.flush();
		
		// check if c3 has three childs 
		em.refresh(c3);
		assertTrue(c3.getDs().size() == 3);
		
		em.flush();
		
	}
	
	private void doDeletes(){
		C3Impl c3;
		Query q;
		
		c3 = em.find(C3Impl.class, new C3Impl.PKey("C3groupId1", "C3aId1"));
		assertNotNull(c3);
		
		// remove c3 (composition)
		em.remove(c3);
		
		em.flush();
		
		//there shouldn't be any rows anymore (delete cascade)
		q = em.createQuery("SELECT d3 FROM D3Impl d3");
		assertTrue(q.getResultList().size()==0);
		
		q = em.createQuery("SELECT c3 FROM C3Impl c3");
		assertTrue(q.getResultList().size()==0);
		
		em.flush();
	}

	public void testC3() throws Exception {
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
