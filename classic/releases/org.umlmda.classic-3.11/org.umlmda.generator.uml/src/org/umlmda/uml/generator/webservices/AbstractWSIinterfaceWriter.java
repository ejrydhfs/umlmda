/*
 *  $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/webservices/AbstractWSIinterfaceWriter.java,v 1.2 2005/10/27 19:01:18 moroff Exp $
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelParameter;

/**
 * @author moroff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class AbstractWSIinterfaceWriter extends AbstractWSWriter {
   public AbstractWSIinterfaceWriter() {
      super();
   }

   public List getReferencedClasses() {
      Set referencedClassSet = new HashSet();
      
      for (Iterator im = getModelClass().getMethods().iterator(); im.hasNext();) {
         ModelMethod method = (ModelMethod) im.next();
         
         if ( method.getReturnType() instanceof ModelClass )
            referencedClassSet.add(method.getReturnType());
         for (Iterator ip = method.getParameters().iterator(); ip.hasNext();) {
            ModelParameter parameter = (ModelParameter) ip.next();
            
            if ( parameter.getType() instanceof ModelClass ) {
               referencedClassSet.add(parameter.getType());
            }
         }
         for (Iterator ie = method.getExceptions().iterator(); ie.hasNext();) {
            ModelClass exception = (ModelClass) ie.next();
            
            referencedClassSet.add(exception);
         }
      }
      List referencedClasses = new ArrayList(referencedClassSet);
      Collections.sort(referencedClasses);
      return referencedClasses;
   }
}
