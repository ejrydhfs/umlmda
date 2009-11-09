//Source file: D:\\devel\\umlmda\\UMLGenerator\\src\\org\\umlmda\\uml\\generator\\java\\JavaModel.java

package org.umlmda.uml.generator.java;

import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.model.uml.Model;

public interface JavaModel extends Model, GeneratorModel 
{
   /**
    * Flag Spring Framework is used for dependency injection 
    * @author Dieter Moroff (20.03.2006), last change $Date$ $Name$
    * @version $Revision$
    */
   boolean isSpringSupported();
   
   final static String PROPERTY_SPRING_SUPPORT = "SpringSupport";
   final static String PROPERTY_SPRING_SUPPORT_DEFAULT = "false";
   
}
