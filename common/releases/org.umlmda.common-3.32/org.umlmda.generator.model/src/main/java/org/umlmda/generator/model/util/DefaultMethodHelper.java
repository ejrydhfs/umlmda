/*
 *  Copyright (C) 2003, 2004, 2005 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://www.umlmda.org)
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
 *  Created on 22.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.generator.model.util;

import java.util.Iterator;

import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelParameter;

/**
 * Shows an method in uml signature
 * 
 * @author MOROFF
 */
public class DefaultMethodHelper implements IMethodHelper
{
   IClassHelper classHelper;

   /**
    * 
    */
   public DefaultMethodHelper() {
      super();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IMethodHelper#getMethodSignature(org.umlmda.model.uml.ModelMethod)
    */
   public String getMethodSignature(ModelMethod method) {
      StringBuffer buffer = new StringBuffer();

      if ( method.getStereotypes().size() > 0 ) {
         buffer.append("<<");
         for ( Iterator is = method.getStereotypes().iterator(); is.hasNext(); ) {
            String stereotype = (String) is.next();

            buffer.append(stereotype);
            if ( is.hasNext() ) {
               buffer.append(", ");
            }
         }
         buffer.append(">>");
      }
      buffer.append(method.getName());
      buffer.append("(");
      for ( Iterator ip = method.getParameters().iterator(); ip.hasNext(); ) {
         ModelParameter parameter = (ModelParameter) ip.next();

         buffer.append(parameter.getName());
         buffer.append(" : ");
         buffer.append(classHelper.getType(parameter.getType()));
         if ( ip.hasNext() ) {
            buffer.append(", ");
         }
      }
      buffer.append(")");
      if ( method.getReturnType() != null ) {
         buffer.append(" : ");
         buffer.append(classHelper.getType(method.getReturnType()));
      }
      return null;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IMethodHelper#getClassHelper()
    */
   public IClassHelper getClassHelper() {
      return classHelper;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IMethodHelper#setClassHelper(net.sourceforge.umlmda.generator.IClassHelper)
    */
   public void setClassHelper(IClassHelper classHelper) {
      this.classHelper = classHelper;
   }

}
