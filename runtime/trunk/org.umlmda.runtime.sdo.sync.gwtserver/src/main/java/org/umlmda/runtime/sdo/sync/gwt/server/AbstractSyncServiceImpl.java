package org.umlmda.runtime.sdo.sync.gwt.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.umlmda.runtime.reflect.ReflectionInvocationFactory;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectFactory;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;
import org.umlmda.runtime.sdo.sync.entries.VoidInvocationResult;
import org.umlmda.runtime.sdo.sync.gwt.client.SyncService;
import org.umlmda.runtime.sdo.sync.impl.PlayerImpl;
import org.umlmda.runtime.sdo.sync.impl.SynchronizerImpl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public abstract class AbstractSyncServiceImpl extends RemoteServiceServlet implements SyncService {
   public static final String SESSION_ATTR_SDO_PLAYER = "SDOPlayer";
   public static final String SESSION_ATTR_SDO_RECORDER = "SDORecorder";

   static Logger logger = Logger.getLogger(AbstractSyncServiceImpl.class);

   private static final long serialVersionUID = 100L;


   public AbstractSyncServiceImpl() {
   }

   public abstract SynchronizedObjectFactory createRootFactory(Recorder recorder);

   @Override
   public void destroy() {
      // TODO Auto-generated method stub
      super.destroy();
   }

   @Override
   public void init() throws ServletException {
      super.init();
   }

   @Override
   public ServletContext getServletContext() {
      ServletContext servletContext = super.getServletContext();

      if (servletContext.getAttribute(SESSION_ATTR_SDO_PLAYER) == null) {
         SynchronizerImpl recorder = new SynchronizerImpl(null);
         SynchronizedObjectFactory factory = createRootFactory(recorder); 
         Player player = new PlayerImpl(Player.SERVER, factory, new ReflectionInvocationFactory());

         recorder.setPlayer(player);
         servletContext.setAttribute(SESSION_ATTR_SDO_PLAYER, player);
         servletContext.setAttribute(SESSION_ATTR_SDO_RECORDER, recorder);
      }
      return servletContext;
   }

   private Player getPlayer() {
      return (Player) getServletContext().getAttribute(SESSION_ATTR_SDO_PLAYER);
   }

   private Recorder getRecorder() {
      return (Recorder) getServletContext().getAttribute(SESSION_ATTR_SDO_RECORDER);
   }

   public void startConversation() {
      logger.info("startConversation()");

      getPlayer().reset();
      getRecorder().reset();
   }
   
   public void finishConversation() {
      logger.info("finishConversation()");

      getPlayer().reset();
      getRecorder().reset();
   }
   
   /**
    * Server side implementation of the SyncService
    */
   public List<AbstractChangeLogEntry> synchronizeChanges(List<AbstractChangeLogEntry> changes) {
      logger.info("synchronizeChanges()");

      try {
         if ( logger.isDebugEnabled() ) {
            logger.debug("Changes to synchronize");
            for (AbstractChangeLogEntry entry : changes) {
               logger.debug(entry);
            }
         }
         
         Player player = getPlayer();
         SynchronizedObjectFactory factory = player.getObjectFactory();

         // Reset recorder
         Recorder slaveRecorder = factory.getRecorder();
         
         slaveRecorder.getChangeEntries().clear();

         // Put recorder to thread local to be accessible in subsequent functions
         // TODO can be removed, because recorder is singleton for session
         SyncContext.recorderHolder.set(slaveRecorder);
         
         player.playback(changes, null);
         
         // Remove changes from input
         slaveRecorder.getChangeEntries().removeAll(changes);

         if ( logger.isDebugEnabled() ) {
            logger.debug("Changes to send back from synchonize");
            for (AbstractChangeLogEntry entry : slaveRecorder.getChangeEntries()) {
               logger.debug(entry);
            }
         }

         
         return slaveRecorder.getChangeEntries();
      } catch (RuntimeException e) {
         logger.error(e.getMessage(), e);
         throw e;
      } catch (Throwable e) {
         logger.fatal(e.getMessage(), e);
         throw new RuntimeException(e);
      }
   }

   public AbstractInvocationResult invokeMethod(SynchronizedObjectProxy objectProxy, String methodName) {
      try {
         Player player = getPlayer();
         SynchronizedObjectFactory factory = player.getObjectFactory();

         // Reset recorder
         Recorder slaveRecorder = factory.getRecorder();
         
         slaveRecorder.getChangeEntries().clear();
         
         SynchronizedObject object = player.getObject(objectProxy);
         AbstractInvocationResult result = null;

         if ( logger.isDebugEnabled() ) {
            logger.debug("invoke method "+methodName+" on "+object.getClass());
         }
         
         // Put recorder to thread local to be accessible in subsequent functions
         SyncContext.recorderHolder.set(slaveRecorder);
         
         try {
            Method method = object.getClass().getMethod(methodName, new Class<?>[] {});

            method.invoke(object);
            
            if ( logger.isDebugEnabled() ) {
               logger.debug("Changes to send back from invoke");
               for (AbstractChangeLogEntry entry : slaveRecorder.getChangeEntries()) {
                  logger.debug(entry);
               }
            }
            
            result = new VoidInvocationResult(slaveRecorder.getChangeEntries());
         } catch (SecurityException e) {
            result = handleException(e);
         } catch (NoSuchMethodException e) {
            result = handleException(e);
         } catch (IllegalArgumentException e) {
            result = handleException(e);
         } catch (IllegalAccessException e) {
            result = handleException(e);
         } catch (InvocationTargetException e) {
            result = handleException(e);
         }

         return result;
      } catch (RuntimeException e) {
         logger.error(e.getMessage(), e);
         throw e;
      }
   }

   private AbstractInvocationResult handleException(Throwable e) {
      AbstractInvocationResult result;
      logger.error(e.getMessage(), e);
      result = new VoidInvocationResult(e.getMessage(), e.getStackTrace().toString());
      return result;
   }

}
