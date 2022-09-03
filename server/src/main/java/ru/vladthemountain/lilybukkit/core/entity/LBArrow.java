package ru.vladthemountain.lilybukkit.core.entity;

import net.minecraft.src.EntityArrow;
import org.bukkit.World;
import org.bukkit.entity.Arrow;

/**
 * @author VladTheMountain
 */
public class LBArrow extends LBProjectile implements Arrow {

    EntityArrow entity;

    public LBArrow(World w, EntityArrow e) {
        super(w, e);
        this.entity = e;
    }
}
