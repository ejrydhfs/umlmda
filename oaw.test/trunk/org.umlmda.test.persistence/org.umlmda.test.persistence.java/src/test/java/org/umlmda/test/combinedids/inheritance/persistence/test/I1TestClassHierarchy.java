package org.umlmda.test.combinedids.inheritance.persistence.test;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.I1;
import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.I11;
import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.I12;
import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.impl.I11Impl;
import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.impl.I12Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class I1TestClassHierarchy extends AbstractTest{
	private static Logger log = Logger.getLogger(I1TestClassHierarchy.class);

	public I1TestClassHierarchy(String name) {
		super(name);
	}

	private void doInserts(){
		I11 i11 = new I11Impl("Group 1", "Id 11");
		I12 i12 = new I12Impl("Group 1", "Id 12");
		
		i11.setI1Attr("i1 attr");
		i11.setI2Attr("i2 attr");
		em.persist(i11);
		
		i12.setI1Attr("i1 attr");
		i12.setI3Attr("i3 attr");
		em.persist(i12);
		
		em.flush();
		Query q = em.createQuery("SELECT a FROM I1Impl a");
		assertTrue(q.getResultList().size()==2);
		for(I1 i2:(List<I1>)q.getResultList()){
			log.info("Group:"+i2.getGroupId()+" Id:"+i2.getIId()+" I1Attr:"+i2.getI1Attr());
			assertTrue(i2.getI1Attr().equals("i1 attr"));
		}
		
		q = em.createQuery("SELECT a FROM I11Impl a");
		assertTrue(q.getResultList().size()==1);
		
		q = em.createQuery("SELECT a FROM I12Impl a");
		assertTrue(q.getResultList().size()==1);
	}
	
	
	public void testI1Hierarchy() throws Exception {
		try {
			doInserts();
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);
		}

	}

}
