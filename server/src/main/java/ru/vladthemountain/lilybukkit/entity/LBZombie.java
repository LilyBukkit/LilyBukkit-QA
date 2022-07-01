package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityZombie;
import org.bukkit.entity.Zombie;

public class LBZombie extends LBMonster implements Zombie {

    EntityZombie entity;

    public LBZombie(EntityZombie e) {
        this.entity = e;
    }
}
