/*
 * Created on 04.11.2005
 */
package org.umlmda.model.uml.nsuml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelDependencyBase;

import ru.novosoft.uml.foundation.core.MClassifier;
import ru.novosoft.uml.foundation.core.MDependency;
import ru.novosoft.uml.foundation.core.MModelElement;

/**
 * @author MOROFF
 */
public class ModelDependencyImpl extends ModelElementImpl implements ModelDependencyBase
{
   private final MDependency modelDependency;
   private List              suppliers = null;
   private List              clients   = null;

   /**
    * @param model
    * @param owner
    */
   public ModelDependencyImpl(ModelImpl model, MDependency modelDependency) {
      super(model, modelDependency);
      this.modelDependency = modelDependency;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelDependencyBase#getClients()
    */
   public Collection getClients() {
      if ( clients == null ) {
         clients = new ArrayList();
         addElements(model, clients, modelDependency.getClients());
      }
      return suppliers;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelDependencyBase#getSuppliers()
    */
   public Collection getSuppliers() {
      if ( suppliers == null ) {
         suppliers = new ArrayList();
         addElements(model, suppliers, modelDependency.getSuppliers());
      }
      return suppliers;
   }

   private static void addElements(ModelImpl model, Collection elementList, Collection modelElementList) {
      for ( Iterator ic = modelElementList.iterator(); ic.hasNext(); ) {
         MModelElement element = (MModelElement) ic.next();

         if ( element instanceof MClassifier ) {
            MClassifier classifier = (MClassifier) element;
            ModelClassifierBase modelClassifier = model.findClassifier(classifier);

            if ( modelClassifier != null ) {
               elementList.add(modelClassifier);
            }
            else {
               // TODO handle not found
            }
         }
         else {
            // TODO handle all types
         }

      }

   }
}
