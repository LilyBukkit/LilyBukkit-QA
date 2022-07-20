package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityZombie;
import org.bukkit.entity.Zombie;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBZombie extends LBMonster implements Zombie {

    public LBZombie(LBWorld w, EntityZombie e) {
        super(w, e);
    }
}
