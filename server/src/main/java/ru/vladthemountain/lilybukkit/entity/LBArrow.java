package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityArrow;
import org.bukkit.entity.Arrow;

/**
 * Arrow entity implementation
 *
 * @author VladTheMountain
 */
public class LBArrow extends LBProjectile implements Arrow {

    EntityArrow entity;

    public LBArrow(EntityArrow e) {
        this.entity = e;
    }
}
