package ru.vladthemountain.lilybukkit.core.entity;

import net.minecraft.src.Entity;
import net.minecraft.src.EntitySnowball;
import org.bukkit.World;
import org.bukkit.entity.Snowball;

/**
 * @author VladTheMountain
 */
public class LBSnowball extends LBProjectile implements Snowball {
    EntitySnowball entity;

    public LBSnowball(World w, EntitySnowball e) {
        super(w, e);
        this.entity = e;
    }

    @Override
    public Entity getHandle() {
        return this.entity;
    }
}
