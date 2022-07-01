package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.Entity;
import org.bukkit.entity.Explosive;

public class LBExplosive extends LBEntity implements Explosive {
    public LBExplosive(Entity e) {
        super(e);
    }

    /**
     * Set the radius affected by this explosive's explosion
     *
     * @param yield
     */
    @Override
    public void setYield(float yield) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Return the radius or yield of this explosive's explosion
     *
     * @return the radius of blocks affected
     */
    @Override
    public float getYield() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set whether or not this explosive's explosion causes fire
     *
     * @param isIncendiary
     */
    @Override
    public void setIsIncendiary(boolean isIncendiary) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Return whether or not this explosive creates a fire when exploding
     *
     * @return true if the explosive creates fire, false otherwise
     */
    @Override
    public boolean isIncendiary() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
