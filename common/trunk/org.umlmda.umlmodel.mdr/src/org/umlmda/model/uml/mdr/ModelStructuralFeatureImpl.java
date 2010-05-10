/*
 * Created on Apr 29, 2005
 */
package org.umlmda.model.uml.mdr;


import org.omg.uml.foundation.core.ModelElement;
import org.omg.uml.foundation.core.UmlClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelStructuralFeatureBase;


/**
 * @author moroff
 *
 * 
 * 
 */
public abstract class ModelStructuralFeatureImpl extends ModelElementImpl implements
      ModelStructuralFeatureBase {

   /**
    * @param model
    * @param modelElement
    */
   public ModelStructuralFeatureImpl(ModelImpl model, ModelElement modelElement) {
      super(model, modelElement);
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelStructuralFeature#isDerived()
    */
   public boolean isDerived() {
      return Boolean.getBoolean(getTaggedValue("derived", "false"));
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelStructuralFeature#getOwningClass()
    */
   public ModelClassBase getOwningClassBase() {
      return model.findClass((UmlClass)modelElement.getNamespace());
   }
   
   
}
