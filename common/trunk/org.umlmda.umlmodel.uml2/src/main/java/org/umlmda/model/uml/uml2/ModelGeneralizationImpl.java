/*
 *   $Header: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelGeneralizationImpl.java,v 1.1.2.1 2006/11/20 10:47:08 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelGeneralizationImpl.java,v $
 * $Revision: 1.1.2.1 $
 *     $Name: oAW $
 *     $Date: 2006/11/20 10:47:08 $
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
package org.umlmda.model.uml.uml2;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Generalization;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelGeneralizationBase;


/**
 * Generalization implementation for eclipse uml2
 * @author Dieter Moroff
 */
public class ModelGeneralizationImpl extends ModelElementImpl implements ModelGeneralizationBase {
   private final Generalization generalization;
   private ModelClassBase specific = null;
   private ModelClassBase general = null;
   
   /**
    * @param model
    * @param owner
    */
   public ModelGeneralizationImpl(ModelImpl model, Generalization generalization) {
      super(model, generalization);
      this.generalization = generalization;
    }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelGeneralizationBase#getChildBase()
    */
   public ModelClassBase getSpecificBase() {
      if ( specific == null && generalization.getSpecific() instanceof Class ) {
         specific = ((ModelImpl)getModelBase()).findClass((Class)generalization.getSpecific());
      }
      return specific;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelGeneralizationBase#getParentBase()
    */
   public ModelClassBase getGeneralBase() {
      if ( general == null && generalization.getGeneral() instanceof Class ) {
         general = ((ModelImpl)getModelBase()).findClass((Class)generalization.getGeneral());
      }
      return general;
   }


}
