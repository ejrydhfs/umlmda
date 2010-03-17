/*
 *   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelGeneralization.java,v 1.1 2006/08/09 10:40:26 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelGeneralization.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2006/08/09 10:40:26 $
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
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface ModelGeneralization extends ModelGeneralizationBase, ModelElement {

   /**
    * Returns the specific child (subclass) of the generalization
    */
   ModelClass getSpecific();

   /**
    * Returns the general parent (superclass) of the generalization
    */
   ModelClass getGeneral();
}
