/*
 * Created on 04.11.2005
 */
package org.umlmda.model.uml.uml2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelDependencyBase;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelPackageBase;

/**
 * @author MOROFF
 */
public class ModelDependencyImpl extends ModelElementImpl implements ModelDependencyBase
{
   private final Dependency       modelDependency;
   private List<ModelElementBase> suppliers = null;
   private List<ModelElementBase> clients   = null;

   /**
    * @param model
    * @param owner
    */
   public ModelDependencyImpl(ModelImpl model, Dependency modelDependency) {
      super(model, modelDependency);
      this.modelDependency = modelDependency;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelDependencyBase#getClients()
    */
   public Collection<ModelElementBase> getClients() {
      if ( clients == null ) {
         clients = new ArrayList<ModelElementBase>();
         addElements(model, clients, modelDependency.getClients());
      }
      return clients;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelDependencyBase#getSuppliers()
    */
   public Collection<ModelElementBase> getSuppliers() {
      if ( suppliers == null ) {
         suppliers = new ArrayList<ModelElementBase>();
         addElements(model, suppliers, modelDependency.getSuppliers());
      }
      return suppliers;
   }

   private static void addElements(ModelImpl model, Collection<ModelElementBase> elementList,
         Collection<NamedElement> modelElementList) {
      for ( Iterator<NamedElement> ic = modelElementList.iterator(); ic.hasNext(); ) {
         NamedElement element = ic.next();

         if ( element instanceof Classifier ) {
            Classifier umlClassifier = (Classifier) element;
            ModelClassifierBase modelClassifier = model.findClassifier(umlClassifier);

            if ( modelClassifier != null ) {
               elementList.add(modelClassifier);
            }
            else {
               // TODO handle not found
            }
         }
         else if ( element instanceof Package ) {
            Package umlPackage = (Package) element;
            ModelPackageBase modelPackage = model.findPackage(umlPackage);

            if ( modelPackage != null ) {
               elementList.add(modelPackage);
            }
            else {
               // TODO handle not found
            }
         }
         else if ( element instanceof Property ) {
            Property umlProperty = (Property) element;

            if ( umlProperty.getAssociation() == null ) {
               if ( umlProperty.getOwner() instanceof Class ) {
                  ModelClassBase modelClass = model.findClass((Class) umlProperty.getOwner());

                  for ( Iterator<?> ia = modelClass.getAttributes().iterator(); ia.hasNext(); ) {
                     ModelAttributeBase modelAttribute = (ModelAttributeBase) ia.next();

                     if ( modelAttribute.getName().equals(umlProperty.getName()) ) {
                        elementList.add(modelAttribute);
                        break;
                     }
                  }
               }
            }
            else {
               // TODO Handle association
            }
         }
         else if ( element instanceof Association ) {

         }
         else {
            // TODO handle all types
         }

      }

   }
}
