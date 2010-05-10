/*
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
 * Created by Dieter Moroff (13.04.2006)
 */
package org.umlmda.uml.generator.webservices;

import java.beans.Introspector;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.umlmda.model.uml.DefaultModelVisitor;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.ModelParameterBase;
import org.umlmda.model.uml.attributes.Multiplicity;
import org.umlmda.model.uml.impl.ModelAttributeImpl;
import org.umlmda.model.uml.impl.ModelClassImpl;
import org.umlmda.model.uml.impl.ModelMethodImpl;
import org.umlmda.model.uml.impl.ModelPackageImpl;
import org.umlmda.model.uml.impl.ModelParameterImpl;

/**
 * Visitor to creates web service request and reponse classes for method, used for soap wrapping.
 * 
 */
public class WSPSMRequestReponseCreateVisitor extends DefaultModelVisitor
{

   public static final String RESPONSE_POSTFIX = "Response";
   public static final String REQUEST_POSTFIX  = "Request";

   /**
    * 
    */
   public WSPSMRequestReponseCreateVisitor() {
      super();
   }

   public boolean visit(ModelMethod method) {
      super.visit(method);

      if ( method.hasStereotype(WSStereotypes.WEB_SERVICE_METHOD)
            && (method.getReturnType() == null || method.getReturnType().hasStereotype(WSStereotypes.WEB_SERVICE_RESPONSE) == false) ) {
         if ( method.getBase() instanceof ModelMethodImpl ) {
            ModelMethodImpl methodImpl = (ModelMethodImpl) method.getBase();

            // Replace returntype with response class
            methodImpl.setReturnTypeBase(createResponseClass(method));

            // Replace parameters with request class
            ModelParameterBase requestParameterImpl = createRequestParameter(method);

            methodImpl.getParameters().clear();
            methodImpl.getParameters().add(requestParameterImpl);
         }
      }
      return true;
   }

   /**
    * @param methodImpl
    * @return
    */
   private ModelParameterBase createRequestParameter(ModelMethod method) {
      // Check if parameters already replaced
      if ( method.getParameters().size() == 1 ) {
         ModelParameter parameter = (ModelParameter) method.getParameters().get(0);

         if ( parameter.hasStereotype(WSStereotypes.WEB_SERVICE_REQUEST) ) {
            return (ModelParameterBase) parameter.getBase();
         }
      }

      ModelMethodImpl methodImpl = (ModelMethodImpl) method.getBase();
      WSModelClass modelClass = (WSModelClass) method.getOwningClass();
      WSModelPackage modelPackage = (WSModelPackage) modelClass.getPackageBase();
      WSModel model = (WSModel) modelPackage.getModel();
      String name = getRequestReponseName(methodImpl, REQUEST_POSTFIX);
      String qualifiedName = modelPackage.getWsPackage().getQualifiedName() + "." + name;
      ModelClass wsRequestClass = (ModelClass) model.find(qualifiedName);
      ModelClassImpl wsRequestClassImpl;
      Multiplicity multiplicity = new Multiplicity(1, 1);

      if ( wsRequestClass != null ) {
         wsRequestClassImpl = (ModelClassImpl) wsRequestClass.getBase();
      }
      else {
         wsRequestClassImpl = new ModelClassImpl(model, (ModelPackageBase) modelPackage.getWsPackage());
         wsRequestClassImpl.setName(name);
         wsRequestClassImpl.getStereotypes().add(WSStereotypes.WEB_SERVICE_REQUEST);
         wsRequestClassImpl.getStereotypes().add(WSStereotypes.WEB_SERVICE_OBJECT);

         for ( Iterator ip = methodImpl.getParameters().iterator(); ip.hasNext(); ) {
            ModelParameterBase parameter = (ModelParameterBase) ip.next();
            ModelAttributeImpl attributeImpl = new ModelAttributeImpl(model, wsRequestClassImpl);

            attributeImpl.setName(parameter.getName());
            attributeImpl.setModelClassifierBase(parameter.getTypeBase());
            attributeImpl.setMultiplicity(multiplicity);
            wsRequestClassImpl.getAttributes().add(attributeImpl);
         }

      }

      ModelParameterImpl parameterImpl = new ModelParameterImpl(model, methodImpl);

      parameterImpl.setName("in");
      parameterImpl.setTypeBase(wsRequestClassImpl);
      WSPSMClassCreatorVisitor.createWsClassAdapter(model, wsRequestClassImpl);
      return parameterImpl;
   }

   /**
    * @param methodImpl
    * @return
    */
   private ModelClassBase createResponseClass(ModelMethod method) {
      ModelMethodImpl methodImpl = (ModelMethodImpl) method.getBase();
      WSModelClass modelClass = (WSModelClass) method.getOwningClass();
      WSModelPackage modelPackage = (WSModelPackage) modelClass.getPackageBase();
      WSModel model = (WSModel) modelPackage.getModel();
      String name = getRequestReponseName(methodImpl, RESPONSE_POSTFIX);
      String qualifiedName = modelPackage.getWsPackage().getQualifiedName() + "." + name;
      ModelClassBase wsResponseClass = (ModelClassBase) model.find(qualifiedName);

      if ( wsResponseClass != null ) {
         return wsResponseClass;
      }
      else {
         ModelClassImpl wsResponseClassImpl = new ModelClassImpl(model, (ModelPackageBase) modelPackage.getWsPackage().getBase());

         wsResponseClassImpl.setName(name);
         wsResponseClassImpl.getStereotypes().add(WSStereotypes.WEB_SERVICE_RESPONSE);
         wsResponseClassImpl.getStereotypes().add(WSStereotypes.WEB_SERVICE_OBJECT);

         if ( methodImpl.getReturnTypeBase() != null ) {
            ModelAttributeImpl attributeImpl = new ModelAttributeImpl(model, wsResponseClassImpl);

            attributeImpl.setModelClassifierBase(methodImpl.getReturnTypeBase());
            attributeImpl.setName("returnValue");
            attributeImpl.setMultiplicity(new Multiplicity(1, 1));
            wsResponseClassImpl.getAttributes().add(attributeImpl);
         }

         WSPSMClassCreatorVisitor.createWsClassAdapter(model, wsResponseClassImpl);
         return wsResponseClassImpl;
      }
   }

   /**
    * @param methodImpl
    * @param modelClass
    * @return
    */
   private String getRequestReponseName(ModelMethodBase method, String postfix) {
      ModelClassBase modelClass = method.getOwningClass();

      return modelClass.getName() + StringUtils.capitalize(method.getName()) + postfix;
   }

}
