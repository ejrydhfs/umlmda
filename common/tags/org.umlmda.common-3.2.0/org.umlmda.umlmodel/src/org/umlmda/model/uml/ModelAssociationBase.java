// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelAssociationBase.java,v 1.4 2006/10/29 10:44:11 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelAssociationBase.java,v $
// $Revision: 1.4 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/10/29 10:44:11 $
//   $Locker:  $
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Library General Public
//  License as published by the Free Software Foundation; either
//  version 2 of the License, or (at your option) any later version.
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Library General Public License for more details.
//
//  You should have received a copy of the GNU Library General Public
//  License along with this library; if not, write to the
//  Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//  Boston, MA  02111-1307, USA. The text of license can be also found
//  at http://www.gnu.org/copyleft/lgpl.html
//
//  Created on Nov 9, 2004
package org.umlmda.model.uml;

import java.util.List;

/**
 * interface for basic model association access
 * 
 * @author vpussel
 */
public interface ModelAssociationBase extends ModelStructuralFeatureBase {
   public static final String PROPERTY_NAVIGATABLE_TO_SOURCE = "navigatableToSource";
   public static final String PROPERTY_NAVIGATABLE_TO_TARGET = "navigatableToTarget";
   public static final String PROPERTY_COMPOSITION = "composition";
   public static final String PROPERTY_AGGREGATION = "aggregation";
   public static final String PROPERTY_REVERSE_BASE = "reverseBase";
   public static final String PROPERTY_TARGET_BASE = "targetBase";
   public static final String PROPERTY_SOURCE_BASE = "sourceBase";
   public static final String PROPERTY_QUALIFIER = "qualifier";

	/**
	 * @return the association source
	 */
   public abstract ModelClassBase getSourceBase();

	/**
	 * @return the association target
	 */
	public abstract ModelClassBase getTargetBase();

	/**
	 * @return the reverse association which connects the involved classes the other way round
	 * NOTE comparing the classes for identity may not produce the correct result
	 * when there is more than one association between classes. 
	 */
	public abstract ModelAssociationBase getReverseBase();

	/**
	 * @return true if assocation is an aggregation
	 */
	public abstract boolean isAggregation();

	/**
	 * @return true if assocation is a composition
	 */
   public abstract boolean isComposition();

	/**
	 * @return true if assocation has target cardinality > 1
	 */
   public abstract boolean isMultiple();

	/**
    * checks whether the target could be navigated through this association
    * @return
    */
   public abstract boolean isNavigatableToTarget();

	/**
    * checks whether the source could be navigated through this association
    * @return
    */
   public abstract boolean isNavigatableToSource();

   /**
    * Returns a list of attributes specifing the qualifiers of the
    * association.
    * @return
    */
   public List getQualifiers();
   
   /**
    * Flag, controlling that the target members are ordered in the collection
    */
   public abstract boolean isOrdered();

   /**
    * Flag, controlling the the target members are unique in the collection
    * @return
    */
   public abstract boolean isUnique();
}