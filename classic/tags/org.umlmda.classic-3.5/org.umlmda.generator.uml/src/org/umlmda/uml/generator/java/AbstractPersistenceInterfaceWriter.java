/*
 *  $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/java/AbstractPersistenceInterfaceWriter.java,v 1.4 2007/04/12 06:47:50 moroff Exp $
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
 *  Created on Dec 14, 2004 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.java;

import java.util.Iterator;
import java.util.List;


import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelDataType;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class AbstractPersistenceInterfaceWriter extends AbstractInterfaceWriter {

   /**
    * Creates the signature of a persistance service read method
    */
   public String readSignatur(ModelAssociation association) {
      StringBuffer buffer = new StringBuffer();
      
      buffer.append(getType(association.getTarget()));
      buffer.append(" read");
      buffer.append(StringUtil.firstToUpperCase(association.getName()));
      buffer.append("(");
      appendPKeyParameterSignature(association, buffer);
      buffer.append(")");
      
      return buffer.toString();
   }

   /**
    * Creates the signature of a persistance service read method
    */
   public String deleteSignatur(ModelAssociation association) {
      StringBuffer buffer = new StringBuffer();
      
      buffer.append(getType(association.getTarget()));
      buffer.append(" delete");
      buffer.append(StringUtil.firstToUpperCase(association.getName()));
      buffer.append("(");
      appendPKeyParameterSignature(association, buffer);
      buffer.append(")");
      
      return buffer.toString();
   }

   public String key(ModelAssociation association) {
      StringBuffer buffer = new StringBuffer();
      List keyAttributes = association.getTarget().getKeyAttributes();
      
      if ( keyAttributes.size() > 1 ) {
         buffer.append("new ");
         buffer.append(association.getTarget().getName());
         buffer.append(".PKey(");
         appendPKeyParameter(buffer, keyAttributes);
         buffer.append(")");
      }
      else if ( keyAttributes.size() == 1 ) {
         ModelAttribute attribute = (ModelAttribute) keyAttributes.iterator().next();
         ModelDataType dataType = attribute.getDataType();
         
         if ( "int".equals(dataType.getName())) {
            buffer.append("new Integer("+attribute.getName()+")");
         }
         else if ( "short".equals(dataType.getName())) {
            buffer.append("new Short("+attribute.getName()+")");
         }
         else if ( "long".equals(dataType.getName())) {
            buffer.append("new Long("+attribute.getName()+")");
         }
         else if ( "boolean".equals(dataType.getName())) {
            buffer.append("new Boolean("+attribute.getName()+")");
         }
         else if ( "double".equals(dataType.getName())) {
            buffer.append("new Double("+attribute.getName()+")");
         }
         else {
            buffer.append(attribute.getName());
         }
      }

      return buffer.toString();
   }
   
   public String keyValues(ModelAssociation association) {
      StringBuffer buffer = new StringBuffer();
      
      appendPKeyParameter(buffer, association.getTarget().getKeyAttributes());
      return buffer.toString();
   }
   
   /**
    * @param buffer
    * @param keyAttributes
    */
   private void appendPKeyParameter(StringBuffer buffer, List keyAttributes) {
      for (Iterator iter = keyAttributes.iterator(); iter.hasNext();) {
         ModelAttribute attribute = (ModelAttribute) iter.next();
         
         buffer.append(attribute.getName());
         if ( iter.hasNext() )
            buffer.append(", ");
      }
   }

   /**
    * @param association
    * @param buffer
    */
   private void appendPKeyParameterSignature(ModelAssociation association, StringBuffer buffer) {
      for (Iterator iter = association.getTarget().getKeyAttributes().iterator(); iter.hasNext();) {
         ModelAttribute attribute = (ModelAttribute) iter.next();
         
         buffer.append(getType(attribute));
         buffer.append(" ");
         buffer.append(attribute.getName());
         if ( iter.hasNext() )
            buffer.append(", ");
      }
   }
}
