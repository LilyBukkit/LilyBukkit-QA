package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityGiantZombie;
import net.minecraft.src.EntityMob;
import org.bukkit.entity.Giant;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBGiant extends LBMonster implements Giant {
    EntityGiantZombie entity;

    public LBGiant(LBWorld w, EntityGiantZombie e) {
        super(w,e);
        this.entity = e;
    }
}
