package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.Entity;
import org.bukkit.entity.Pig;

public class LBPig extends LBAnimals implements Pig {

    public LBPig(Entity e) {
        super(e);
    }

    /**
     * Check if the pig has a saddle.
     *
     * @return if the pig has been saddled.
     */
    @Override
    public boolean hasSaddle() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets if the pig has a saddle or not
     *
     * @param saddled set if the pig has a saddle or not.
     */
    @Override
    public void setSaddle(boolean saddled) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
