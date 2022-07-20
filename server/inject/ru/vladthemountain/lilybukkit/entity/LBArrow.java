package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityArrow;
import org.bukkit.entity.Arrow;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBArrow extends LBProjectile implements Arrow {

    EntityArrow entity;

    public LBArrow(LBWorld w, EntityArrow e) {
        super(w, e);
        this.entity = e;
    }
}
