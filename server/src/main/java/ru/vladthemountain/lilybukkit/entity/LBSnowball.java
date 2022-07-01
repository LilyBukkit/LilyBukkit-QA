package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntitySnowball;
import org.bukkit.entity.Snowball;

public class LBSnowball extends LBProjectile implements Snowball {
    EntitySnowball entity;

    public LBSnowball(EntitySnowball e) {
        this.entity = e;
    }
}
