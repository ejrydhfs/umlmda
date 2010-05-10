package org.umlmda.uml.generator.j2ee;

import java.util.List;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.uml.generator.java.JavaModelPackage;

public interface J2EEModelPackage extends JavaModelPackage
{

   String getComponent();

   /**
    * Returns a list of transactiontypes (string) used in the business component
    */
   List getTransactionTypes();

   /**
    * Returns a list of methods for the given transaction type of the given model class
    * 
    * @param modelClass
    * @param transactionType
    */
   List getMethods(ModelClass modelClass, String transactionType);

}
