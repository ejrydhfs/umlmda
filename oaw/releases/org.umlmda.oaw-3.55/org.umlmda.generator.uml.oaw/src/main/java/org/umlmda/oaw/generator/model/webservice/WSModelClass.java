package org.umlmda.oaw.generator.model.webservice;

import java.util.List;

import org.umlmda.uml.generator.webservices.WSModelAssociation;
import org.umlmda.uml.generator.webservices.WSModelMethod;

public interface WSModelClass extends org.umlmda.uml.generator.webservices.WSModelClass {

   public List<WSModelAttribute> getJavaAttributes();
   
   public List<WSModelAttribute> getJavaConstants();
   
   public List<WSModelAssociation> getJavaAssociations();
   
   public List<WSModelMethod> getJavaMethods();
   
   public String getModelVersion();
}