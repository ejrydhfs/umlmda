/*
 *   $Header: /cvsroot/umlmda/runtime/org.umlmda.runtime.core/src/main/java/org/umlmda/runtime/bean/NotificationChain.java,v 1.2 2008/04/09 12:12:42 moroff Exp $
 *   $Source: /cvsroot/umlmda/runtime/org.umlmda.runtime.core/src/main/java/org/umlmda/runtime/bean/NotificationChain.java,v $
 * $Revision: 1.2 $
 *     $Name:  $
 *     $Date: 2008/04/09 12:12:42 $
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Created on 09.04.2008 (Gerd Reinhardt, Dieter Moroff)
 */
package org.umlmda.runtime.bean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.umlmda.runtime.bean.IPropertyChangeSupport;
import org.umlmda.runtime.bean.PropertyChangeSupportHelper;
import org.umlmda.runtime.bean.PropertyDescriptorProvider;

/**
 * Chain for property change notifications.
 * Fires a property change event for the derived property without old value and new value 
 * 
 * @author reinhard
 *
 */
public class NotificationChain {

	private static final Logger   logger = Logger.getLogger(NotificationChain.class);
	
	/**
	 * A PropertyChangeListener that fires a PropertyChangeEvent
	 * for the property with the derivedAttrName if the 
	 * property the listener is registered for has been changed.
	 * 
	 * NOTE: the event fired by the InnerObjectNotification did not
	 * provide the new and the old value of the property 
	 * 
	 * @author reinhard
	 *
	 */
	class InnerObjectNotification implements PropertyChangeListener, Serializable {

		private final PropertyChangeSupportHelper changeSupport;
		private final String derivedAttrName;

		public InnerObjectNotification(
				PropertyChangeSupportHelper changeSupport,
				String                      derivedAttrName) {
			super();
			this.changeSupport = changeSupport;
			this.derivedAttrName = derivedAttrName;
		}

		public void propertyChange(PropertyChangeEvent evt) {
			if (logger.isDebugEnabled()){
				logger.debug("Firering PropertyChange for property " + derivedAttrName + " instead of " + evt.getPropertyName());
			}
			fireChangeEvent();
		}
		
		public void fireChangeEvent(){
			changeSupport.firePropertyChange(derivedAttrName, null, null);
		}
	}
	
	/**
	 * creates and rebuilds an Event propagation chain over a multilevel
	 * object navigation path
	 * 
	 * @author reinhard
	 *
	 */
	class CrossObjectNotification implements PropertyChangeListener, Serializable {
		
		private final InnerObjectNotification      innerObjectNotification;
        private final String[]                     accessPath;
        private final int                          position;
        private final IPropertyChangeSupport       changeSupport;
        

		private CrossObjectNotification       childNotification = null;

		private PropertyEditor propertyEditor;
		
		
		public CrossObjectNotification(
				IPropertyChangeSupport       changeSupport,
				String[]                     accessPath, 
				int                          position,
				InnerObjectNotification      innerObjectNotification,
				boolean                      propagateOnCreation) {
			super();
			this.changeSupport           = changeSupport;
			this.accessPath              = accessPath;
			this.position                = position;
			this.innerObjectNotification = innerObjectNotification;
			
			if (isEndOfPath()){
				changeSupport.addPropertyChangeListener(accessPath[position],innerObjectNotification);
				if (propagateOnCreation){
					innerObjectNotification.fireChangeEvent();
				}
			}
			else {
				changeSupport.addPropertyChangeListener(accessPath[position],this);
				createChildNotification(propagateOnCreation);
			}	
		}

		private void createChildNotification(boolean propagateOnCreation){
			
			// find the new object 
			Object childObject = null;
			
			if (propertyEditor == null){
				try {
					PropertyDescriptor pptDesc;
					pptDesc = PropertyDescriptorProvider.getPropertyDescriptor(accessPath[position], changeSupport.getClass());
	
					propertyEditor = pptDesc.createPropertyEditor(changeSupport);
				} catch (IllegalArgumentException excp){
					logger.error("Cannot navigate baseProperty " + getPath() );
				}
			}
			
			if (propertyEditor != null){
				childObject = propertyEditor.getValue();
			}			
			
			if (childObject instanceof IPropertyChangeSupport){
				childNotification = new CrossObjectNotification((IPropertyChangeSupport)childObject,accessPath,position + 1,innerObjectNotification,propagateOnCreation);
			}
			else {
				logger.error("Cannot complete NotificationChain: BaseProperty " + getPath() + " is not a PropertyChangeSupportHelper" );
			}

		}
		
