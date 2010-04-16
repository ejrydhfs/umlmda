package org.umlmda.runtime.reflect;

public class SampleBean
{
   @SuppressWarnings("unused")
   private String privateField;
   
   @SuppressWarnings("unused")
   private final String privateFinalField = null;

   public String getPrivateField() {
      return privateField;
   }

   public String getPrivateFinalField() {
      return privateFinalField;
   }
   
   
}
