package ru.vladthemountain.lilybukkit.core.entity;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityTNTPrimed;
import org.bukkit.World;
import org.bukkit.entity.TNTPrimed;

/**
 * @author VladTheMountain
 */
public class LBTNTPrimed extends LBExplosive implements TNTPrimed {

    EntityTNTPrimed entity;

    public LBTNTPrimed(World w, EntityTNTPrimed e) {
        super(w, e);
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

    @Override
    public Entity getHandle() {
        return this.entity;
    }
}
