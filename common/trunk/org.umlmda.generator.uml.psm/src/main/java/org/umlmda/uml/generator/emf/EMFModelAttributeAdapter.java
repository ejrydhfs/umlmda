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

import org.apache.commons.lang.StringUtils;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.java.JavaModelAttributeAdapter;
import org.umlmda.uml.generator.java.JavaModelClassifier;
import org.umlmda.uml.generator.webservices.WSModelAttributeAdapter;

/**
 * PSM Adapter for generation emf code from model attributes.
 * 
 * @author MOROFF
 */
public class EMFModelAttributeAdapter extends WSModelAttributeAdapter implements EMFAnnotationHolder
{

   /**
    * @param modelAttribute
    * @param model
    */
   public EMFModelAttributeAdapter(ModelAttributeBase modelAttribute, Model model) {
      super(modelAttribute, model);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.emf.EMFAnnotationHolder#getAnnotaion()
    */
   public String getEmfAnnotation() {
      StringBuffer buffer = new StringBuffer();
      JavaModelClassifier classifier = (JavaModelClassifier) getModelClassifier();

      buffer.append("@model");
      if ( StringUtils.isNotEmpty(getInitialValue()) ) {
         buffer.append(" default=\"" + getInitialValue() + "\"");
      }
      if ( hasStereotype(ModelStereotype.ATTRIBUTE_PKEY) ) {
         buffer.append(" id=\"true\"");
      }
      if ( isMultivalue() ) {
         buffer.append(" type=\"" + classifier.getJavaType() + "\" ordered=\"true\"");
      }
      if ( isOptional() == false ) {
         buffer.append(" required=\"true\"");
      }
      if ( isReadOnly() ) {
         buffer.append(" unsettable=\"true\"");
      }
      if ( isDerived() ) {
         buffer.append(" transient=\"true\"");
      }

      return buffer.toString();
   }

}
