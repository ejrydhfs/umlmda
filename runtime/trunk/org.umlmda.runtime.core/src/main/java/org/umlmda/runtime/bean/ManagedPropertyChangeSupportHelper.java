/**
 * 
 */
package org.umlmda.runtime.bean;

import java.beans.PropertyChangeEvent;

/**
 * Property change support supporting the queuing of events with the {@link PropertyChangeEventManager}.
 * 
 * @author Dieter Moroff (26.06.2008)
 */
public class ManagedPropertyChangeSupportHelper extends PropertyChangeSupportHelper
{

   /**
    * 
    */
   private static final long serialVersionUID = -8375918682023160287L;

   /**
    * @param sourceBean
    */
   public ManagedPropertyChangeSupportHelper(Object sourceBean) {
      super(sourceBean);
   }

   @Override
   public void firePropertyChange(PropertyChangeEvent evt) {
      PropertyChangeEventManager.INSTANCE.firePropertyChange(getPropertyChangeListeners(evt), evt);
   }

   public boolean startQueuing() {
      return PropertyChangeEventManager.INSTANCE.startQueuing();
   }

   public void finishQueuing() {
      PropertyChangeEventManager.INSTANCE.finishQueuing();

   }

}
