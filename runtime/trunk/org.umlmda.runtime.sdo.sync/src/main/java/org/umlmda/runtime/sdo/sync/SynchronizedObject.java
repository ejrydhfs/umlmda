package org.umlmda.runtime.sdo.sync;

public interface SynchronizedObject {

   /**
    * Set the record object id. Only the Recorder should call this method, never call in
    * application code!
    * 
    * @param recordObjectId
    */
   void setRecordObjectId(int recordObjectId);

   int getRecordObjectId();

}
