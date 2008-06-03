package org.umlmda.runtime.sdo.sync.entries;

import org.umlmda.runtime.model.ModeledElement;
import org.umlmda.runtime.model.ModeledElementProxy;

/*
 * Change entry for new instances
 */
public class NewEntry extends AbstractChangeLogEntry {

   private static final long serialVersionUID = 100L;
   private ModeledElementProxy elementProxy;
   
   /**
    * Ctor required for serialization/deserialization
    */
   public NewEntry() {
   }

   @SuppressWarnings("unchecked")
   public NewEntry(int recordedObjectId, ModeledElement modeledElement) {
      super(recordedObjectId);
      elementProxy = new ModeledElementProxy(modeledElement);
   }

   public ModeledElementProxy getElementProxy() {
      return elementProxy;
   }
   
   @Override
   public String toString() {
      return "NewEntry: ROID="+getRecordId()+" element="+elementProxy.getModelName()+" version="+elementProxy.getModelVersion();
   }
   

   @Override
   public boolean equals(Object obj) {
      
      boolean bReturn = false;
      
      if (obj instanceof NewEntry){
         
         NewEntry entry = (NewEntry) obj;
         
         if (super.equals(obj)){
            bReturn = elementProxy.equals(entry.getElementProxy());
         }
      }
      
      return bReturn;
         
   }  

}
