package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;

public class LBProjectile extends LBEntity implements Projectile {

    public LBProjectile(Entity e) {
        super(e);
    }

    /**
     * Retrieve the shooter of this projectile. The returned value can be null
     * for projectiles shot from a block.
     *
     * @return the {@link LivingEntity} that shot this projectile
     */
    @Override
    public LivingEntity getShooter() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the shooter of this projectile
     *
     * @param shooter the {@link LivingEntity} that shot this projectile
     */
    @Override
    public void setShooter(LivingEntity shooter) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Determine if this projectile should bounce or not when it hits.
     *
     * @return true if it should bounce.
     */
    @Override
    public boolean doesBounce() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set whether or not this projectile should bounce or not when it hits something.
     *
     * @param doesBounce whether or not it should bounce.
     */
    @Override
    public void setBounce(boolean doesBounce) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
