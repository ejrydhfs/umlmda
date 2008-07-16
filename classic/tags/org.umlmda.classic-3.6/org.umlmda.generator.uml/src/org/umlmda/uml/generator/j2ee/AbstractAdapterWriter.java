/*
 * Created on 21.08.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package org.umlmda.uml.generator.j2ee;

import org.umlmda.uml.generator.java.AbstractInterfaceWriter;
import org.umlmda.uml.generator.java.AbstractJavaClassWriter;
import org.umlmda.uml.generator.java.JavaMethodHelper;



/**
 * base class for client implementation which delegates to J2EE remote interface
 * 
 * @author vpussel
 */
public abstract class AbstractAdapterWriter extends AbstractJavaClassWriter {

   public AbstractAdapterWriter() {
      super();
      setClassHelper(new AbstractInterfaceWriter.JavaClassHelper() {
         /* (non-Javadoc)
          * @see net.sourceforge.umlmda.generator.IClassHelper#getPackageName()
          */
         public String getPackageName() {
            return AbstractAdapterWriter.this.getPackageName();
         }
      });
      setMethodHelper(new JavaMethodHelper(getClassHelper()));
   }

}
