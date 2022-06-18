package ru.vtm.lilybukkit.entity;

import org.bukkit.entity.TNTPrimed;

public class LBTNTPrimed extends LBExplosive implements TNTPrimed {

    /**
     * Set the number of ticks until the TNT blows up after being primed.
     *
     * @param fuseTicks
     */
    @Override
    public void setFuseTicks(int fuseTicks) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Retrieve the number of ticks until the explosion of this TNTPrimed entity
     *
     * @return the number of ticks until this TNTPrimed explodes
     */
    @Override
    public int getFuseTicks() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
