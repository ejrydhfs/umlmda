package org.umlmda.test.combinedids.inheritance.persistence.test;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.I2;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.I21;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.I22;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.impl.I21Impl;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.impl.I22Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class I2TestSubClass extends AbstractTest{

	private static Logger log = Logger.getLogger(I2TestSubClass.class);

	public I2TestSubClass(String name) {
		super(name);
	}

	private void doInserts(){
		I21 i21 = new I21Impl("Group 1", "Id 21");
		I22 i22 = new I22Impl("Group 1", "Id 22");
		
		i21.setI1Attr("i1 attr");
		i21.setI2Attr("i2 attr");
		em.persist(i21);
		
		i22.setI1Attr("i1 attr");
		i22.setI3Attr("i3 attr");
		em.persist(i22);
		
		em.flush();

		Query q = em.createQuery("SELECT a FROM I2Impl a");
		assertTrue(q.getResultList().size()==2);
		for(I2 i2:(List<I2>)q.getResultList()){
			log.info("Group:"+i2.getGroupId()+" Id:"+i2.getIId()+" I1Attr:"+i2.getI1Attr());
			assertTrue(i2.getI1Attr().equals("i1 attr"));
		}
		
		q = em.createQuery("SELECT a FROM I21Impl a");
		assertTrue(q.getResultList().size()==1);
		
		q = em.createQuery("SELECT a FROM I22Impl a");
		assertTrue(q.getResultList().size()==1);
	}
	
	
	public void testI2Subclass() throws Exception {
		try {
			doInserts();
		} catch (Exception e) {
			e.printStackTrace();
			throw(e);
		}

	}

}
