package org.umlmda.runtime.bean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import junit.framework.TestCase;

public class PropertyChangeEventManagerTest extends TestCase {
   private int eventCount;
   private ManagedPropertyChangeSupportHelper propertyChangeSupport;
   private PropertyChangeListener listener;
   
   @Override
   protected void setUp() throws Exception {
      super.setUp();
      eventCount = 0;
      propertyChangeSupport = new ManagedPropertyChangeSupportHelper(this);
      propertyChangeSupport.addPropertyChangeListener(new PropertyChangeListener() {

         public void propertyChange(PropertyChangeEvent evt) {
            ++eventCount; 
         }});   
   }
   
   public void testFirePropertyChange() {
      propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "property", null, null));
      
      assertEquals(1, eventCount);
      
      propertyChangeSupport.startQueuing();

      propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "property", null, null));
      propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, "property", null, null));
      assertEquals(1, eventCount);

      propertyChangeSupport.finishQueuing();
      assertEquals(3, eventCount);
   }

}
