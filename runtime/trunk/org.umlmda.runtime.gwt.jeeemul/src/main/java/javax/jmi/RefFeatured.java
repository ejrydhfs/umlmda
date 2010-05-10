package javax.jmi;

import java.util.List;

public interface RefFeatured extends RefBaseObject
{
   void refSetValue(RefObject feature, Object value);

   void refSetValue(String featureName, Object value);

   Object refGetValue(RefObject feature);

   Object refGetValue(String featureName);

   Object refInvokeOperation(RefObject requestedOperation, List args) throws RefException;

   Object refInvokeOperation(String requestedOperation, List args) throws RefException;
}
