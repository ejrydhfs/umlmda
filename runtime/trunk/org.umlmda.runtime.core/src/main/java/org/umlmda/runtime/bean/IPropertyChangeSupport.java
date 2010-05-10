package org.umlmda.runtime.bean;

import java.beans.PropertyChangeListener;

/**
 * Interface for classes providing {@link java.beans.PropertyChangeSupport}.
 * 
 * @author moroff
 */
public interface IPropertyChangeSupport
{

   void addPropertyChangeListener(PropertyChangeListener listener);

   void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);

   PropertyChangeListener[] getPropertyChangeListeners();

   PropertyChangeListener[] getPropertyChangeListeners(String propertyName);

   boolean hasListeners(String propertyName);

   void removePropertyChangeListener(PropertyChangeListener listener);

   void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);

}
