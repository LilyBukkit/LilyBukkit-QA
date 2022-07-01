package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityFallingSand;
import org.bukkit.entity.FallingSand;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBFallingSand extends LBEntity implements FallingSand {
    EntityFallingSand entity;

    public LBFallingSand(LBWorld w, EntityFallingSand e) {
        super(w, e);
        this.entity = e;
    }
}
