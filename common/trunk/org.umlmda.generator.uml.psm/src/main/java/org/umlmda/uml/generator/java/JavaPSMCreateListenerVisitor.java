/* This library is free software; you can redistribute it and/or
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
 * Created by Dieter Moroff (14.04.2006)
 */
package org.umlmda.uml.generator.java;

import org.apache.commons.lang.StringUtils;
import org.umlmda.model.uml.DefaultModelVisitor;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.model.uml.impl.ModelClassImpl;
import org.umlmda.model.uml.impl.ModelMethodImpl;
import org.umlmda.model.uml.impl.ModelParameterImpl;
import org.umlmda.profile.ModelStereotype;

/**
 * Visitor to create a listener for <<AsyncCall>> methods
 * 
 * @author Dieter Moroff (14.04.2006)
 */
public class JavaPSMCreateListenerVisitor extends DefaultModelVisitor
{

   public boolean visit(ModelMethod method) {
      super.visit(method);

      if ( method.hasStereotype(ModelStereotype.ASYNC_CALL) ) {

         // Check if listener was created
         ModelParameterImpl parameterImpl = createAsyncParameter(method);
         ModelMethodBase methodBase = (ModelMethodBase) method.getBase();
         Model model = method.getModel();

         methodBase.getParameters().add(model.getModelParameter(parameterImpl));
      }
      return true;
   }

   /**
    * @param ownerClass
    * @param genPackage
    * @param genModel
    * @return
    */
   protected ModelParameterImpl createAsyncParameter(ModelMethod method) {
      JavaModelClass ownerClass = (JavaModelClass) method.getOwner();
      JavaModelPackage genPackage = (JavaModelPackage) ownerClass.getPackage();
      JavaModel genModel = (JavaModel) genPackage.getModel();

      String listenerPostfix = genModel.getProperties().getProperty("ListenerPostfix", "Listener");
      JavaModelClass listener = (JavaModelClass) genModel.find(ownerClass
            .getQualifiedName(JavaArtefacts.BUSINESS_SERVICE_INTERFACE)
            + listenerPostfix);

      if ( listener == null ) {
         ModelClassImpl listenerClass = new ModelClassImpl(genModel, genPackage);
         listener = (JavaModelClass) genModel.getModelClass(listenerClass);
         listenerClass.setName(ownerClass.getName() + listenerPostfix);
         listenerClass.getStereotypes().add(ModelStereotype.SERVICE_LISTENER);

         {
            ModelMethodImpl onReturn = new ModelMethodImpl(genModel, listenerClass);
            onReturn.setName("on" + StringUtils.capitalize(method.getName()) + "Return");

            ModelParameterImpl onReturnParameter = new ModelParameterImpl(genModel, onReturn);
            onReturnParameter.setName("message");
            onReturnParameter.setTypeBase(((ModelMethodBase) method.getBase()).getReturnTypeBase());
            onReturn.getParameters().add(genModel.getModelParameter(onReturnParameter));
            listenerClass.getMethods().add(genModel.getModelMethod(onReturn));
         }

         {
            ModelMethodImpl onException = new ModelMethodImpl(genModel, listenerClass);
            onException.setName("on" + StringUtils.capitalize(method.getName()) + "Exception");

            ModelParameterImpl onExceptionParameter = new ModelParameterImpl(genModel, onException);
            onExceptionParameter.setName("exception");
            onExceptionParameter.setTypeBase((ModelClass) genModel.find("java.lang.Throwable"));
            onException.getParameters().add(genModel.getModelParameter(onExceptionParameter));
            listenerClass.getMethods().add(genModel.getModelMethod(onException));
         }

         genPackage.getClasses().add(listener);
         genModel.getClasses().add(listener);
      }

      ModelParameterImpl parameterImpl = new ModelParameterImpl(genModel, method);
      parameterImpl.setTypeBase(listener);
      parameterImpl.setName("listener");
      return parameterImpl;
   }

}
