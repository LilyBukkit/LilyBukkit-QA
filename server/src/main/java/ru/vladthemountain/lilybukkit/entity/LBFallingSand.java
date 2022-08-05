package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityFallingSand;
import org.bukkit.World;
import org.bukkit.entity.FallingSand;

/**
 * @author VladTheMountain
 */
public class LBFallingSand extends LBEntity implements FallingSand {
    EntityFallingSand entity;

    public LBFallingSand(World w, EntityFallingSand e) {
        super(w, e);
        this.entity = e;
    }
}
