package org.umlmda.runtime.sdo.sync.gwt.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.umlmda.runtime.reflect.ReflectionInvocationFactory;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.SyncSession;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectFactory;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;
import org.umlmda.runtime.sdo.sync.entries.VoidInvocationResult;
import org.umlmda.runtime.sdo.sync.gwt.client.SyncService;
import org.umlmda.runtime.sdo.sync.impl.PlayerImpl;
import org.umlmda.runtime.sdo.sync.impl.SynchronizerImpl;
import org.umlmda.runtime.sdo.sync.parameter.AbstractParameter;
import org.umlmda.runtime.sdo.sync.parameter.ParameterUtil;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public abstract class AbstractSyncServiceImpl extends RemoteServiceServlet implements SyncService {
    private static final long serialVersionUID = 100L;
    private static final String SESSION_ATTR_SYNC_SESSIONS = "SyncSessions";
    private static Logger logger = Logger.getLogger(AbstractSyncServiceImpl.class);

    public AbstractSyncServiceImpl() {
    }

    public abstract SynchronizedObjectFactory createRootFactory(Recorder recorder);

    private SyncSession getSyncSession(String syncSessionId) {
        if (isDebugEnabled()) {
            debug("getSyncSession(" + syncSessionId + ")");
        }

        HttpSession httpSession = getHttpSession();
        Map<String, SyncSession> syncSessions = getSyncSessions(httpSession);
        if (syncSessions == null) {
            debug("No sync sessions map found...");
            return null;
        }
        return syncSessions.get(syncSessionId);
    }

    @SuppressWarnings("unchecked")
    private Map<String, SyncSession> getSyncSessions(HttpSession httpSession) {
        return (Map<String, SyncSession>) httpSession.getAttribute(SESSION_ATTR_SYNC_SESSIONS);
    }

    private HttpSession createHttpSession() {
        HttpSession session = getThreadLocalRequest().getSession(false);
        if (session == null) {
            session = getThreadLocalRequest().getSession(true);
            logger.info("Creating new session with id " + session.getId());
        } else {
            logger.info("Using existing session with id " + session.getId());
        }
        return session;
    }

    private HttpSession getHttpSession() {
        HttpSession httpSession = getThreadLocalRequest().getSession(false);
        if (httpSession == null) {
            debug("No http session found...");
            throw new IllegalArgumentException("No http session found");
        } else {
            debug("Http session found: " + httpSession.getId());
        }
        return httpSession;
    }

    public String startConversation() {
        String conversationId = getConversationId();

        debug("startConversation(" + conversationId + ")");
        HttpSession httpSession = createHttpSession();
        Map<String, SyncSession> syncSessions =(Map<String, SyncSession>) httpSession.getAttribute(SESSION_ATTR_SYNC_SESSIONS);
        if (syncSessions == null) {
            debug("Creating new map for session " + httpSession.getId());
            syncSessions = new HashMap<String, SyncSession>();
            httpSession.setAttribute(SESSION_ATTR_SYNC_SESSIONS, syncSessions);
        }

        SynchronizerImpl recorder = new SynchronizerImpl(null);
        recorder.setConversationId(conversationId);
        SynchronizedObjectFactory factory = createRootFactory(recorder);
        Player player = new PlayerImpl(Player.SERVER, factory, new ReflectionInvocationFactory());
        recorder.setPlayer(player);
        SyncSession syncSession = new SyncSessionImpl(player);

        factory = player.getObjectFactory();
        Recorder slaveRecorder = factory.getRecorder();
        debug("Slave recorder: " + slaveRecorder);

        if (syncSessions.containsKey(conversationId)) {
            info("This conversation id is already bound...");
        }
        syncSessions.put(conversationId, syncSession);

        return conversationId;
    }

    private String getConversationId() {
        debug("getConversationId()");
        String conversationId = ConversationIds.getInstance().getNext();
        debug("Next conversation id is " + conversationId);
        return conversationId;
    }

    public void finishConversation(String conversationId) {
        logger.info("finishConversation(" + conversationId + ")");

        HttpSession httpSession = getHttpSession();
        Map<String, SyncSession> syncSessions = getSyncSessions(httpSession);
        if (syncSessions == null) {
            debug("No sync sessions map found...");
        }
        SyncSession syncSession = syncSessions.get(conversationId);
        if (syncSession == null) {
            logger.info("No sync session found...");
            return;
        }

        syncSession.getPlayer().reset();
        syncSession.getRecorder().reset();

        syncSessions.remove(conversationId);
    }

    /**
     * Server side implementation of the SyncService
     */
    public List<AbstractChangeLogEntry> synchronizeChanges(String conversationId, List<AbstractChangeLogEntry> changes) {
        logger.info("synchronizeChanges(" + conversationId + ")");

        try {
            SyncSession syncSession = getSyncSession(conversationId);
            if (syncSession == null) {
                logger.error("No sync session found...");
                throw new IllegalArgumentException("No sync session found...");
            }

            Player player = syncSession.getPlayer();

            if (isDebugEnabled()) {
                debug("Player " + player + " - changes to synchronize");
                for (AbstractChangeLogEntry entry : changes) {
                    debug(entry);
                }
            }

            SynchronizedObjectFactory factory = player.getObjectFactory();

            // Reset recorder
            Recorder slaveRecorder = factory.getRecorder();

            debug("Slave recorder: " + slaveRecorder);
            debug("Change entries: " + ((slaveRecorder == null) ? null : slaveRecorder.getChangeEntries()));
            slaveRecorder.getChangeEntries().clear();

            // Put recorder to thread local to be accessible in subsequent
            // functions
            // TODO can be removed, because recorder is singleton for session
            SyncContext.recorderHolder.set(slaveRecorder);

            player.playback(changes, null);

            // Remove changes from input
            slaveRecorder.getChangeEntries().removeAll(changes);

            if (isDebugEnabled()) {
                debug("Changes to send back from synchronize");
                for (AbstractChangeLogEntry entry : slaveRecorder.getChangeEntries()) {
                    debug(entry);
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

    public AbstractInvocationResult invokeMethod(String conversationId, SynchronizedObjectProxy objectProxy, String methodName,
                    List<AbstractParameter> parameters) {
        try {
            logger.info("invokeMethod(" + conversationId + ")");

            SyncSession syncSession = getSyncSession(conversationId);
            if (syncSession == null) {
                logger.error("No sync session found...");
                throw new IllegalArgumentException("No sync session found...");
            }
            Player player = syncSession.getPlayer();
            SynchronizedObjectFactory factory = player.getObjectFactory();

            // Reset recorder
            Recorder slaveRecorder = factory.getRecorder();
            slaveRecorder.getChangeEntries().clear();

            SynchronizedObject object = player.getObject(objectProxy);
            if (isDebugEnabled()) {
                debug("Invoke method: " + methodName + " on " + object.getClass() + " - " + object.toString());
            }

            // Put recorder to thread local to be accessible in subsequent
            // functions
            SyncContext.recorderHolder.set(slaveRecorder);

            AbstractInvocationResult result = null;
            try {
                Object parameterArray[] = ParameterUtil.toArray(parameters, player);
                Method method = MethodUtils.findMatchingMethod(object.getClass(), methodName, parameterArray);

                method.invoke(object, parameterArray);

                if (isDebugEnabled()) {
                    debug("Changes to send back from invoke");
                    for (AbstractChangeLogEntry entry : slaveRecorder.getChangeEntries()) {
                        debug(entry);
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
        logger.error(e.getMessage(), e);
        return new VoidInvocationResult(e.getMessage(), e.getStackTrace().toString());
    }

    private final boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    private final void debug(Object msg) {
        logger.debug(msg);
    }

    private final void info(Object msg) {
        logger.info(msg);
    }

}
