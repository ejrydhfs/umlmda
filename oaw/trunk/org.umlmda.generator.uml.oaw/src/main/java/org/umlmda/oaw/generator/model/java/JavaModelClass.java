package org.umlmda.oaw.generator.model.java;

import java.util.List;

import org.umlmda.uml.generator.java.JavaModelAssociation;
import org.umlmda.uml.generator.java.JavaModelAttribute;
import org.umlmda.uml.generator.java.JavaModelMethod;

public interface JavaModelClass extends org.umlmda.uml.generator.java.JavaModelClass {

   public List<JavaModelAttribute> getJavaAttributes();
   
   public List<JavaModelAttribute> getJavaConstants();
   
   public List<JavaModelAssociation> getJavaAssociations();
   
   public List<JavaModelMethod> getJavaMethods();
   
   public String getModelVersion();
}