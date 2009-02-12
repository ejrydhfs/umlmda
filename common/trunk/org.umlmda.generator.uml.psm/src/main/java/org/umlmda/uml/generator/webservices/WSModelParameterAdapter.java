/*
 *   $Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSModelParameterAdapter.java,v 1.1 2006/12/04 10:49:49 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSModelParameterAdapter.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2006/12/04 10:49:49 $
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

import org.apache.commons.lang.StringUtils;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelParameterBase;
import org.umlmda.uml.generator.java.JavaModelParameterAdapter;

/**
 * TODO Insert type javadoc
 * @author Dieter Moroff (13.03.2006), last change $Date: 2006/12/04 10:49:49 $ $Name:  $
 * @version $Revision: 1.1 $
 */
public class WSModelParameterAdapter extends JavaModelParameterAdapter implements WSModelParameter {

   /**
    * @param modelParameter
    * @param model
    */
   public WSModelParameterAdapter(ModelParameterBase modelParameter, Model model) {
      super(modelParameter, model);
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getConvertToWs(java.lang.String)
    */
   public String getConvertToWs() {
      return getConvert("WebserviceUtils.convertToWs");
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getConvertToWs(java.lang.String)
    */
   public String getConvertFromWs() {
      return getConvert("WebserviceUtils.convertFromWs");
   }

   private String getConvert(String convertFunction) {
      if ( isConvertionNeeded() ) {
         return convertFunction+"("+getName()+")";
      }
      else
         return getName();
   }
   
   public boolean isConvertionNeeded() {
      return getJavaType().equals(super.getJavaType()) == false;
   }
   
   /**
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getJavaType()
    */
   public String getJavaType() {
      ModelClassifier classifier = getType();
      
      if ( classifier instanceof WSModelDataType ) {
         WSModelDataType dataType = (WSModelDataType) classifier;
         
         return dataType.getJavaType();
      }
      else {
         return super.getJavaType();
      }
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelParameter#getGetter()
    */
   public String getGetter() {
      if ( getType().getName().equals(ModelDataType.BOOLEAN)) {
         return "is"+StringUtils.capitalize(getName());
      }
      else {
         return "get"+StringUtils.capitalize(getName());
      }
   }
   

}
