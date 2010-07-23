/*
 *  Copyright (C) 2003, 2004 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://umlmda.sf.net)
 *
 *  UMLMDA is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 * 
 *  UMLMDA is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  General Public License for more details.
 * 
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with UMLMDA; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 *  02111-1307, USA.
 *
 *  Created on 04.10.2004 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.model.uml.uml2;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelParameterBase;

/**
 * @author Dieter Moroff
 */
public class ModelParameterImpl extends ModelElementImpl implements ModelParameterBase
{
   private final Parameter     modelParameter;
   private ModelClassifierBase modelClassifier = null;

   /**
    * @param modelElement
    */
   ModelParameterImpl(ModelImpl model, Parameter modelParameter) {
      super(model, modelParameter);
      this.modelParameter = modelParameter;
   }

   /**
    * Returns the parameters direction <code></code>
    * 
    * @return
    */
   public String getDirection() {
      if ( modelParameter.getDirection().getValue() == ParameterDirectionKind.IN )
         return IN;
      else if ( modelParameter.getDirection().getValue() == ParameterDirectionKind.OUT )
         return OUT;
      else
         return IN_OUT;
   }

   public ModelClassifierBase getTypeBase() {
      if ( modelClassifier == null ) {
         modelClassifier = model.findClassifier((Classifier) modelParameter.getType());
      }
      return modelClassifier;
   }
}
