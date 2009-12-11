/*
 *   $Header: /cvsroot/umlmda/org.umlmda.generator.uml.oaw/src/org/umlmda/oaw/generator/model/j2ee/J2EEModelPackageAdapter.java,v 1.1 2006/08/09 11:49:58 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.generator.uml.oaw/src/org/umlmda/oaw/generator/model/j2ee/J2EEModelPackageAdapter.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2006/08/09 11:49:58 $
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
 * Created on 08.08.2006 (Dieter Moroff)
 */
package org.umlmda.oaw.generator.model.j2ee;

import java.util.List;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.oaw.generator.model.java.JavaBusinessObject;
import org.umlmda.oaw.generator.model.java.JavaBusinessService;
import org.umlmda.oaw.generator.model.java.JavaModelPackage;
import org.umlmda.oaw.generator.model.java.JavaModelPackageAdapter;

public class J2EEModelPackageAdapter extends org.umlmda.uml.generator.j2ee.J2EEModelPackageAdapter implements
      J2EEModelPackage {

   private final JavaModelPackage delegate;
   
   public J2EEModelPackageAdapter(ModelPackageBase modelPackage, Model modelAdapter) {
      super(modelPackage, modelAdapter);
      delegate = new JavaModelPackageAdapter(modelPackage, modelAdapter);
   }

   public List<JavaBusinessObject> getBusinessObjects() {
      return delegate.getBusinessObjects();
   }

   public List<JavaBusinessService> getBusinessServices() {
      return delegate.getBusinessServices();
   }

}
