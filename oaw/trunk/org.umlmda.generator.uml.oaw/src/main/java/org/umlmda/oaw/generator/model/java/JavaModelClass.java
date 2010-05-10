package org.umlmda.oaw.generator.model.java;

import java.util.List;

import org.umlmda.uml.generator.java.JavaModelAssociation;
import org.umlmda.uml.generator.java.JavaModelAttribute;
import org.umlmda.uml.generator.java.JavaModelMethod;

public interface JavaModelClass extends org.umlmda.uml.generator.java.JavaModelClass
{

   List<JavaModelAttribute> getJavaAttributes();

   List<JavaModelAttribute> getJavaConstants();

   List<JavaModelAssociation> getJavaAssociations();

   List<JavaModelMethod> getJavaMethods();

   String getModelVersion();
}