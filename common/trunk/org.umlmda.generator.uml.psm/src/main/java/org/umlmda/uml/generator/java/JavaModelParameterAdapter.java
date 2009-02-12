/*
 *   $Header$
 *   $Source$
 * $Revision$
 *     $Name$
 *     $Date$
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
package org.umlmda.uml.generator.java;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelParameterBase;
import org.umlmda.model.uml.impl.ModelParameterAdapter;

/**
 * TODO Insert type javadoc
 * @author Dieter Moroff (13.03.2006), last change $Date$ $Name$
 * @version $Revision$
 */
public class JavaModelParameterAdapter extends ModelParameterAdapter implements JavaModelParameter {

   /**
    * @param modelParameter
    * @param model
    */
   public JavaModelParameterAdapter(ModelParameterBase modelParameter, Model model) {
      super(modelParameter, model);
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelParameter#getJavaType()
    */
   public String getJavaType() {
      JavaModelClassifier classifier = (JavaModelClassifier) getType();
      
      return classifier.getJavaType();
   }

}
