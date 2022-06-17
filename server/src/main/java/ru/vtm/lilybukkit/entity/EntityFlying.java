package ru.vtm.lilybukkit.entity;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.World;
import org.bukkit.entity.Flying;

/**
 * A stub class for a non-existent entity
 */
public class EntityFlying extends EntityLiving implements Flying {
    public EntityFlying(World world) {
        super(world);
    }

    /**
     * Gets the height of the entity's head above its Location
     *
     * @return Height of the entity's eyes above its Location
     */
    @Override
    public double getEyeHeight() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
