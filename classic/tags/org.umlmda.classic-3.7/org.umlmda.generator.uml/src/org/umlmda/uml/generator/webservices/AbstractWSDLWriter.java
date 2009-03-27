/*
 *  $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/webservices/AbstractWSDLWriter.java,v 1.7 2006/07/10 15:37:08 moroff Exp $
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
 *  Created on Dec 9, 2004 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.generator.model.util.AbstractClassHelper;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelPackage;

/**
 * Baseclass for writer generating hibernate mappings
 * @author moroff
 */
public abstract class AbstractWSDLWriter extends AbstractWSWriter {
   
   public AbstractWSDLWriter() {
      super();
      setClassHelper(new AbstractClassHelper() {

         public String getType(ModelClassifier modelClassifier) {
            return ((WSModelClassifier)modelClassifier).getSchemaType();
         }

         public String getType(ModelDataType type) {
            return ((WSModelDataType)type).getSchemaType();
         }

         public String getNamespaceSep() {
            return ":";
         }
         
         });
   }
   
   /**
    * @deprecated use WSModelPackage.getNamespace();
    */
   public String getType(ModelPackage modelPackage) {
      return ((WSModelPackage)modelPackage).getNamespace();
   }
   
}
