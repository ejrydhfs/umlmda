//Source file: D:\\devel\\umlmda\\UMLGenerator\\src\\org\\umlmda\\uml\\generator\\j2ee\\J2EEModelClass.java

package org.umlmda.uml.generator.j2ee;

import org.umlmda.uml.generator.java.JavaModelClass;

public interface J2EEModelClass extends JavaModelClass 
{
   /**
    * Build JNDI Name for a business service
    * @return
    */
   String getJndiName();
   
   /**
    * A service is stateful if the service or one of it's superclasses is marked stateful.
    */
   boolean isStateful();
}
