package org.umlmda.test.combinedids.inheritance.persistence.test;

import org.umlmda.test.combinedids.inheritance.concrete.persistence.I31;
import org.umlmda.test.combinedids.inheritance.concrete.persistence.I32;
import org.umlmda.test.combinedids.inheritance.concrete.persistence.impl.I31Impl;
import org.umlmda.test.combinedids.inheritance.concrete.persistence.impl.I32Impl;
import org.umlmda.test.combinedids.test.AbstractTest;

public class I3TestConcreteClass extends AbstractTest{


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
