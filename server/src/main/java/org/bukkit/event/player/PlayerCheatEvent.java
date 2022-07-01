package org.bukkit.event.player;

import org.bukkit.entity.Player;

/**
 * Called when a player uses either the cheats mechanic or the palette
 *
 * @author VladTheMountain
 */
public class PlayerCheatEvent extends PlayerEvent {

    private boolean palette;

    public PlayerCheatEvent( Player who, boolean isPalette) {
        super(Type.PLAYER_CHEAT, who);
        this.palette = isPalette;
    }

    /**
     * If the cheat was performed via palette
     *
     * @return true, if the cheat was performed via palette
     */
    public boolean usedPalette() {
        return this.palette;
    }
}
