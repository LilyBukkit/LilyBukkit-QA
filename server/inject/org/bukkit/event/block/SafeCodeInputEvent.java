package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;

/**
 * Called when a player inputs a code into the Safe Block
 *
 * @author VladTheMountain
 */
public class SafeCodeInputEvent extends BlockEvent implements Cancellable {

    private boolean cancelled;

    public SafeCodeInputEvent(Block theBlock) {
        super(Type.CODE_INPUT, theBlock);
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
}
