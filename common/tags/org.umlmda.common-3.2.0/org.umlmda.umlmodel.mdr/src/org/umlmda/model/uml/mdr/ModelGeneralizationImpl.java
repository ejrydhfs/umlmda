/*
 *   $Header: /cvsroot/umlmda/UMLModelMDR/src/org/umlmda/model/uml/mdr/ModelGeneralizationImpl.java,v 1.1 2006/08/09 10:40:36 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModelMDR/src/org/umlmda/model/uml/mdr/ModelGeneralizationImpl.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2006/08/09 10:40:36 $
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
package org.umlmda.model.uml.mdr;

import org.omg.uml.foundation.core.Generalization;
import org.omg.uml.foundation.core.UmlClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelGeneralizationBase;


/**
 * Generalization implementation for netbean nodel data repository (MDR)
 * @author Dieter Moroff
 */
public class ModelGeneralizationImpl extends ModelElementImpl implements ModelGeneralizationBase {
   private final Generalization generalization;
   private ModelClassBase child = null;
   private ModelClassBase parent = null;
   
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
      if ( child == null && generalization.getChild() instanceof UmlClass ) {
         child = ((ModelImpl)getModelBase()).findClass((UmlClass)generalization.getChild());
      }
      return child;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelGeneralizationBase#getParentBase()
    */
   public ModelClassBase getGeneralBase() {
      if ( parent == null && generalization.getParent() instanceof UmlClass ) {
         parent = ((ModelImpl)getModelBase()).findClass((UmlClass)generalization.getParent());
      }
      return parent;
   }


}
