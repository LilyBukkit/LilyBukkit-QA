package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityTNTPrimed;
import org.bukkit.entity.TNTPrimed;

public class LBTNTPrimed extends LBExplosive implements TNTPrimed {

    EntityTNTPrimed entity;

    public LBTNTPrimed(EntityTNTPrimed e) {
        this.entity = e;
    }

    /**
     * Set the number of ticks until the TNT blows up after being primed.
     *
     * @param fuseTicks
     */
    @Override
    public void setFuseTicks(int fuseTicks) {
        this.entity.fuse = fuseTicks;
        this.entity.onUpdate();
    }

    /**
     * Retrieve the number of ticks until the explosion of this TNTPrimed entity
     *
     * @return the number of ticks until this TNTPrimed explodes
     */
    @Override
    public int getFuseTicks() {
        return this.entity.fuse;
    }
}
