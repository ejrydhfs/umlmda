package org.umlmda.runtime.sdo.sync.test.dto;

/**
 * 
 */
public interface RootChildren extends java.io.Serializable {
   public static final String PROPERTY_STRING_ATTR         = "stringAttr";
   public static final String PROPERTY_ROOT_GREAT_CHILDREN = "rootGreatChildren"; ;

   /**
    * Get stringAttr, 
    */
   public String getStringAttr();

   /**
    * Set stringAttr, 
    */
   public void setStringAttr(String stringAttr);

   /**
    * 
    */
   public java.util.Set getRootGreatChildren();

   /**
    * 
    *
    * @param rootGreatChildren
    *		New value for assocation rootGreatChildren 
    */
   public void setRootGreatChildren(java.util.Set rootGreatChildren);
}
