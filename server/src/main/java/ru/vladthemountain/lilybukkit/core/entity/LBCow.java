package ru.vladthemountain.lilybukkit.core.entity;

import net.minecraft.src.EntityCow;
import org.bukkit.World;
import org.bukkit.entity.Cow;

/**
 * @author VladTheMountain
 */
public class LBCow extends LBAnimals implements Cow {

    public LBCow(World w, EntityCow e) {
        super(w, e);
    }
}
