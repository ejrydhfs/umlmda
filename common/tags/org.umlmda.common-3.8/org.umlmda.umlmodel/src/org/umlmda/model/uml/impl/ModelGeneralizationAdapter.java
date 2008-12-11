/*
 *   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelGeneralizationAdapter.java,v 1.1 2006/08/09 10:40:24 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelGeneralizationAdapter.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2006/08/09 10:40:24 $
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

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelGeneralization;
import org.umlmda.model.uml.ModelGeneralizationBase;

/**
 * @author MOROFF
 */
public class ModelGeneralizationAdapter extends ModelElementAdapter implements ModelGeneralization {
   private final ModelGeneralizationBase modelGeneralization;
   
   /**
    * @param modelElement
    * @param adaptedModel
    */
   public ModelGeneralizationAdapter(ModelGeneralizationBase modelGeneralization, Model adaptedModel) {
      super(modelGeneralization, adaptedModel);
      this.modelGeneralization = modelGeneralization;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelGeneralization#getSpecific()
    */
   public ModelClass getSpecific() {
      return adaptedModel.getModelClass(modelGeneralization.getSpecificBase());
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelGeneralization#getGeneral()
    */
   public ModelClass getGeneral() {
      return adaptedModel.getModelClass(modelGeneralization.getGeneralBase());
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelGeneralizationBase#getSpecificBase()
    */
   public ModelClassBase getSpecificBase() {
      return getSpecific();
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelGeneralizationBase#getGeneralBase()
    */
   public ModelClassBase getGeneralBase() {
      return getGeneral();
   }

   public String toString() {
      return getSpecific() + " extends " + getGeneral();
   }
}
