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
 * Created on 04.12.2006 (Dieter Moroff)
 */
package org.umlmda.uml.generator.emf;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.uml.generator.java.JavaArtefacts;
import org.umlmda.uml.generator.java.JavaModelClass;
import org.umlmda.uml.generator.webservices.WSModelClassAdapter;
import org.umlmda.uml.generator.webservices.WSStereotypes;

/**
 * @author MOROFF
 */
public class EMFModelClassAdapter extends WSModelClassAdapter implements EMFAnnotationHolder
{

   /**
    * @param modelClassBase
    * @param model
    */
   public EMFModelClassAdapter(ModelClassBase modelClassBase, Model model) {
      super(modelClassBase, model);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.emf.EMFAnnotationHolder#getEmfAnnotation()
    */
   public String getEmfAnnotation() {
      StringBuffer buffer = new StringBuffer();

      buffer.append("@model");
      if ( isAbstract() ) {
         buffer.append(" abstract=\"true\"");
      }
      return buffer.toString();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClassifier#getJavaType()
    */
   public String getJavaType() {
      JavaModelClass genClass = (JavaModelClass) getGeneratorModel().getContext().getCurrentModelElement();

      if ( hasStereotype(WSStereotypes.WEB_SERVICE_DTO) ) {
         return genClass.getScopedName(JavaArtefacts.BUSINESS_OBJECT_INTERFACE, this);
      }
      else {
         return super.getJavaType();
      }
   }
}
