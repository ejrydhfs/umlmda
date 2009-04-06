/*
 *  $Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/j2ee/J2EEModelMethodAdapter.java,v 1.2 2007/01/15 09:26:55 moroff Exp $
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
 *  Created on 21.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.j2ee;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.model.uml.impl.ModelParameterImpl;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.java.JavaClassHelper;
import org.umlmda.uml.generator.java.JavaMethodHelper;
import org.umlmda.uml.generator.java.JavaModel;
import org.umlmda.uml.generator.java.JavaModelClass;
import org.umlmda.uml.generator.java.JavaModelMethodAdapter;
import org.umlmda.uml.generator.java.JavaModelPackage;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class J2EEModelMethodAdapter extends JavaModelMethodAdapter implements J2EEModelMethod {

   /**
    * @param modelMethod
    * @param model
    */
   public J2EEModelMethodAdapter(ModelMethodBase modelMethod, Model model) {
      super(modelMethod, model);
   }

   protected ModelParameterImpl createAsyncParameter(JavaModelClass ownerClass, JavaModelPackage genPackage,
         JavaModel genModel) {
      
      ModelParameterImpl parameterImpl = new ModelParameterImpl(getModel(), this);
      parameterImpl.setTypeBase((ModelClassifierBase) getModel().find("javax.jms.Queue"));
      parameterImpl.setName("queue");
      return parameterImpl;
   }
   
   public ModelClassifier getReturnType() {
      if ( hasStereotype(ModelStereotype.ASYNC_CALL)) {
         return null;
      }
      else {
         return super.getReturnType();
      }
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.j2ee.J2EEModelMethod#getRemoteSignature()
    */
   public String getRemoteSignature() {
      // TODO Auto-generated method stub
      JavaClassHelper classHelper = new JavaClassHelper();
      JavaMethodHelper methodHelper = new JavaMethodHelper(classHelper) {
         /* (non-Javadoc)
          * @see org.umlmda.uml.generator.AbstractMethodHelper#getPlatformExceptions()
          */
         protected String getPlatformExceptions() {
            // TODO Auto-generated method stub
            return "java.rmi.RemoteException";
         }
      };

      classHelper.setModelClass((ModelClass) getOwningClass());
      return methodHelper.getMethodSignature(this);
   }
}
