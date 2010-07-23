/*
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Created by Dieter Moroff (13.03.2006)
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.uml.generator.java.JavaModelParameter;

/**
 * TODO Insert type javadoc
 * 
 */
public interface WSModelParameter extends JavaModelParameter
{

   /**
    * Returns the signature of the conversion call to map the interface parameter type to a webservice parameter type.
    */
   String getConvertToWs();

   /**
    * Returns the signature of the conversion call to map a webservice parameter type to the interface parameter type.
    */
   String getConvertFromWs();

   /**
    * Returns the name of a parameter getter if the parameter is wrapped in a structure
    */
   String getGetter();
}
