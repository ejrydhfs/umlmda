package org.umlmda.runtime.sdo.sync.gwt.server;

import org.umlmda.runtime.sdo.sync.Recorder;

public class SyncContext {

   public static ThreadLocal<Recorder> recorderHolder = new ThreadLocal<Recorder>();
   
}
