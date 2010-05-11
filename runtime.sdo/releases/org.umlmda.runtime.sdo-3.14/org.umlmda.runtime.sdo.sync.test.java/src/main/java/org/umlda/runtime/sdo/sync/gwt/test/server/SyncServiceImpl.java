package org.umlda.runtime.sdo.sync.gwt.test.server;

import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectFactory;
import org.umlmda.runtime.sdo.sync.gwt.server.AbstractSyncServiceImpl;
import org.umlmda.runtime.sdo.sync.test.model.impl.TestFactoryImpl;

public class SyncServiceImpl extends AbstractSyncServiceImpl {

   /**
    *
    */
   private static final long serialVersionUID = 100L;

   public SyncServiceImpl() {
      // TODO Auto-generated constructor stub
   }

   @Override
   public SynchronizedObjectFactory createRootFactory(Recorder recorder) {
      return new TestFactoryImpl(recorder);
   }

}
