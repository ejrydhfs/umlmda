package org.umlmda.runtime.sdo.sync.entries;

public class InvokeEntry extends AbstractChangeLogEntry
{
   private static final long serialVersionUID = 1L;
   private String methodName;
   private Object[] transferParameters;

   public InvokeEntry(int recordId, String methodName, Object transferParameters[]) {
      super(recordId);
      this.methodName = methodName;
      this.transferParameters = transferParameters != null ? transferParameters : new Object[0];
   }

   public InvokeEntry() {
      super();
   }

   @Override
   public String toString() {
      return "InvokeEntry: ROID="+getRecordId()+" method=\""+methodName+"\"";
   }

   @Override
   public boolean equals(Object obj) {
      boolean equals = false;
      
      if ( super.equals(obj) ) {
         if ( obj instanceof InvokeEntry ) {
            InvokeEntry otherInvokeEntry = (InvokeEntry) obj;
            
            // Check name and parameter count
            equals =  methodName.equals(otherInvokeEntry.methodName)
                   && transferParameters.length == otherInvokeEntry.transferParameters.length;
            
            // Check parameter content
            if ( equals ) {
               
               for ( int i = 0; equals && i < transferParameters.length; i++ ) {
                  equals = transferParameters[i].equals(otherInvokeEntry.transferParameters[i]);
               }
            }
         }
      }
      
      return equals;
   }

   public String getMethodName() {
      return methodName;
   }

   public Object[] getTransferParameters() {
      return transferParameters;
   }
}
