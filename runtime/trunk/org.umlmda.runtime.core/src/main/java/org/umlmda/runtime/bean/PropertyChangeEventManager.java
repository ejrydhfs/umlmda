package org.umlmda.runtime.bean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Manager for {@link PropertyChangeEvent}s, enable queuing of events.
 * 
 * @author Dieter Moroff (26.06.2008)
 */
public class PropertyChangeEventManager
{

   public static final PropertyChangeEventManager INSTANCE = new PropertyChangeEventManager();
   private boolean                                queuing  = false;
   private List<QueueEntry>                       queue    = new ArrayList<QueueEntry>();

   /**
    * Start queuing of events until {@link #finishQueuing()} is called.
    * 
    * @return <code>true</code> if the queue was switched on (was off before), <code>false</code> if the queuing was already
    *         switched on.
    */
   synchronized public boolean startQueuing() {
      if ( queuing ) {
         return false;
      }
      else {
         queuing = true;
         return true;
      }
   }

   synchronized public void finishQueuing() {
      queuing = false;

      // Use all events from queue and notify the listeners
      for ( Iterator<QueueEntry> iqe = queue.iterator(); iqe.hasNext(); ) {
         QueueEntry entry = (QueueEntry) iqe.next();

         notifyListeners(entry.listener, entry.evt);
         iqe.remove();
      }
   }

   synchronized public void firePropertyChange(PropertyChangeListener[] listener, PropertyChangeEvent evt) {
      if ( !queuing ) {
         notifyListeners(listener, evt);
      }

      // Use all events from queue and notify the listeners
      else {
         queue.add(new QueueEntry(listener, evt));
      }
   }

   private void notifyListeners(PropertyChangeListener[] listener, PropertyChangeEvent evt) {
      for ( int i = 0; i < listener.length; i++ ) {
         PropertyChangeListener propertyChangeListener = listener[i];

         propertyChangeListener.propertyChange(evt);
      }
   }

   private static class QueueEntry
   {
      final PropertyChangeListener[] listener;
      final PropertyChangeEvent      evt;

      public QueueEntry(PropertyChangeListener[] listener, PropertyChangeEvent evt) {
         this.listener = listener;
         this.evt = evt;
      }

   }
}
