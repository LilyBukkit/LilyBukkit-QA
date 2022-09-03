package ru.vladthemountain.lilybukkit.core.entity;

import net.minecraft.src.EntityCreature;
import net.minecraft.src.EntityLiving;
import org.bukkit.World;
import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;

/**
 * @author VladTheMountain
 */
public class LBCreature extends LBLivingEntity implements Creature {

    EntityCreature entity;

    public LBCreature(World w, EntityCreature e) {
        super(w, e);
        this.entity = e;
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
        this.entity.entityToAttack = target == null ? null : new EntityLiving(this.world.getWorldServer());
    }

    /**
     * Gets the current target of this Creature
     *
     * @return Current target of this creature, or null if none exists
     */
    @Override
    public LivingEntity getTarget() {
        return new LBLivingEntity(this.world, (EntityLiving) this.entity.entityToAttack);
    }
}
