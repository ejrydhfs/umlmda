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


/**
 * Chain for property change notifications.
 * Fires a property change event for the derived property without old value and new value 
 * 
 * @author reinhard
 *
 */
public class NotificationChain implements PropertyChangeListener{
	private final String derivedAttrName;
	private final PropertyChangeSupportHelper changeSupport;
	
	public NotificationChain(PropertyChangeSupportHelper changeSupport, String derivedAttrName, String... baseAttrNames){
		this.derivedAttrName = derivedAttrName;
		this.changeSupport   = changeSupport;
		
		for (int i = 0; i < baseAttrNames.length; i++) {
			changeSupport.addPropertyChangeListener(baseAttrNames[i], this);
		}
	}

	/**
	 * Fires a property change event for the derived property without old value and new value 
	 * instead of the catched event
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		changeSupport.firePropertyChange(derivedAttrName, null, null);
	}
	
}
