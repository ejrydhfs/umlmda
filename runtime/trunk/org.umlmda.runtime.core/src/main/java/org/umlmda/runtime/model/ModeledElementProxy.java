package org.umlmda.runtime.model;

import java.io.Serializable;



// TODO Change name, not a proxy
public class ModeledElementProxy implements ModeledElement, Serializable {

   private static final long serialVersionUID = 100L;
   private String modelName;
   private String modelVersion;

   public ModeledElementProxy() {
   }
   
   public ModeledElementProxy(ModeledElement element) {
      modelName = element.getModelName();
      modelVersion = element.getModelVersion();
   }
   
   public String getModelName() {
      return modelName;
   }

   public String getModelVersion() {
      return modelVersion;
   }
   
   @Override
   public boolean equals(Object obj) {
      
      boolean bReturn = false;
      
      if (obj instanceof ModeledElementProxy){
         
         ModeledElementProxy proxy = (ModeledElementProxy) obj;
   
         bReturn = isSameString(modelName, proxy.getModelName())
            && isSameString(modelVersion, proxy.getModelVersion());
            
      }
      
      return bReturn;
         
   }  
   
   private boolean isSameString(String str, String strComp){
      if (str == null && strComp == null)
         return true;
      else
         return str.equals(strComp);
   }
   
}
