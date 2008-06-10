/*
 * Created on Apr 29, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.model.uml.nsuml;

import org.umlmda.model.uml.ModelStructuralFeatureBase;

import ru.novosoft.uml.foundation.core.MModelElement;

/**
 * @author moroff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class ModelStructuralFeatureImpl extends ModelElementImpl implements
      ModelStructuralFeatureBase {

   /**
    * @param model
    * @param modelElement
    */
   public ModelStructuralFeatureImpl(ModelImpl model, MModelElement modelElement) {
      super(model, modelElement);
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelStructuralFeature#isDerived()
    */
   public boolean isDerived() {
      return Boolean.valueOf(getModelElement().getTaggedValue("derived", "false")).booleanValue(); 
   }
   
}
