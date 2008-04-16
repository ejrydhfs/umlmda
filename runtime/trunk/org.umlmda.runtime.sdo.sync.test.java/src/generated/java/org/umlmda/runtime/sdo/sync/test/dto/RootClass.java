package org.umlmda.runtime.sdo.sync.test.dto;

/**
 * 
 */
public interface RootClass extends java.io.Serializable {
   public static final String PROPERTY_ROOT_CHILD    = "rootChild";    ;
   public static final String PROPERTY_ROOT_CHILDREN = "rootChildren"; ;

   /**
    * 
    */
   public RootChild getRootChild();

   /**
    * 
    *
    * @param rootChild
    *		New value for assocation rootChild 
    */
   public void setRootChild(RootChild rootChild);

   /**
    * 
    */
   public java.util.List getRootChildren();

   /**
    * 
    *
    * @param rootChildren
    *		New value for assocation rootChildren 
    */
   public void setRootChildren(java.util.List rootChildren);
}
