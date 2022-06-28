package ru.vtm.lilybukkit.entity;

import net.minecraft.src.Entity;
import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;

public class LBCreature extends LBLivingEntity implements Creature {

    public LBCreature(Entity e) {
        super(e);
    }

    /**
     * Instructs this Creature to set the specified LivingEntity as its target.
     * Hostile creatures may attack their target, and friendly creatures may
     * follow their target.
     *
     * @param target New LivingEntity to target, or null to clear the target
     */
    @Override
    public void setTarget(LivingEntity target) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the current target of this Creature
     *
     * @return Current target of this creature, or null if none exists
     */
    @Override
    public LivingEntity getTarget() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
