/*
 * Created on Apr 29, 2005
 */
package org.umlmda.model.uml.nsuml;

import org.umlmda.model.uml.ModelStructuralFeatureBase;

import ru.novosoft.uml.foundation.core.MModelElement;

/**
 * @author moroff
 */
public abstract class ModelStructuralFeatureImpl extends ModelElementImpl implements ModelStructuralFeatureBase
{

   /**
    * @param model
    * @param modelElement
    */
   public ModelStructuralFeatureImpl(ModelImpl model, MModelElement modelElement) {
      super(model, modelElement);
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelStructuralFeature#isDerived()
    */
   public boolean isDerived() {
      return Boolean.valueOf(getModelElement().getTaggedValue("derived", "false")).booleanValue();
   }

}
