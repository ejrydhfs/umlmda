package org.umlmda.runtime.sdo.change.test.model;

import org.umlmda.runtime.bean.PropertyDescriptorProvider;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectFactory;
import org.umlmda.runtime.sdo.sync.Recorder;

public class TestRootFactory implements SynchronizedObjectFactory {

   static {
      PropertyDescriptorProvider.registerDescriptor(RootChildren.class, RootChildrenClass.INSTANCE);
   }
   
   private final Recorder recorder;

   public TestRootFactory(Recorder recorder) {
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
