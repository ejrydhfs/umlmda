/*
 *  $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/webservices/AbstractWSImplWriter.java,v 1.3 2006/07/10 15:37:08 moroff Exp $
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
 *  Created on Apr 13, 2005 (Dieter Moroff)
 */
package org.umlmda.uml.generator.webservices;


import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.uml.generator.java.AbstractInterfaceWriter;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;

/**
 * @author moroff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class AbstractWSImplWriter extends AbstractWSWriter {
   protected IClassHelper interfaceClassHelper = new AbstractInterfaceWriter.JavaClassHelper() {
      public String getType(ModelClassifier classifier) {
         if ( classifier instanceof ModelClass ) {
            ModelClass modelClass = (ModelClass)classifier;
            
            if ( modelClass.getPackage() == getModelClass().getPackage() )
               return modelClass.getPackage().getQualifiedName() + "." + super.getType(classifier);
            else
               return super.getType(classifier);
         }
         else {
            return super.getType(classifier);
         }
      }
   };
   
   public AbstractWSImplWriter() {
      super();
      setClassHelper(new AbstractInterfaceWriter.JavaClassHelper() {
         public String getType(ModelClassifier modelClassifier) {
            if (modelClassifier instanceof ModelClass) {
               ModelClass modelClass = (ModelClass) modelClassifier;

               if ( hasDerivedClasses(modelClass) )
                  return modelClass.getName() + "Hierarchie";
               else
                  return modelClass.getName();
            }
            else
               return getType((ModelDataType)modelClassifier);         
         }

         public String getType(ModelDataType type) {
         	if ( type == null ) {
         		return "void";
         	}
            else if ( type.getName().equals(ModelDataType.BOOLEAN) ) {
               return "Boolean";
            }
            else if ( type.getName().equals(ModelDataType.DATE) ) {
               return "java.util.Date";
            }
            else if ( type.getName().equals(ModelDataType.DATE_TIME) ) {
               return "java.util.Date";
            }
            else if ( type.getName().equals(ModelDataType.DOUBLE) ) {
               return "Double";
            }
            else if ( type.getName().equals(ModelDataType.FLOAT) ) {
               return "Float";
            }
            else if ( type.getName().equals(ModelDataType.INT) ) {
               return "Integer";
            }
            else if ( type.getName().equals(ModelDataType.LONG) ) {
               return "Long";
            }
            else if ( type.getName().equals(ModelDataType.SHORT) ) {
               return "Short";
            }
            else 
               return super.getType(type);
         }
         
      });
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractWriter#setModelElement(net.sourceforge.umlmda.xmi.uml.ModelElement)
    */
   public void setModelElement(Object element) {
      super.setModelElement(element);
      interfaceClassHelper.setModelClass((ModelClass)element);
   }
}
