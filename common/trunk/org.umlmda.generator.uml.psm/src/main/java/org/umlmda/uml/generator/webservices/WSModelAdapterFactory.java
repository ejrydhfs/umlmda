//jUMLMDA, UMLModel-API
//
//$Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSModelAdapterFactory.java,v 1.1 2006/12/04 10:49:49 moroff Exp $
//$Source: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSModelAdapterFactory.java,v $
//$Revision: 1.1 $
// $State: Exp $
//  $Name:  $
//  $Date: 2006/12/04 10:49:49 $
//$Locker:  $
//
//This library is free software; you can redistribute it and/or
//modify it under the terms of the GNU Library General Public
//License as published by the Free Software Foundation; either
//version 2 of the License, or (at your option) any later version.
//This library is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//Library General Public License for more details.
//
//You should have received a copy of the GNU Library General Public
//License along with this library; if not, write to the
//Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//Boston, MA  02111-1307, USA. The text of license can be also found
//at http://www.gnu.org/copyleft/lgpl.html
//
//Created on Sep 21, 2005
package org.umlmda.uml.generator.webservices;

import java.util.ArrayList;
import java.util.List;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.ModelParameterBase;
import org.umlmda.model.uml.pattern.ModelPatternFactory;
import org.umlmda.uml.generator.java.JavaModelAdapterFactory;
import org.umlmda.uml.generator.java.PersistenceServicePattern;

/**
 * factory for WebService schema adapters
 *  
 * @author vpussel
 */
public class WSModelAdapterFactory extends JavaModelAdapterFactory {

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.impl.ModelAdapterFactoryImpl#createModel(net.sourceforge.umlmda.xmi.uml.Model)
    */
   protected Model createPsmModel(Model model) {
      return new WSModelAdapter(this, model);
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAdapterFactory#createModelPackage(net.sourceforge.umlmda.xmi.uml.ModelPackageBase, net.sourceforge.umlmda.xmi.uml.Model)
    */
   public ModelAttribute createModelAttribute(ModelAttributeBase modelAttribute, Model model) {
      if (modelAttribute instanceof WSModelAttributeAdapter)
         return (ModelAttribute) modelAttribute;
      else
         return new WSModelAttributeAdapter(modelAttribute, model);
   }

   public ModelDataType createModelDataType(ModelDataTypeBase modelDataType, Model model) {
      if (modelDataType instanceof WSModelDataTypeAdapter)
         return (ModelDataType) modelDataType;
      else
         return new WSModelDataTypeAdapter(modelDataType, model);
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.impl.ModelAdapterFactoryImpl#createModelClass(net.sourceforge.umlmda.xmi.uml.ModelClass, net.sourceforge.umlmda.xmi.uml.AdaptedModel)
    */
   public ModelClass createModelClass(ModelClassBase modelClass, Model model) {
      if (modelClass instanceof WSModelClassAdapter)
         return (ModelClass) modelClass;
      else
         return new WSModelClassAdapter(modelClass, model);
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAdapterFactory#createModelPackage(net.sourceforge.umlmda.xmi.uml.ModelPackageBase, net.sourceforge.umlmda.xmi.uml.Model)
    */
   public ModelPackage createModelPackage(ModelPackageBase modelPackage, Model model) {
      if (modelPackage instanceof WSModelPackageAdapter)
         return (ModelPackage) modelPackage;
      else
         return new WSModelPackageAdapter(modelPackage, model);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelMethod(org.umlmda.model.uml.ModelMethodBase, org.umlmda.model.uml.Model)
    */
   public ModelMethod createModelMethod(ModelMethodBase modelMethod, Model model) {
      if (modelMethod instanceof WSModelMethodAdapter)
         return (ModelMethod) modelMethod;
      else
         return new WSModelMethodAdapter(modelMethod, model);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelAssociation(org.umlmda.model.uml.ModelAssociationBase, org.umlmda.model.uml.Model)
    */
   public ModelAssociation createModelAssociation(ModelAssociationBase modelAssociation, Model destModel) {
      if (modelAssociation instanceof WSModelAssocationAdapter)
         return (ModelAssociation) modelAssociation;
      else
         return new WSModelAssocationAdapter(modelAssociation, destModel);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelParameter(org.umlmda.model.uml.ModelParameterBase, org.umlmda.model.uml.Model)
    */
   public ModelParameter createModelParameter(ModelParameterBase modelParameter, Model destModel) {
      if (modelParameter instanceof WSModelParameterAdapter)
         return (ModelParameter) modelParameter;
      else
         return new WSModelParameterAdapter(modelParameter, destModel);
   }

}
