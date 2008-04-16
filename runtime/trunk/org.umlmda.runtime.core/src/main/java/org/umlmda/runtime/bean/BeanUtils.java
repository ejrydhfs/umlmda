package org.umlmda.runtime.bean;

import java.beans.PropertyChangeSupport;

/**
 * Utilities to ease handly of propery change events
 * 
 * @author Dieter Moroff
 */
public class BeanUtils {

   static public void firePropertyChange(PropertyChangeSupport propertyChangeSupport, String property, Object newValue, Object oldValue) {
      if (propertyChangeSupport.hasListeners(property)) {
         propertyChangeSupport.firePropertyChange(property, oldValue, newValue);
      }
      else {
      }
   }
   
   static public void firePropertyChange(PropertyChangeSupport propertyChangeSupport, String property, int newValue, int oldValue) {
      firePropertyChange(propertyChangeSupport, property, new Integer(newValue), new Integer(oldValue));
   }
   
   static public void firePropertyChange(PropertyChangeSupport propertyChangeSupport, String property, short newValue, short oldValue) {
      firePropertyChange(propertyChangeSupport, property, new Short(newValue), new Short(oldValue));
   }
   
   static public void firePropertyChange(PropertyChangeSupport propertyChangeSupport, String property, long newValue, long oldValue) {
      firePropertyChange(propertyChangeSupport, property, new Long(newValue), new Long(oldValue));
   }

   static public void firePropertyChange(PropertyChangeSupport propertyChangeSupport, String property, float newValue, float oldValue) {
      firePropertyChange(propertyChangeSupport, property, new Float(newValue), new Float(oldValue));
   }

   static public void firePropertyChange(PropertyChangeSupport propertyChangeSupport, String property, double newValue, double oldValue) {
      firePropertyChange(propertyChangeSupport, property, new Double(newValue), new Double(oldValue));
   }

   static public void firePropertyChange(PropertyChangeSupport propertyChangeSupport, String property, boolean newValue, boolean oldValue) {
      firePropertyChange(propertyChangeSupport, property, new Boolean(newValue), new Boolean(oldValue));
   }
   
   static public void firePropertyChange(PropertyChangeSupport propertyChangeSupport, String property, char newValue, char oldValue) {
      firePropertyChange(propertyChangeSupport, property, new Character(newValue), new Character(oldValue));
   }
   
}
