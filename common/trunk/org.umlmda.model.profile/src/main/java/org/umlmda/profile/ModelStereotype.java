// jUMLMDA, UMLModel-API
//
//$Header:
// /cvsroot/umlmda/UMLMDAProfile/src/org/umlmda/profile/ModelStereotype.java,v
// 1.3 2005/10/27 19:14:35 moroff Exp $
//$Source:
// /cvsroot/umlmda/UMLMDAProfile/src/org/umlmda/profile/ModelStereotype.java,v $
//$Revision: 1.8 $
// $State: Exp $
//  $Name:  $
//  $Date: 2007/07/31 12:52:35 $
//$Locker:  $
//
//This library is free software; you can redistribute it and/or
//modify it under the terms of the GNU Library General Public
//License as published by the Free Software Foundation; either
//version 2 of the License, or (at your option) any later version.
//This library is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//Library General Public License for more details.
//
//You should have received a copy of the GNU Library General Public
//License along with this library; if not, write to the
//Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//Boston, MA 02111-1307, USA. The text of license can be also found
//at http://www.gnu.org/copyleft/lgpl.html
//
//Created on Jun 14, 2005
package org.umlmda.profile;

public interface ModelStereotype {

   public static final String BUSINESS_COMPONENT = "BusinessComponent";
   public static final String BUSINESS_EXCEPTION = "BusinessException";
   public static final String BUSINESS_OBJECT = "BusinessObject";
   public static final String BUSINESS_SERVICE = "BusinessService";
   public static final String PERSISTENCE_SERVICE = "PersistenceService";
   public static final String NATIVE_CLASS = "NativeClass";
   public static final String NATIVE_INTERFACE = "NativeInterface";
   public static final String ENUMERATION = "Enumeration";

   // Transienst stereotypes
   public static final String SERVICE_LISTENER = "ServiceListener";
   public static final String SERVICE_COMMAND = "ServiceCommand";

   public static final String ATTRIBUTE_PKEY = "PKey";

   public static final String FEATURE_OPTIONAL = "0..1";
   public static final String FEATURE_MULTIVALUE = "1..*";
   public static final String FEATURE_OPTIONAL_MULTIVALUE = "0..*";

   public static final String DIRECTION_IN = "In";
   public static final String DIRECTION_OUT = "Out";
   public static final String DIRECTION_IN_OUT = "In_Out";

   public static final String BOUND = "Bound";
   public static final String CONSTRAINED = "Constrained";
   
   public static final String ASYNC_CALL = "AsyncCall";
   public static final String INITIALIZER = "Initializer";
   
   public static final String EXTENDS = "Extends";
   
   // <<BusinessService>> properties
   public static final String PROPERTY_STATEFUL = "Stateful";
}
