// jUMLMDA, UMLModel-API
//
// $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelStructuralFeatureBase.java,v 1.4 2006/11/18 11:57:35 moroff Exp $
// $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelStructuralFeatureBase.java,v $
// $Revision: 1.4 $
//  $State: Exp $
//   $Name:  $
//   $Date: 2006/11/18 11:57:35 $
// $Locker:  $
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Library General Public
// License as published by the Free Software Foundation; either
// version 2 of the License, or (at your option) any later version.
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Library General Public License for more details.
//
// You should have received a copy of the GNU Library General Public
// License along with this library; if not, write to the
// Free Software Foundation, Inc., 59 Temple Place - Suite 330,
// Boston, MA  02111-1307, USA. The text of license can be also found
// at http://www.gnu.org/copyleft/lgpl.html
//
// Created on Apr 29, 2005
package org.umlmda.model.uml;

import org.umlmda.model.uml.attributes.Multiplicity;

/**
 * @author moroff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface ModelStructuralFeatureBase extends ModelElementBase {
   public static final String PROPERTY_DERIVED = "derived";
   public static final String PROPERTY_MULTIPLICITY = "multiplicity";
   public static final String PROPERTY_READ_ONLY = "readOnly";

   /**
    * Checks whether the feature is a derived (non persistent) attribute
    */
   public abstract boolean isDerived();
   
   /**
    * Checks whether the feature is read only (no setters generated)
    */
   public abstract boolean isReadOnly();
   
   /**
	 * @return true if model feature is optional
	 */
	public abstract boolean isOptional();

	/**
	 * Returns the class owning the feature
	 */
	public abstract ModelClassBase getOwningClassBase();
  
   /**
    * Returns the multiplicity of the feature
    * @return
    */
   public Multiplicity getMultiplicity();
}
