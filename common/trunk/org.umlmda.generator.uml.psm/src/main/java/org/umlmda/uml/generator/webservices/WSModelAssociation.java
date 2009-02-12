/*
 * Created on 13.12.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.uml.generator.java.JavaModelAssociation;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface WSModelAssociation extends JavaModelAssociation, WSModelStructuralFeature {
   
   ModelAssociation getPIMAssociation();
}
