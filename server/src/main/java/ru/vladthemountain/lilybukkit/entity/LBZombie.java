package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityZombie;
import org.bukkit.World;
import org.bukkit.entity.Zombie;

/**
 * @author VladTheMountain
 */
public class LBZombie extends LBMonster implements Zombie {

    EntityZombie entity;

    public LBZombie(World w, EntityZombie e) {
        super(w, e);
        this.entity = e;
    }

    @Override
    public Entity getHandle() {
        return this.entity;
    }
}
