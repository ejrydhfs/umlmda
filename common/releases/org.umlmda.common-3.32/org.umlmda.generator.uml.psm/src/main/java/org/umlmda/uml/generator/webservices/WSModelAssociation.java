/*
 * Created on 13.12.2005
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.uml.generator.java.JavaModelAssociation;

/**
 * @author MOROFF
 */
public interface WSModelAssociation extends JavaModelAssociation, WSModelStructuralFeature
{

   ModelAssociation getPIMAssociation();
}
