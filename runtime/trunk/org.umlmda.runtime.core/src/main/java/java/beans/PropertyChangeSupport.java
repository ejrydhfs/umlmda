/**
 * Remimplementation of the java.bean.PropertyChangeSupport for gwt
 */
package java.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeListenerProxy;
import java.io.Serializable;
import java.util.ArrayList;

public class PropertyChangeSupport implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6401253773779951803L;
	
	private ArrayList listeners;
	private Object    sourceBean;
	
	public PropertyChangeSupport(Object    sourceBean) {
		this.listeners  = new java.util.ArrayList ();
		this.sourceBean = sourceBean;
	}

	public synchronized void addPropertyChangeListener(
			PropertyChangeListener listener) {
		listeners.add(listener);
	}

	public synchronized void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		
		listeners.add(new PropertyChangeListenerProxy(propertyName,listener));		
	}

	public void firePropertyChange(PropertyChangeEvent evt) {
		
		PropertyChangeListener[] lsnrArray;
		
		if (evt.getPropertyName() != null && evt.getPropertyName().length() > 0){
			lsnrArray = getPropertyChangeListeners(evt.getPropertyName());
		}
		else {
			lsnrArray = getPropertyChangeListeners();
		}

// TODO Logging is helpful		
//		if (Logger.isDebugEnabled()) {
//			Logger.debug("Processing PptChangeEvent for Property "
//					+ evt.getPropertyName() + " Listener count is "
//					+ lsnrArray.length);
//		}

		for (int i = 0; i < lsnrArray.length; i++) {
			lsnrArray[i].propertyChange(evt);
		}
	}

	public void firePropertyChange(String propertyName, boolean oldValue,
			boolean newValue) {
		firePropertyChange(new PropertyChangeEvent(this,propertyName,new Boolean(oldValue),new Boolean(newValue)));
	}

	public void firePropertyChange(String propertyName, int oldValue,
			int newValue) {
		firePropertyChange(new PropertyChangeEvent(this,propertyName, new Integer(oldValue), new Integer(newValue)));
	}

	public void firePropertyChange(String propertyName, Object oldValue,
			Object newValue) {
		firePropertyChange(new PropertyChangeEvent(this,propertyName,oldValue,newValue));
	}

	public synchronized PropertyChangeListener[] getPropertyChangeListeners() {
		PropertyChangeListener[] lsnrArray = new PropertyChangeListener[0];
		lsnrArray = (PropertyChangeListener[]) listeners.toArray(lsnrArray);
		
		return lsnrArray;
		
	}

	public synchronized PropertyChangeListener[] getPropertyChangeListeners(
			String propertyName) {
		PropertyChangeListener[] lsnrArray = new PropertyChangeListener[0];
		
		ArrayList pptLsnrs = new ArrayList();
		
		for (java.util.Iterator i = listeners.iterator(); i.hasNext();){
			Object nextObj = i.next();

			if (nextObj instanceof PropertyChangeListenerProxy) {
				PropertyChangeListenerProxy proxy = (PropertyChangeListenerProxy) nextObj;
				
				if ( proxy.getPropertyName().equals(propertyName)){
					pptLsnrs.add(nextObj);
				}
			}
			else {
				pptLsnrs.add(nextObj);
			}
			
		}
		
		lsnrArray = (PropertyChangeListener[]) pptLsnrs.toArray(lsnrArray);
		
		return lsnrArray;
		
	}

	public synchronized boolean hasListeners(String propertyName) {
		boolean bFound = false;
		
		for (java.util.Iterator i = listeners.iterator(); i.hasNext();){
			Object nextObj = i.next();

			if (nextObj instanceof PropertyChangeListenerProxy) {
				PropertyChangeListenerProxy proxy = (PropertyChangeListenerProxy) nextObj;
				
				if ( proxy.getPropertyName().equals(propertyName)){
					bFound = true;
					break;
				}
			}
		}
		
		return bFound;
	}

	public synchronized void removePropertyChangeListener(
			PropertyChangeListener listener) {
		listeners.remove(listener);
	}

	public synchronized void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {

		PropertyChangeListener[] pptLsnr = getPropertyChangeListeners(propertyName);
		
		for (int i = 0; i < pptLsnr.length ; i++){
			PropertyChangeListenerProxy proxy = (PropertyChangeListenerProxy) pptLsnr[i];
			if (proxy.getListener() == listener){
				listeners.remove(proxy);
			}
		}		
	}

}
