package org.bukkit.event.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.util.Vector;

/**
 * Called when a player dashes
 *
 * @author VladTheMountain
 */
public class PlayerDashEvent extends PlayerEvent implements Cancellable {

    private boolean cancelled;
    private Location from;
    private Vector to;

    public PlayerDashEvent(Player who, Location from, Vector vector) {
        super(Type.PLAYER_DASH, who);
        this.from = from;
        this.to = vector;
    }

    /**
     * Gets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * @return true if this event is cancelled
     */
    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    /**
     * Sets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins.
     *
     * @param cancel true if you wish to cancel this event
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     * Returns the location the player dashed from
     *
     * @return block location
     */
    public Location getFrom() {
        return this.from;
    }

    /**
     * Returns the vector where the player dashed
     *
     * @return vector of the dash
     */
    public Vector getTo() {
        return this.to;
    }
}
