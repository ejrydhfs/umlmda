/*
 * Created on 21.08.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package org.umlmda.uml.generator.j2ee;



/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public abstract class AbstractLocalHomeInterfaceWriter extends AbstractHomeInterfaceWriter {

   public AbstractLocalHomeInterfaceWriter() {
      super();
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassWriter#getClassName()
    */
   public String getClassName() {
      return modelClass.getName() + "LocalHome";
   }
   

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.uml.generator.j2ee.AbstractHomeInterfaceWriter#getBusinessInterface()
	 */
	public String getBusinessInterface() {
		return super.getBusinessInterface() + "Local";
	}
}
