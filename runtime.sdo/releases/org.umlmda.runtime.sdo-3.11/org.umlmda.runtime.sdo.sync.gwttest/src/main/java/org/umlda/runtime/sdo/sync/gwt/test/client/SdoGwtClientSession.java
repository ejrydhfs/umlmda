package org.umlda.runtime.sdo.sync.gwt.test.client;

import org.umlmda.runtime.sdo.sync.SyncServiceCallback;
import org.umlmda.runtime.sdo.sync.gwt.client.BeanEditorInvocationFactory;
import org.umlmda.runtime.sdo.sync.gwt.client.SyncServiceLocator;
import org.umlmda.runtime.sdo.sync.gwt.client.SyncServiceWrapper;
import org.umlmda.runtime.sdo.sync.impl.PlayerImpl;
import org.umlmda.runtime.sdo.sync.impl.SynchronizerImpl;
import org.umlmda.runtime.sdo.sync.test.gwt.client.model.RootClass;
import org.umlmda.runtime.sdo.sync.test.gwt.client.model.impl.TestFactoryImpl;

import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Client 'sub-session'.
 * It's meant to simulate a content of one tab in the current user interface.
 */

public class SdoGwtClientSession {
    private static final String NEW_LINE = "\n";

    private SdoGwtServiceTestEnvironment environment;
    private String name;
    private String conversationId;
    private SyncServiceWrapper syncService;
    private SynchronizerImpl synchronizer;

    private boolean conversationStarted = false;
    private boolean serverSynchronized = false;
    private boolean conversationFinished = false;

    class StartTimer extends Timer implements AsyncCallback<String> {

        @Override
        public void run() {
            //Step 1 - starts communication with the server.
            SyncServiceLocator.getInstance().startConversation(this);
            log("Starting communication with the server...");
        }

        public void onFailure(Throwable caught) {
            log("Problem: " + caught.getMessage());
            throw new RuntimeException("Couldn't get conversation id...");
        }

        public void onSuccess(String conversationId) {
            log("Got conversation id: " + conversationId);

            SdoGwtClientSession.this.conversationId = conversationId;

            StandardCallback callback = new StandardCallback();
            syncService = new SyncServiceWrapper(callback);
            synchronizer = new SynchronizerImpl(syncService);
            synchronizer.setConversationId(conversationId);

            conversationStarted = true;
            log("Conversation started...");
            new SynchronizeTimer().schedule(getRandomDelay());
        }

    }

    class SynchronizeTimer extends Timer {

        @Override
        public void run() {
            TestFactoryImpl factory = new TestFactoryImpl(synchronizer);
            synchronizer.setPlayer(new PlayerImpl(name, factory, new BeanEditorInvocationFactory()));
            RootClass root = factory.createRootClass();
            root.setRootChild(factory.createRootChild());
            root.getRootChild().serverMethod();
            log("Synchronization request sent: " + name);
        }

    }

    class FinishConversationTimer extends Timer {

        @Override
        public void run() {
            syncService.finishConversation(conversationId);
        }

    }

    class StandardCallback implements SyncServiceCallback {

        public void onException(Throwable caught) {
            StringBuffer b = new StringBuffer();
            b.append(caught.getMessage());
            for (int i = 0; i < caught.getStackTrace().length; i++) {
                StackTraceElement element = caught.getStackTrace()[i];
                b.append(element.toString());
                b.append(NEW_LINE);
            }
            log("Sync error: " + name);
            log(b.toString());
            throw new RuntimeException(caught.getMessage());
        }

        public void onSuccess() {
            if (!serverSynchronized) {
                log("Server synchronized...");
                serverSynchronized = true;
                new FinishConversationTimer().schedule(getRandomDelay());
            }

            else if (!conversationFinished) {
                log("Conversation finished");
                conversationFinished = true;
                environment.incrementFinishedCount();
            }
        }

    }

    public SdoGwtClientSession(SdoGwtServiceTestEnvironment environment, String name) {
        this.environment = environment;
        this.name = name;
    }

    public void delayedStart(int millis) {
        new StartTimer().schedule(millis);
    }

    private void log(String msg) {
        environment.log("Session [" + name + "] " + msg);
    }

    private int getRandomDelay() {
        return Random.nextInt(environment.getRunTime());
    }

}
