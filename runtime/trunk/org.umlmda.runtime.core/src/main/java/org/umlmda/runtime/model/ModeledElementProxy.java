package org.umlmda.runtime.model;

import java.io.Serializable;

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

}
