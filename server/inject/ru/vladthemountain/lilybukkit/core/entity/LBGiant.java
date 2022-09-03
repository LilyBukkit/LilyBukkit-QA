package ru.vladthemountain.lilybukkit.core.entity;

import net.minecraft.src.EntityGiantZombie;
import org.bukkit.World;
import org.bukkit.entity.Giant;

/**
 * @author VladTheMountain
 */
public class LBGiant extends LBMonster implements Giant {
    EntityGiantZombie entity;

    public LBGiant(World w, EntityGiantZombie e) {
        super(w, e);
        this.entity = e;
    }
}
