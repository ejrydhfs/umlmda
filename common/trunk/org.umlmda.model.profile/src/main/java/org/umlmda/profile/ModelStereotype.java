// UMLMDA, UMLModel-API
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

   String BUSINESS_COMPONENT = "BusinessComponent";
   String BUSINESS_EXCEPTION = "BusinessException";
   String BUSINESS_OBJECT = "BusinessObject";
   String BUSINESS_SERVICE = "BusinessService";
   String PERSISTENCE_SERVICE = "PersistenceService";
   String NATIVE_CLASS = "NativeClass";
   String NATIVE_INTERFACE = "NativeInterface";
   String ENUMERATION = "Enumeration";

   // Transienst stereotypes
   String SERVICE_LISTENER = "ServiceListener";
   String SERVICE_COMMAND = "ServiceCommand";

   String ATTRIBUTE_PKEY = "PKey";

   String FEATURE_OPTIONAL = "0..1";
   String FEATURE_MULTIVALUE = "1..*";
   String FEATURE_OPTIONAL_MULTIVALUE = "0..*";

   String DIRECTION_IN = "In";
   String DIRECTION_OUT = "Out";
   String DIRECTION_IN_OUT = "In_Out";

   String BOUND = "Bound";
   String CONSTRAINED = "Constrained";
   
   String ASYNC_CALL = "AsyncCall";
   String INITIALIZER = "Initializer";
   
   String EXTENDS = "Extends";
   
   // <<BusinessService>> properties
   String PROPERTY_STATEFUL = "Stateful";
}
