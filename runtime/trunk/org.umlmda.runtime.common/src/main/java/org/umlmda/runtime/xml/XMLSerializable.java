/*
 *  Copyright (C) 2003, 2005 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://www.umlmda.org)
 *
 *  UMLMDA is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 * 
 *  UMLMDA is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  General Public License for more details.
 * 
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with UMLMDA; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 *  02111-1307, USA.
 *
 *  Created on Dec 15, 2004 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.runtime.xml;

/**
 * Interface to add the capability to stream an object to XML
 * 
 * @author MOROFF
 */
public interface XMLSerializable
{

   /**
    * XML serialization
    */
   String toXmlString();

   /**
    * XML serialization of the elements and all children
    */
   void marshal(String elementName, XMLMarshalContext context, boolean isRoot);

}
