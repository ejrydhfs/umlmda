/*
 *  $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/java/AbstractJavaPackageWriter.java,v 1.2 2005/10/27 19:01:18 moroff Exp $
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
 *  Created on 20.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.AbstractPackageWriter;

/**
 * @author moroff
 */
public abstract class AbstractJavaPackageWriter extends AbstractPackageWriter {

   /**
    * @param classHelper
    * @param methodHelper
    */
   public AbstractJavaPackageWriter(JavaClassHelper classHelper, JavaMethodHelper methodHelper) {
      super(classHelper, methodHelper);
   }

   /**
    * @param classHelper
    * @param methodHelper
    */
   public AbstractJavaPackageWriter(JavaClassHelper classHelper) {
      super(classHelper, new JavaMethodHelper(classHelper));
   }
   
   /**
    * @param classHelper
    * @param methodHelper
    */
   public AbstractJavaPackageWriter() {
      super(new JavaClassHelper(), new JavaMethodHelper(null));
   }
   
}
