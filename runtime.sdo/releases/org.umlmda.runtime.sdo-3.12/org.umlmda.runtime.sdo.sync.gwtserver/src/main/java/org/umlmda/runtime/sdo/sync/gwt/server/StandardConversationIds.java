package org.umlmda.runtime.sdo.sync.gwt.server;


/**
 * Generates unique conversation ids as a simple number sequence starting from 1.
 */

public class StandardConversationIds extends ConversationIds {
    private long value;

    public StandardConversationIds() {
    }

    /**
     * {@inheritDoc}
     *
     * This implementation returns the next number from the sequence.
     */

    public String getNext() {
        return Long.toHexString(++value);
    }

    /**
     * {@inheritDoc}
     *
     * This implementation does nothing.
     *
     * @param id session id to release
     */

    public void release(String id) {
    }

}
