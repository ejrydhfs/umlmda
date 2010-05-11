package org.umlmda.runtime.sdo.sync.gwt.server;

import org.apache.log4j.Logger;


/**
 * Generates unique conversation ids. The format is generally not specified.
 */

public abstract class ConversationIds {
    private static ConversationIds INSTANCE;

    public static synchronized ConversationIds getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        String systemParam = System.getProperty(ConversationIds.class.getName());
        if (systemParam != null) {
            try {
                INSTANCE = (ConversationIds) Class.forName(systemParam).newInstance();
                Logger.getLogger(ConversationIds.class).info("Using custom conversation ids: " + systemParam);
            }
            catch (Exception e) {
                Logger.getLogger(ConversationIds.class).error(e.getMessage(), e);
            }
        }
        if (INSTANCE == null) {
            Logger.getLogger(ConversationIds.class).info("Using standard conversation ids...");
            INSTANCE = new StandardConversationIds();
        }
        return INSTANCE;
    }

    /**
     * Returns the next unique conversation id.
     */

    public abstract String getNext();

    /**
     * Releases a used conversation id. A generator may (or may not) use it in the future.
     *
     * @param id conversation id to release
     */

    public abstract void release(String id);

}
