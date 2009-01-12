//Source file: D:\\devel\\umlmda\\UMLGenerator\\src\\org\\umlmda\\uml\\generator\\j2ee\\J2EEModelPackage.java

package org.umlmda.uml.generator.j2ee;

import java.util.List;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.uml.generator.java.JavaModelPackage;

public interface J2EEModelPackage extends JavaModelPackage {

   public String getComponent();

   /**
    * Returns a list of transactiontypes (string) used in the business component
    */
   public List getTransactionTypes();

   /**
    * Returns a list of methods for the given transaction type of the given model class
    * @param modelClass
    * @param transactionType
    */
   public List getMethods(ModelClass modelClass, String transactionType);

}
