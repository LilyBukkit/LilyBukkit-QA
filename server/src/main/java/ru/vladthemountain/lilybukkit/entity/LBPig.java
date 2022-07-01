package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityPig;
import org.bukkit.entity.Pig;

public class LBPig extends LBAnimals implements Pig {

    EntityPig entity;

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
