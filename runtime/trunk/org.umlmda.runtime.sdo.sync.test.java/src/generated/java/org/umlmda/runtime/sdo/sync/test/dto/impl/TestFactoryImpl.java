package org.umlmda.runtime.sdo.sync.test.dto.impl;

import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectFactory;

import org.umlmda.runtime.sdo.sync.test.dto.RootChild;
import org.umlmda.runtime.sdo.sync.test.dto.RootChildren;
import org.umlmda.runtime.sdo.sync.test.dto.RootClass;
import org.umlmda.runtime.sdo.sync.test.dto.RootGreatChildren;
import org.umlmda.runtime.sdo.sync.test.dto.TestFactory;

/**
 * Business object factory implementation for org.umlmda.runtime.sdo.sync.test. 
 */
public class TestFactoryImpl implements TestFactory, SynchronizedObjectFactory {
   private final Recorder recorder;

   /**
    * Ctor with SDO recorder
    */
   public TestFactoryImpl(Recorder recorder) {
      this.recorder = recorder;
   }

   /**
    * Create Businessservice implementation for org.umlmda.runtime.sdo.sync.test.dto.RootChild.
    */
   public org.umlmda.runtime.sdo.sync.test.dto.RootChild createRootChild() {
      return new RootChildImpl(recorder);
   }

   /**
    * Create Businessservice implementation for RootChildren.
    */
   public RootChildren createRootChildren() {
      return new RootChildrenImpl(recorder);
   }

   /**
    * Create Businessservice implementation for RootClass.
    */
   public RootClass createRootClass() {
      return new RootClassImpl(recorder);
   }

   /**
    * Create Businessservice implementation for RootGreatChildren.
    */
   public RootGreatChildren createRootGreatChildren() {
      return new RootGreatChildrenImpl(recorder);
   }

   public SynchronizedObject create(String className) {
      if (RootChildImpl.class.getName().equals(className)) {
         return (SynchronizedObject) createRootChild();
      }
      else if (RootChildrenImpl.class.getName().equals(className)) {
         return (SynchronizedObject) createRootChildren();
      }
      else if (RootClassImpl.class.getName().equals(className)) {
         return (SynchronizedObject) createRootClass();
      }
      else if (RootGreatChildrenImpl.class.getName().equals(className)) {
         return (SynchronizedObject) createRootGreatChildren();
      }
      else {
         throw new IllegalArgumentException(className);
      }
   }
}
