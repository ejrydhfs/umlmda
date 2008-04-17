package java.beans;

import java.io.Serializable;
import java.util.EventObject;

public class PropertyChangeEvent extends EventObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8800227542384873986L;
	private Object newValue; 
	private Object oldValue; 
	private Object propagationId;
	private String propertyName;
	
	PropertyChangeEvent(Object source, String propertyName, Object oldValue, Object newValue) {
		super(source);
		this.propertyName = propertyName;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	
	public Object getNewValue() {
		return newValue;
	}

	public Object getOldValue() {
		return oldValue;
	}

	public Object getPropagationId() {
		// TODO Auto-generated method stub
		return propagationId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropagationId(Object propagationId) {
		this.propagationId = propagationId;
	}

	
}
