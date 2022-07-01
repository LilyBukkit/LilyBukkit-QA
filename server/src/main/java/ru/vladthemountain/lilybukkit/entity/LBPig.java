package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityPig;
import org.bukkit.entity.Pig;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBPig extends LBAnimals implements Pig {

    EntityPig entity;

    public LBPig(LBWorld w, EntityPig e) {
        super(w, e);
        this.entity = e;
    }

    /**
     * Check if the pig has a saddle.
     *
     * @return if the pig has been saddled.
     */
    @Override
    public boolean hasSaddle() {
        return this.entity.saddled;
    }

    /**
     * Sets if the pig has a saddle or not
     *
     * @param saddled set if the pig has a saddle or not.
     */
    @Override
    public void setSaddle(boolean saddled) {
        this.entity.saddled = saddled;
    }
}
