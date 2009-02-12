/*
 *   $Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/emf/EMFPSMTestCreateVisitor.java,v 1.1 2007/01/03 21:15:54 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/emf/EMFPSMTestCreateVisitor.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2007/01/03 21:15:54 $
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
package org.umlmda.uml.generator.emf;

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
import org.umlmda.uml.generator.webservices.WSModel;
import org.umlmda.uml.generator.webservices.WSModelClass;
import org.umlmda.uml.generator.webservices.WSModelPackage;
import org.umlmda.uml.generator.webservices.WSPSMClassCreatorVisitor;
import org.umlmda.uml.generator.webservices.WSStereotypes;

/**
 * Visitor to creates web service request and reponse classes for method,
 * used for soap wrapping.
 * @author Dieter Moroff (13.04.2006), last change $Date: 2007/01/03 21:15:54 $ $Name:  $
 * @version $Revision: 1.1 $
 */
public class EMFPSMTestCreateVisitor extends DefaultModelVisitor {

   /**
    * 
    */
   public EMFPSMTestCreateVisitor() {
      super();
   }

   public boolean visit(ModelMethod method) {
      super.visit(method);

      if (method.hasStereotype(WSStereotypes.WEB_SERVICE_METHOD) && method.getBase() instanceof ModelMethodImpl ) {
         createTestClass(method);
      }
      return true;
   }
   
   /**
    * @param methodImpl
    * @return
    */
   private void createTestClass(ModelMethod method) {
      ModelMethodImpl methodImpl = (ModelMethodImpl) method.getBase();
      WSModelClass modelClass = (WSModelClass) method.getOwningClass();
      WSModelPackage modelPackage = (WSModelPackage) modelClass.getPackageBase();
      WSModel model = (WSModel) modelPackage.getModel();
      String name = getTestName(methodImpl, "Test");
      String qualifiedName = modelPackage.getWsPackage().getQualifiedName() + "." + name;
      ModelClass emfTestClass = (ModelClass) model.find(qualifiedName);
      Multiplicity multiplicity = new Multiplicity(1, 1);

      if ( emfTestClass == null ) {
         ModelClassImpl emfTestClassImpl = new ModelClassImpl(model, (ModelPackageBase) modelPackage.getWsPackage());
         emfTestClassImpl.setName(name);
         emfTestClassImpl.getStereotypes().add(EMFStereotypes.EMF_TEST);

         // Handle parameters
         for (Iterator ip = methodImpl.getParameters().iterator(); ip.hasNext();) {
            ModelParameterBase parameter = (ModelParameterBase) ip.next();
            ModelAttributeImpl attributeImpl = new ModelAttributeImpl(model, emfTestClassImpl);
            
            attributeImpl.setName(parameter.getName());
            attributeImpl.setModelClassifierBase(parameter.getTypeBase());
            attributeImpl.setMultiplicity(multiplicity);
            emfTestClassImpl.getAttributes().add(attributeImpl);
         }

         // Handle returntype
         if (methodImpl.getReturnTypeBase() != null) {
            ModelAttributeImpl attributeImpl = new ModelAttributeImpl(model, emfTestClassImpl);

            attributeImpl.setModelClassifierBase(methodImpl.getReturnTypeBase());
            attributeImpl.setName("returnValue");
            attributeImpl.setMultiplicity(new Multiplicity(1, 1));
            emfTestClassImpl.getAttributes().add(attributeImpl);
         }
         
         WSPSMClassCreatorVisitor.createWsClassAdapter(model, emfTestClassImpl);
      }
      
   }

   /**
    * @param methodImpl
    * @param modelClass
    * @return
    */
   private String getTestName(ModelMethodBase method, String postfix) {
      ModelClassBase modelClass = method.getOwningClass();

      return modelClass.getName()+StringUtils.capitalize(method.getName())+postfix;
   }
   
}
