package org.umlmda.runtime.bean;

import java.beans.PropertyChangeListener;

/**
 * Interface for classes providing {@link java.beans.PropertyChangeSupport}.
 * 
 * @author moroff
 */
public interface IPropertyChangeSupport {

	abstract public void addPropertyChangeListener(PropertyChangeListener listener);
	
	abstract public void addPropertyChangeListener(String propertyName,PropertyChangeListener listener);

	abstract public PropertyChangeListener[] getPropertyChangeListeners();

	abstract public PropertyChangeListener[] getPropertyChangeListeners(String propertyName); 

	abstract public boolean hasListeners(String propertyName);
	
	abstract public void removePropertyChangeListener(PropertyChangeListener listener);

	abstract public void removePropertyChangeListener(String propertyName,PropertyChangeListener listener);	

}
