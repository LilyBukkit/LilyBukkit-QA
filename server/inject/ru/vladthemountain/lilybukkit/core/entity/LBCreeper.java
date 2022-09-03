package ru.vladthemountain.lilybukkit.core.entity;

import net.minecraft.src.EntityCreeper;
import org.bukkit.World;
import org.bukkit.entity.Creeper;

/**
 * @author VladTheMountain
 */
public class LBCreeper extends LBMonster implements Creeper {
    EntityCreeper entity;

    public LBCreeper(World w, EntityCreeper e) {
        super(w,e);
        this.entity = e;
    }
}
