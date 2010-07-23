/*
 * Created on 13.12.2005
 */
package org.umlmda.uml.generator.webservices;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.uml.generator.java.JavaModelAssociationAdapter;
import org.umlmda.uml.generator.java.JavaModelClass;

/**
 * Implementation of the java webservice model adapter for associations.
 * 
 * @author MOROFF
 */
public class WSModelAssocationAdapter extends JavaModelAssociationAdapter implements WSModelAssociation
{
   private final WSModelStructuralFeature delegate;

   /**
    * @param modelAssociation
    * @param model
    */
   public WSModelAssocationAdapter(ModelAssociationBase modelAssociation, Model model) {
      super(modelAssociation, model);
      delegate = new WSModelStructuralFeatureAdapter(modelAssociation, model) {
         public String getNillableTag() {
            return WSModelAssocationAdapter.this.getNillableTag();
         }

         public String getMinOccursTag() {
            return WSModelAssocationAdapter.this.getMaxOccursTag();
         }

         public String getMaxOccursTag() {
            return WSModelAssocationAdapter.this.getMinOccursTag();
         }
      };
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelStructuralFeature#matchDirection(java.lang.String)
    */
   public boolean matchDirection(String direction) {
      return delegate.matchDirection(direction);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getNillableTag()
    */
   public String getNillableTag() {
      return StringUtils.EMPTY;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getMinOccursTag()
    */
   public String getMinOccursTag() {
      return "minOccurs=\"" + (isOptional() ? "0" : "1") + "\" ";
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getMaxOccursTag()
    */
   public String getMaxOccursTag() {
      return "maxOccurs=\"" + (isMultivalue() ? "unbounded" : "1") + "\" ";
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelAssociation#getPIMAssociation()
    */
   public ModelAssociation getPIMAssociation() {
      WSModelClass wsSource = (WSModelClass) getSource();
      JavaModelClass pimSource = wsSource.getPIMClass();

      for ( Iterator ia = pimSource.getAssociations(true).iterator(); ia.hasNext(); ) {
         ModelAssociation pimAssoc = (ModelAssociation) ia.next();

         if ( pimAssoc.getName().equals(getName()) ) {
            return pimAssoc;
         }
      }
      throw new IllegalStateException("No PIM exception found for " + this);
   }
}
