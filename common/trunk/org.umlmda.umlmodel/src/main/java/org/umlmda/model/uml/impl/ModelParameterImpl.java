/*
 *   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelParameterImpl.java,v 1.2 2006/04/13 23:04:37 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelParameterImpl.java,v $
 * $Revision: 1.2 $
 *     $Name:  $
 *     $Date: 2006/04/13 23:04:37 $
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
 * Created by Dieter Moroff (08.08.2005)
 */
package org.umlmda.model.uml.impl;

import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelParameterBase;

/**
 * Basic implementation of a model methods parameter
 * @author MOROFF
 */
public class ModelParameterImpl extends ModelElementImpl implements ModelParameterBase {

   private String direction = IN;
   private ModelClassifierBase typeBase = null;

   /**
    * @param model
    * @param owner
    */
   public ModelParameterImpl(ModelBase model, ModelElementBase owner) {
      super(model, owner);
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelParameterBase#getDirection()
    */
   public String getDirection() {
      return direction;
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelParameterBase#getTypeBase()
    */
   public ModelClassifierBase getTypeBase() {
      return typeBase;
   }

   public void setTypeBase(ModelClassifierBase typeBase) {
      this.typeBase = typeBase;
      notifyObservers(PROPERTY_TYPEBASE);
   }
}
