/*
 * Created on Jan 12, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.j2ee;

import org.umlmda.model.uml.ModelClass;

import org.apache.commons.lang.StringUtils;
import org.umlmda.generator.model.util.Feedback;
import org.umlmda.profile.ModelTaggedValues;
import org.umlmda.uml.generator.java.AbstractJavaClassWriter;

/**
 * Base class for all writers generating j2ee interfaces and classes.
 * @author moroff
 */
public abstract class AbstractJ2EEInterfaceWriter extends AbstractJavaClassWriter {
	protected J2EEModelClassAdapter modelClass;
   
   public void setModelClass(ModelClass modelClass) {
      if ( modelClass instanceof J2EEModelClassAdapter ) {
         this.modelClass = (J2EEModelClassAdapter) modelClass;
         super.setModelClass(modelClass);
      }
      else {
         throw new RuntimeException("used modelclass \""+modelClass.getClass().getName()+"\" not derived from "+J2EEModelClassAdapter.class.getName());
      }
   }
   
   public String getComponent() {
      String component = modelClass.getPackage().getTaggedValues().getProperty(ModelTaggedValues.EBJ_COMPONENT, ""); 

      if ( StringUtils.isEmpty(component)) {
         getFeedback().message(Feedback.WARNING, "Tagged value EJBComponent not set for "+modelClass.getPackage().getQualifiedName());
      }
      return component;
   }
}
