package ru.vladthemountain.lilybukkit.entity;

import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;

public class LBCreature extends LBLivingEntity implements Creature {

    LivingEntity targetEntity;

    /**
     * Instructs this Creature to set the specified LivingEntity as its target.
     * Hostile creatures may attack their target, and friendly creatures may
     * follow their target.
     *
     * @param target New LivingEntity to target, or null to clear the target
     */
    @Override
    public void setTarget(LivingEntity target) {
        this.targetEntity = target;
    }

    /**
     * Gets the current target of this Creature
     *
     * @return Current target of this creature, or null if none exists
     */
    @Override
    public LivingEntity getTarget() {
        return this.targetEntity;
    }
}
