package java.beans;

import java.util.EventListener;

/**
 * base class to implement the PropertyChangeListenerProxy.
 * 
 * the class has been copied from java.util.EventListenerProxy 
 * to avoid difficulties caused by creating our own java-util-gwt-modul
 * Therefore the scope is not public.
 * 
 * @author reinhard
 *
 */
class EventListenerProxy implements EventListener {

	private EventListener listener;

	public EventListener getListener() {
		return listener;
	}

	public EventListenerProxy(EventListener listener) {
		super();
		this.listener = listener;
	} 
	
}
