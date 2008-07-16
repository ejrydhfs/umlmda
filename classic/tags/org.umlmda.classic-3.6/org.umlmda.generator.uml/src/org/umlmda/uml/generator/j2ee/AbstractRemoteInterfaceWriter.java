/*
 * Created on 21.08.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package org.umlmda.uml.generator.j2ee;

import org.umlmda.uml.generator.java.AbstractInterfaceWriter;
import org.umlmda.uml.generator.java.JavaMethodHelper;



/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public abstract class AbstractRemoteInterfaceWriter extends AbstractJ2EEInterfaceWriter {

   public AbstractRemoteInterfaceWriter() {
      super();
      setClassHelper(new AbstractInterfaceWriter.JavaClassHelper() {
         /* (non-Javadoc)
          * @see net.sourceforge.umlmda.generator.IClassHelper#getPackageName()
          */
         public String getPackageName() {
            return AbstractRemoteInterfaceWriter.this.getPackageName();
         }
      });
      setMethodHelper(new JavaMethodHelper(getClassHelper()) {
         protected String getPlatformExceptions() {
            return "RemoteException";
         }
      });
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassWriter#getClassName()
    */
   public String getClassName() {
      return modelClass.getName();
   }
   
   public String getBusinessInterface() {
      return super.getClassName();
   }
}
