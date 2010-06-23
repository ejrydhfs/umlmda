package org.umlmda.oaw.generator.model.webservice;

import java.util.List;

import org.umlmda.uml.generator.webservices.WSModelAssociation;
import org.umlmda.uml.generator.webservices.WSModelMethod;

public interface WSModelClass extends org.umlmda.uml.generator.webservices.WSModelClass
{

   List<WSModelAttribute> getJavaAttributes();

   List<WSModelAttribute> getJavaConstants();

   List<WSModelAssociation> getJavaAssociations();

   List<WSModelMethod> getJavaMethods();

   String getModelVersion();
}