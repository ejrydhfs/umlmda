package org.umlmda.runtime.sdo.sync;

import org.umlmda.runtime.model.ModeledElement;

public interface SynchronizedObject extends ModeledElement
{

   /**
    * Set the record object id. Only the Recorder should call this method, never call in application code!
    * 
    * @param recordObjectId
    */
   void setRecordObjectId(int recordObjectId);

   int getRecordObjectId();

   Recorder getRecorder();

}
