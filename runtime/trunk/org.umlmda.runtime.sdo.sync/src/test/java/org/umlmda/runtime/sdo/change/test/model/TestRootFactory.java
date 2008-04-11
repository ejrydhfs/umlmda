package org.umlmda.runtime.sdo.change.test.model;

import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectFactory;
import org.umlmda.runtime.sdo.sync.Synchronizer;

public class TestRootFactory implements SynchronizedObjectFactory {

   private final Synchronizer recorder;

   public TestRootFactory(Synchronizer recorder) {
      this.recorder = recorder;
   }

   public SynchronizedObject create(String className) {
      
      if ( RootClass.class.getName().equals(className)) {
         return new RootClass(recorder);
      }
      else if ( RootChild.class.getName().equals(className)) {
         return new RootChild(recorder);
      }
      else if ( RootChildren.class.getName().equals(className)) {
         return new RootChildren(recorder);
      }
      else if ( RootGreatChildren.class.getName().equals(className)) {
         return new RootGreatChildren(recorder);
      }
      else {
         throw new IllegalArgumentException(className);
      }
   }

}
