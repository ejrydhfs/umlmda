package org.umlmda.runtime.sdo.sync.test.dto;

/**
 * Business object factory interface for org.umlmda.runtime.sdo.sync.test. 
 */
public interface TestFactory {
   /**
    * Create Businessservice implementation for RootChild.
    */
   public RootChild createRootChild();

   /**
    * Create Businessservice implementation for RootChildren.
    */
   public RootChildren createRootChildren();

   /**
    * Create Businessservice implementation for RootClass.
    */
   public RootClass createRootClass();

   /**
    * Create Businessservice implementation for RootGreatChildren.
    */
   public RootGreatChildren createRootGreatChildren();
}
