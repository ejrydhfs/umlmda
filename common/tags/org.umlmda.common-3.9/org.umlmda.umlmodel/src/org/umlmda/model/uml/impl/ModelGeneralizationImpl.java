/*
 *   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelGeneralizationImpl.java,v 1.1 2006/08/09 10:40:25 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelGeneralizationImpl.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2006/08/09 10:40:25 $
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
package org.umlmda.model.uml.impl;

import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelGeneralizationBase;

/**
 * Basic implementation of a generalization
 * @author MOROFF
 */
public class ModelGeneralizationImpl extends ModelElementImpl implements ModelGeneralizationBase {
   private ModelClassBase specific;
   private ModelClassBase general;
   
   /**
    * @param model
    * @param owner
    */
   public ModelGeneralizationImpl(ModelBase model, ModelClassBase general, ModelClassBase specific) {
      super(model, general);
      this.specific = specific;
      this.general = general;
   }

   /**
    * @param model
    * @param owner
    * @param source
    */
   public ModelGeneralizationImpl(ModelBase model, ModelElementBase owner, ModelGeneralizationBase source) {
      super(model, owner, source);
      this.specific = source.getSpecificBase();
      this.general = source.getGeneralBase();
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelGeneralizationBase#getSpecificBase()
    */
   public ModelClassBase getSpecificBase() {
      return specific;
   }

   public void setSpecific(ModelClassBase specific) {
      this.specific = specific;
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelGeneralizationBase#getGeneralBase()
    */
   public ModelClassBase getGeneralBase() {
      return general;
   }

   public void setGeneral(ModelClassBase general) {
      this.general = general;
   }
}
