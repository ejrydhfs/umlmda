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
 * Created on 31.07.2006 (Dieter Moroff)
 */
package org.umlmda.model.uml;

/**
 * Interface for generalization associations between model classes
 * 
 * @author MOROFF
 */
public interface ModelGeneralizationBase extends ModelElementBase
{

   /**
    * Returns the specific child (subclass) of the generalization
    */
   ModelClassBase getSpecificBase();

   /**
    * Returns the general parent (superclass) of the generalization
    */
   ModelClassBase getGeneralBase();
}
