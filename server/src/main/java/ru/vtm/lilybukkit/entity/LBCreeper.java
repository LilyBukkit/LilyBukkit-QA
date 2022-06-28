package ru.vtm.lilybukkit.entity;

import net.minecraft.src.Entity;
import org.bukkit.entity.Creeper;

public class LBCreeper extends LBMonster implements Creeper {

    public LBCreeper(Entity e) {
        super(e);
    }

    /**
     * Checks if this Creeper is powered (Electrocuted)
     *
     * @return true if this creeper is powered
     */
    @Override
    public boolean isPowered() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the Powered status of this Creeper
     *
     * @param value New Powered status
     */
    @Override
    public void setPowered(boolean value) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
