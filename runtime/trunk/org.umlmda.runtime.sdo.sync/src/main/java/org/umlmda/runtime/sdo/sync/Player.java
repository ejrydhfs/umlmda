package org.umlmda.runtime.sdo.sync;

import java.util.List;

import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;

/**
 * Interface fur the playback part of synchonizer. 
 * @author Dieter Moroff (11.4.2008)
 *
 */
public interface Player {
   
   /**
    * Starts the playback with a given change recording.
    * @param changeEntries
    * @param rootObject
    * @return
    */
   SynchronizedObject playback(List<AbstractChangeLogEntry> changeEntries, SynchronizedObject rootObject);
}
