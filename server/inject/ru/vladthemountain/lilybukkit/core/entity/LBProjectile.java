package ru.vladthemountain.lilybukkit.core.entity;

import net.minecraft.src.Entity;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;

/**
 * @author VladTheMountain
 */
public class LBProjectile extends LBEntity implements Projectile {

    LBLivingEntity shooter;
    boolean bounces;

    public LBProjectile(World w, Entity e){
        super(w,e);
    }

    /**
     * Retrieve the shooter of this projectile. The returned value can be null
     * for projectiles shot from a block for example.
     *
     * @return the {@link LivingEntity} that shot this projectile
     */
    @Override
    public LivingEntity getShooter() {
        return this.shooter;
    }

    /**
     * Set the shooter of this projectile
     *
     * @param shooter the {@link LivingEntity} that shot this projectile
     */
    @Override
    public void setShooter(LivingEntity shooter) {
        this.shooter = (LBLivingEntity) shooter;
    }

    /**
     * Determine if this projectile should bounce or not when it hits.
     *
     * @return true if it should bounce.
     */
    @Override
    public boolean doesBounce() {
        return this.bounces;
    }

    /**
     * Set whether or not this projectile should bounce or not when it hits something.
     *
     * @param doesBounce whether or not it should bounce.
     */
    @Override
    public void setBounce(boolean doesBounce) {
        this.bounces = doesBounce;
    }
}
