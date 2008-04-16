package org.umlmda.runtime.sdo.sync.test.dto;

/**
 * 
 */
public interface RootChild extends java.io.Serializable {
   public static final String PROPERTY_GREAT_CHILDREN = "greatChildren"; ;

   /**
    * 
    */
   public RootGreatChildren getGreatChildren();

   /**
    * 
    *
    * @param greatChildren
    *		New value for assocation greatChildren 
    */
   public void setGreatChildren(RootGreatChildren greatChildren);

   /**
    * 
    */
   public void serverMethod();
}
