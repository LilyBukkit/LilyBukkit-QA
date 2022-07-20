package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntitySnowball;
import org.bukkit.entity.Snowball;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBSnowball extends LBProjectile implements Snowball {
    EntitySnowball entity;

    public LBSnowball(LBWorld w, EntitySnowball e) {
        super(w, e);
        this.entity = e;
    }
}
