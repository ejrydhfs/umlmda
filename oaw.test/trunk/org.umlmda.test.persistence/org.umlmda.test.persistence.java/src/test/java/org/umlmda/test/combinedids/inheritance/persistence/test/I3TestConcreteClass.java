package org.umlmda.test.combinedids.inheritance.persistence.test;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.umlmda.test.combinedids.inheritance.concrete.persistence.I3;
import org.umlmda.test.combinedids.inheritance.concrete.persistence.I31;
import org.umlmda.test.combinedids.inheritance.concrete.persistence.I32;
import org.umlmda.test.combinedids.inheritance.concrete.persistence.impl.I31Impl;
import org.umlmda.test.combinedids.inheritance.concrete.persistence.impl.I32Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class I3TestConcreteClass extends AbstractTest{
	private static Logger log = Logger.getLogger(I3TestConcreteClass.class);

	public I3TestConcreteClass(String name) {
		super(name);
	}

	private void doInserts(){
		I31 i31 = new I31Impl("Group 1", "Id 31");
		I32 i32 = new I32Impl("Group 1", "Id 32");
		
		i31.setI1Attr("i1 attr");
		i31.setI2Attr("i2 attr");
		em.persist(i31);
		
		i32.setI1Attr("i1 attr");
		i32.setI3Attr("i3 attr");
		em.persist(i32);
		
		em.flush();
		
		Query q = em.createQuery("SELECT a FROM I3Impl a");
		assertTrue(q.getResultList().size()==2);
		for(I3 i3:(List<I3>)q.getResultList()){
			log.info("Group:"+i3.getGroupId()+" Id:"+i3.getIId()+" I1Attr:"+i3.getI1Attr());
			assertTrue(i3.getI1Attr().equals("i1 attr"));
		}
		
		q = em.createQuery("SELECT a FROM I31Impl a");
		assertTrue(q.getResultList().size()==1);
		
		q = em.createQuery("SELECT a FROM I32Impl a");
		assertTrue(q.getResultList().size()==1);
		
	}
	
	
	public void testI3Concrete() throws Exception {
		try {
			doInserts();
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);
		}

	}

}
