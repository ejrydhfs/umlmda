package java.beans;

import java.beans.PropertyChangeEvent;
import java.util.EventListener;

public interface PropertyChangeListener extends EventListener {
	
	/**
	 * This method gets called when a bound property is changed.
	 * @param evt
	 */
	void propertyChange(PropertyChangeEvent evt);
    
}
