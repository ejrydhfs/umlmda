/*
 * Created on 21.08.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package org.umlmda.uml.generator.j2ee;

import org.umlmda.uml.generator.java.AbstractInterfaceWriter;


/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public abstract class AbstractHomeInterfaceWriter extends AbstractJ2EEInterfaceWriter {

   public AbstractHomeInterfaceWriter() {
      super();
      setClassHelper(new AbstractInterfaceWriter.JavaClassHelper() {
         /* (non-Javadoc)
          * @see net.sourceforge.umlmda.generator.IClassHelper#getPackageName()
          */
         public String getPackageName() {
            return AbstractHomeInterfaceWriter.this.getPackageName();
         }
      });
   }

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.generator.IClassWriter#getClassName()
	 */
	public String getClassName() {
		return modelClass.getName() + "Home";
	}
	
   public String getBusinessClass() {
      return super.getClassName();
   }

   public String getBusinessInterface() {
      return modelClass.getName();
   }
}
