package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.Entity;
import org.bukkit.World;
import org.bukkit.entity.Explosive;

/**
 * @author VladTheMountain
 */
public class LBExplosive extends LBEntity implements Explosive {

    float affectedRadius;
    boolean spawnsFire;
    Entity entity;

    public LBExplosive(World w, Entity e) {
        super(w, e);
        this.entity = e;
    }

    /**
     * Set the radius affected by this explosive's explosion
     *
     * @param yield
     */
    @Override
    public void setYield(float yield) {
        this.affectedRadius = yield;
    }

    /**
     * Return the radius or yield of this explosive's explosion
     *
     * @return the radius of blocks affected
     */
    @Override
    public float getYield() {
        return this.affectedRadius;
    }

    /**
     * Set whether or not this explosive's explosion causes fire
     *
     * @param isIncendiary
     */
    @Override
    public void setIsIncendiary(boolean isIncendiary) {
        this.spawnsFire = isIncendiary;
    }

    /**
     * Return whether or not this explosive creates a fire when exploding
     *
     * @return true if the explosive creates fire, false otherwise
     */
    @Override
    public boolean isIncendiary() {
        return this.spawnsFire;
    }

    @Override
    public Entity getHandle() {
        return this.entity;
    }
}
