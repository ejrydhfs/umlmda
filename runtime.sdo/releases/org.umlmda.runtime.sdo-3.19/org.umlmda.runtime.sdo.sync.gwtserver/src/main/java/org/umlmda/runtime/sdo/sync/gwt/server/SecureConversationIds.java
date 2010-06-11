package org.umlmda.runtime.sdo.sync.gwt.server;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * Secure implementation of sync session ids generator.
 */

public class SecureConversationIds extends ConversationIds {
    private Set<String> usedIds;
    private SecureRandom random;

    public SecureConversationIds() {
        usedIds = new HashSet<String>();
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            random = new SecureRandom();
        }
    }

    /**
     * {@inheritDoc}
     *
     * This implementation returns next secure id.
     */

    public synchronized String getNext() {
        while (true) {
            String maybeResult = format(random.nextLong());
            if (!usedIds.contains(maybeResult)) {
                usedIds.add(maybeResult);
                Logger.getLogger(SecureConversationIds.class).info("Next conversation id is: " + maybeResult);
                return maybeResult;
            }
        }
    }

    private String format(long value) {
        StringBuilder b = new StringBuilder(16);
        b.append(Long.toHexString(value).toUpperCase());
        while (b.length() < 16) {
            b.append('0');
        }
        return b.toString();
    }

    /**
     * {@inheritDoc}
     *
     * This implementation may use given id in the fututre.
     */

    public synchronized void release(String syncSessionId) {
        usedIds.remove(syncSessionId);
    }

}
