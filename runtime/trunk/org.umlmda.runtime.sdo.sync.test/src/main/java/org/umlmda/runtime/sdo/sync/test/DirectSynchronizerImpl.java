package org.umlmda.runtime.sdo.sync.test;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.umlmda.runtime.bean.BeanInvocation;
import org.umlmda.runtime.reflect.ReflectionInvocationFactory;
import org.umlmda.runtime.sdo.sync.MasterFactory;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;
import org.umlmda.runtime.sdo.sync.gwt.client.BeanEditorInvocationFactory;
import org.umlmda.runtime.sdo.sync.gwt.server.SyncContext;
import org.umlmda.runtime.sdo.sync.impl.PlayerImpl;
import org.umlmda.runtime.sdo.sync.impl.SynchronizerImpl;

public class DirectSynchronizerImpl extends SynchronizerImpl
{
   public interface FactoryBuilder {
      MasterFactory createFactory(Recorder recorder);
   }
   
   private final Player serverModelPlayer;
   private final SynchronizerImpl serverModelRecorder;
   private final Player clientModelPlayer;
   private final Logger logger = Logger.getLogger(DirectSynchronizerImpl.class);
   private final BeanInvocation.Factory serverModelInvocationFactory; 
   private final BeanInvocation.Factory clientModelInvocationFactory;   

   public DirectSynchronizerImpl(FactoryBuilder clientFactoryBuilder, FactoryBuilder serverFactoryBuilder) {
      super(null);
      serverModelInvocationFactory = new ReflectionInvocationFactory();
      clientModelInvocationFactory = new BeanEditorInvocationFactory();
      serverModelRecorder = new SynchronizerImpl(null); 
      serverModelPlayer = new PlayerImpl(Player.SERVER, serverFactoryBuilder.createFactory(serverModelRecorder), serverModelInvocationFactory);
      clientModelPlayer = new PlayerImpl(Player.CLIENT, clientFactoryBuilder.createFactory(this), clientModelInvocationFactory);

      serverModelRecorder.setPlayer(serverModelPlayer);
      setPlayer(clientModelPlayer);
   }

   @Override
   public synchronized void recordInvoke(SynchronizedObject objectProxy, String methodName) {
      List<AbstractChangeLogEntry> changeEntries = getChangeEntries();
      
      if ( logger.isDebugEnabled() ) {
         logger.debug("About to invoke "+methodName+" push "+changeEntries.size()+" changes to remote peer");
         logEntries(changeEntries);
      }
      
      // Write pending changes to server model
      if ( changeEntries.size() > 0 ) {
         SyncContext.recorderHolder.set(serverModelRecorder);
         serverModelPlayer.playback(changeEntries, null);
         
         // Remove entries from playback
         serverModelRecorder.getChangeEntries().removeAll(changeEntries);
      }
      
      // Empty up own recording
      reset();
      
      // Replay stuff from server to client if necesary
      if ( serverModelRecorder.getChangeEntries().size() > 0 ) {
         SyncContext.recorderHolder.set(this);
         clientModelPlayer.playback(serverModelRecorder.getChangeEntries(), null);
         
         // Remove entries from playback
         getChangeEntries().removeAll(serverModelRecorder.getChangeEntries());
      }

      // Call the method
      // Reset server recorder
      serverModelRecorder.reset();
      
      SynchronizedObject object = serverModelPlayer.getObjectById(objectProxy.getRecordObjectId());
      AbstractInvocationResult result = null;

      if ( logger.isDebugEnabled() ) {
         logger.debug("invoke method "+methodName+" on "+object.getClass());
      }
      
      // Put recorder to thread local to be accessible in subsequent functions
      SyncContext.recorderHolder.set(serverModelRecorder);
      
      try {
         Method method = object.getClass().getMethod(methodName, new Class<?>[] {});

         method.invoke(object);
         
         if ( logger.isDebugEnabled() ) {
            logger.debug(serverModelRecorder.getChangeEntries().size()+ " changes to send back from invoke");
            logEntries(serverModelRecorder.getChangeEntries());
         }
         
      } catch (SecurityException e) {
         logger.error(e.getMessage(), e);
         throw new RuntimeException(e);
      } catch (NoSuchMethodException e) {
         logger.error(e.getMessage(), e);
         throw new RuntimeException(e);
      } catch (IllegalArgumentException e) {
         logger.error(e.getMessage(), e);
         throw new RuntimeException(e);
      } catch (IllegalAccessException e) {
         logger.error(e.getMessage(), e);
         throw new RuntimeException(e);
      } catch (InvocationTargetException e) {
         logger.error(e.getMessage(), e);
         throw new RuntimeException(e);
      }

      // Give results back to client model
      if ( serverModelRecorder.getChangeEntries().size() > 0 ) {
         SyncContext.recorderHolder.set(this);
         clientModelPlayer.playback(serverModelRecorder.getChangeEntries(), null);

         // Remove entries from playback
         getChangeEntries().removeAll(serverModelRecorder.getChangeEntries());
         
         serverModelRecorder.reset();
      }
   }

   private void logEntries(List<AbstractChangeLogEntry> changeEntries) {
      int index = 1, count = changeEntries.size();
      for (AbstractChangeLogEntry entry : changeEntries) {
         logger.debug("("+index+++"/"+count+"): "+entry);
      }
   }
   
}
