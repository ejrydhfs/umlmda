package org.umlmda.test.combinedids.one2many.persistence.test;

import javax.persistence.Query;

import org.umlmda.test.combinedids.one2many.persistence.impl.C4Impl;
import org.umlmda.test.combinedids.one2many.persistence.impl.D4Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class C4Test extends AbstractTest{


	public C4Test(String name) {
		super(name);
	}

	private void doInserts(){
		C4Impl c4;
		D4Impl d4;
		
		
		// new C4
		c4 = new C4Impl("C4groupId1", "C4aId1");
		em.persist(c4);
		c4 = em.find(C4Impl.class, new C4Impl.PKey("C4groupId1", "C4aId1"));
		assertNotNull(c4);

		// D4 with relatin to C4
		d4 = new D4Impl("D4GroupId1", "D4bId1");
		d4.setA(c4);
		d4.setBAttr(Long.toString(System.currentTimeMillis()));
		em.persist(d4);

		// D4 with relatin to C4
		d4 = new D4Impl("D4GroupId1", "D4bId2");
		d4.setA(c4);
		d4.setBAttr("zweite Zuordnung");
		em.persist(d4);

		em.flush();

		// D4 without relation
		d4 = new D4Impl("D4GroupId2", "D4bId1");
		d4.setBAttr("nicht zugeordnet");

		em.persist(c4);
		// check relations
		em.refresh(c4);
		assertTrue(c4.getDs().size() == 2);
		
		em.flush();		
	}
	
	private void doDeletes(){
		Query q;
		C4Impl c4;
		
		
		// delete C2 (delete cascade)
		c4 = em.find(C4Impl.class, new C4Impl.PKey("C4groupId1", "C4aId1"));
		assertNotNull(c4);
		em.remove(c4);
		
		em.flush();
		
		//check
		q = em.createQuery("SELECT d4 FROM D4Impl d4");
		assertTrue(q.getResultList().size()==0);
		
		q = em.createQuery("SELECT c4 FROM C4Impl c4");
		assertTrue(q.getResultList().size()==0);
	}
	
	private void doNoRelationTest(){
		D4Impl d4 = new D4Impl("a","b");
		
		try{
			em.persist(d4);
			assertTrue(false);
		}catch(Exception e){
			//ok
		}finally{
			em.close();
			setUp();
		}
	}
	
	public void testC4() throws Exception {
		try {
			doNoRelationTest();
			doInserts();
			doDeletes();
			doInserts();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);
		}

	}
}
