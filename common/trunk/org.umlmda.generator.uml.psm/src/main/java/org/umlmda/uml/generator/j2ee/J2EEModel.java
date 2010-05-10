//Source file: D:\\devel\\umlmda\\UMLGenerator\\src\\org\\umlmda\\uml\\generator\\j2ee\\J2EEModel.java

package org.umlmda.uml.generator.j2ee;

import org.umlmda.uml.generator.java.JavaModel;

public interface J2EEModel extends JavaModel
{
   String getJNDIName();

   String getJNDIReplacementPattern();

   String getJNDIReplacement();

   /**
    * @return
    */
   String getJ2EESpec();
}
