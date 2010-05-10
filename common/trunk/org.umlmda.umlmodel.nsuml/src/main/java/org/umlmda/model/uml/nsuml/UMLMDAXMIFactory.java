// UMLMDA, UMLModel-API
// 
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Library General Public
//  License as published by the Free Software Foundation; either
//  version 2 of the License, or (at your option) any later version.
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Library General Public License for more details.
//
//  You should have received a copy of the GNU Library General Public
//  License along with this library; if not, write to the
//  Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//  Boston, MA  02111-1307, USA. The text of license can be also found
//  at http://www.gnu.org/copyleft/lgpl.html
//
//  Created on Nov 19, 2004
package org.umlmda.model.uml.nsuml;

import java.util.Iterator;

import ru.novosoft.uml.foundation.core.MAssociation;
import ru.novosoft.uml.foundation.core.MAssociationEnd;
import ru.novosoft.uml.foundation.core.MAttribute;
import ru.novosoft.uml.foundation.core.MClassifier;
import ru.novosoft.uml.foundation.core.MModelElement;
import ru.novosoft.uml.foundation.core.MOperation;
import ru.novosoft.uml.foundation.data_types.MChangeableKind;
import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValue;
import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValueImpl;
import ru.novosoft.uml.model_management.MPackage;
import cb.petal.Association;
import cb.petal.Attribute;
import cb.petal.Class;
import cb.petal.ClassAttribute;
import cb.petal.ClassCategory;
import cb.petal.List;
import cb.petal.Operation;
import cb.petal.PetalFile;
import cb.petal.QuidObject;
import cb.petal.Role;
import cb.xmi.XMIGenerator;

/**
 * @author moroff
 */
public class UMLMDAXMIFactory extends cb.xmi.XMIFactory
{

   /*
    * (non-Javadoc)
    * @see cb.xmi.XMIFactory#createClass(cb.petal.Class)
    */
   public MClassifier createClass(Class clazz) {
      MClassifier classifier = super.createClass(clazz);

      copyTaggedValues(clazz, classifier);
      return classifier;
   }

   /*
    * (non-Javadoc)
    * @see cb.xmi.XMIFactory#createPackage(cb.petal.ClassCategory)
    */
   public MPackage createPackage(ClassCategory cat) {
      MPackage modelPackage = super.createPackage(cat);

      copyTaggedValues(cat, modelPackage);
      return modelPackage;
   }

   /**
    * @param clazz
    * @param classifier
    */
   private void copyTaggedValues(QuidObject clazz, MModelElement classifier) {
      List attributes = (List) clazz.getProperty("attributes");
      if ( attributes != null ) {
         for ( Iterator iter = attributes.getElements().iterator(); iter.hasNext(); ) {
            Attribute element = (Attribute) iter.next();

            if ( element.getPropertyAsString("tool").startsWith("UMLMDA") ) {
               MTaggedValue taggedValue = new MTaggedValueImpl();
               taggedValue.setTag(element.getPropertyAsString("name"));
               taggedValue.setValue(element.getPropertyAsString("value"));
               classifier.addTaggedValue(taggedValue);
            }
         }
      }
   }

   /**
    * 
    */
   public UMLMDAXMIFactory() {
      super();
   }

   /**
    * @param tree
    * @param gen
    */
   public UMLMDAXMIFactory(PetalFile tree, XMIGenerator gen) {
      super(tree, gen);
   }

   /*
    * (non-Javadoc)
    * @see cb.xmi.XMIFactory#createAttribute(cb.petal.ClassAttribute)
    */
   public MAttribute createAttribute(ClassAttribute attr) {
      MAttribute attribute = super.createAttribute(attr);
      List attributes = (List) attr.getProperty("attributes");

      if ( attributes != null ) {
         for ( Iterator iter = attributes.getElements().iterator(); iter.hasNext(); ) {
            Attribute element = (Attribute) iter.next();

            if ( element.getPropertyAsString("tool").startsWith("UMLMDA") ) {
               String tagName = element.getPropertyAsString("name");

               if ( tagName.equals("changeable") && element.getPropertyAsBoolean("value") == false ) {
                  attribute.setChangeability(MChangeableKind.FROZEN);
               }
               else {
                  MTaggedValue taggedValue = new MTaggedValueImpl();

                  taggedValue.setTag(tagName);
                  taggedValue.setValue(element.getPropertyAsString("value"));
                  attribute.addTaggedValue(taggedValue);
               }
            }
         }
      }
      return attribute;
   }

   /*
    * (non-Javadoc)
    * @see cb.xmi.XMIFactory#createAssociationEnd(cb.petal.Role)
    */
   public MAssociationEnd createAssociationEnd(Role role) {
      MAssociationEnd associationEnd = super.createAssociationEnd(role);

      copyTaggedValues(role, associationEnd);
      return associationEnd;
   }

   /*
    * (non-Javadoc)
    * @see cb.xmi.XMIFactory#createAssociation(cb.petal.Association)
    */
   public MAssociation createAssociation(Association assoc) {
      MAssociation association = super.createAssociation(assoc);

      copyTaggedValues(assoc, association);
      return association;
   }

   public MOperation createOperation(Operation op) {
      MOperation operation = super.createOperation(op);

      copyTaggedValues(op, operation);
      return operation;
   }
}
