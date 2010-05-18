package org.umlmda.runtime.sdo.sync.gwt.server;

import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.SyncSession;

/**
 * Holds the player and the recorder.
 */

public class SyncSessionImpl implements SyncSession {
    private Player player;

    public SyncSessionImpl(Player player) {
        if (player == null) {
            throw new NullPointerException("Player can't be null...");
        }
        this.player = player;
    }

    /**
     * {@inheritDoc}
     */

    public Player getPlayer() {
        return player;
    }

    /**
     * {@inheritDoc}
     */

    public Recorder getRecorder() {
        return player.getObjectFactory().getRecorder();
    }

}
