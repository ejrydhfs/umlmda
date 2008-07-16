/*
 *  $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/java/AbstractBusinessFactoryWriter.java,v 1.5 2007/04/12 06:47:18 moroff Exp $
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
 *  Created on Dec 15, 2004 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.java;

import java.util.Collection;
import java.util.Iterator;

import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class AbstractBusinessFactoryWriter extends AbstractJavaPackageWriter {

   public AbstractBusinessFactoryWriter() {
//      super(new AbstractInterfaceWriter.JavaClassHelper() {
//         public String getPackageName() {
//            return AbstractBusinessFactoryWriter.this.getThePackageName();
//         }
//      });
   }
   
   private String getThePackageName() {
      return getPackageName();
   }
   
   public String getParameterSignature(Collection keyAttributes) {
      StringBuffer buffer = new StringBuffer();
      
      for (Iterator iter = keyAttributes.iterator(); iter.hasNext();) {
         JavaModelAttribute attribute = (JavaModelAttribute) iter.next();
         
         buffer.append(attribute.getType());
         buffer.append(" ");
         buffer.append(attribute.getName());
         if ( iter.hasNext() ) {
            buffer.append(", ");
         }
      }
      return buffer.toString();
   }

   public String getParameter(Collection keyAttributes) {
      StringBuffer buffer = new StringBuffer();
      
      for (Iterator iter = keyAttributes.iterator(); iter.hasNext();) {
         ModelAttribute attribute = (ModelAttribute) iter.next();
         
         buffer.append(attribute.getName());
         if ( iter.hasNext() ) {
            buffer.append(", ");
         }
      }
      return buffer.toString();
   }

   public String getParameter(String parentName, ModelClass parent, Collection keyAttributes) {
      StringBuffer buffer = new StringBuffer();
      Collection parentKeyAttributes = parent.getKeyAttributes();
      
      for (Iterator iter = parentKeyAttributes.iterator(); iter.hasNext();) {
         JavaModelAttribute attribute = (JavaModelAttribute) iter.next();
         
         buffer.append(parentName);
         buffer.append(".");
         buffer.append(attribute.getGetter());
         buffer.append("()");
         if ( iter.hasNext() ) {
            buffer.append(", ");
         }
      }

      if ( parentKeyAttributes.size() > 0 && keyAttributes.size() > 0 ) {
         buffer.append(", ");
      }
      
      for (Iterator iter = keyAttributes.iterator(); iter.hasNext();) {
         ModelAttribute attribute = (ModelAttribute) iter.next();
         
         buffer.append(attribute.getName());
         if ( iter.hasNext() ) {
            buffer.append(", ");
         }
      }
      return buffer.toString();
   }
   
   
}
