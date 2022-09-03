package ru.vladthemountain.lilybukkit.core.entity;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityPig;
import org.bukkit.World;
import org.bukkit.entity.Pig;

/**
 * @author VladTheMountain
 */
public class LBPig extends LBAnimals implements Pig {

    EntityPig entity;

    public LBPig(World w, EntityPig e) {
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

    @Override
    public Entity getHandle() {return entity;}
}
