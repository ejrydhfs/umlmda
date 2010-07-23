package org.umlmda.runtime.model;

public interface ModeledElement
{

   /**
    * Returns the name of the element in the corresponding UML model
    */
   String getModelName();

   /**
    * Returns the version in the corresponding UML model
    */
   String getModelVersion();
}