		/**
		 * concatenates the accessPath for log messages
		 * 
		 * @return accessPath concatenated up to position
		 */
		private String getPath(){
			String path = accessPath[0];
			
			for (int i = 1; i <= position; i++){
				path = path + "==>" + accessPath[i];
			}
			
			return path;
		}
		
		/**
		 * Implementation of the PropertyChangeListener Interface
		 */
		public void propertyChange(PropertyChangeEvent evt) {
			if (childNotification != null){
				childNotification.destroy();
				childNotification = null;
				createChildNotification(false);
				innerObjectNotification.fireChangeEvent();
			}
			else {
				createChildNotification(true);
			}
		}	
		
        /**
         * destroys the childNotification if it exists and removes itself from the 
         * listener list of the change support
         */
		public void destroy(){
			if (childNotification != null){
				childNotification.destroy();
			}
			
			if (isEndOfPath()){
			    changeSupport.removePropertyChangeListener(accessPath[position], innerObjectNotification);	
			}
			else {
				changeSupport.removePropertyChangeListener(accessPath[position], this);
			}
		
		}
		
		private boolean isEndOfPath(){
			return (position == (accessPath.length - 1));
		}
	}
	
	
	private final InnerObjectNotification       innerObjectNotification;
	private ArrayList<CrossObjectNotification>  childNotifications = null;
	
	/**
	 * CTor to create a NotificationChain listening on several properties
	 * within the object model
	 * 
	 * NOTE: do not use / implementation not yet finished
	 * 
	 * @param changeSupport   - propertyChangeSupport of the business object
	 * @param derivedAttrName - mane of the derived property
	 * @param baseAttrNames   - a set of navigation pathes (String[]) or property names of the business object
	 */
	@Deprecated
	public NotificationChain(PropertyChangeSupportHelper changeSupport, String derivedAttrName, Object... baseAttrNames){

		innerObjectNotification = new InnerObjectNotification (changeSupport, derivedAttrName);		
		
		for (int i = 0; i < baseAttrNames.length; i++) {
			if (baseAttrNames[i] instanceof String){
				changeSupport.addPropertyChangeListener((String)baseAttrNames[i], innerObjectNotification);
			}
			else if (baseAttrNames[i] instanceof String[]){
				if (childNotifications == null){
					childNotifications = new ArrayList<CrossObjectNotification>();
				}
				childNotifications.add(new CrossObjectNotification(changeSupport,(String[])baseAttrNames[i],0,innerObjectNotification,false));
			}
		}
	}

	/**
	 * Ctor to create a NotificationChain listening on several Properties of the object
	 * that includes the derived Property   
	 * 
	 * @param changeSupport    - property change support of the business object
	 * @param derivedAttrName  - name of the derived property
	 * @param baseAttrNames    - a set of base property names
	 */
	public NotificationChain(PropertyChangeSupportHelper changeSupport,
			                 String                      derivedAttrName, 
			                 String...                   baseAttrNames) {
		this(changeSupport, derivedAttrName, changeSupport, baseAttrNames);
	}

	
	/**
	 * Ctor to create a NotificationChain listening on several Properties of another object
	 * 
	 * @param changeSupport     - property change support of the business object
	 * @param derivedAttrName   - name of the derived property
	 * @param baseChangeSupport - another business object
	 * @param baseAttrNames     - a set of base property names of the second business object
	 */
	public NotificationChain(PropertyChangeSupportHelper changeSupport,
			                 String                      derivedAttrName,
			                 IPropertyChangeSupport      baseChangeSupport,
			                 String...                   baseAttrNames) {

		innerObjectNotification = new InnerObjectNotification(changeSupport, derivedAttrName);

		if (baseChangeSupport != null){
			for (int i = 0; i < baseAttrNames.length; i++) {
				baseChangeSupport.addPropertyChangeListener(baseAttrNames[i],
						innerObjectNotification);
			}
		}
	}

}
