package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.Entity;
import org.bukkit.entity.Sheep;

public class LBSheep extends LBAnimals implements Sheep {
    public LBSheep(Entity e) {
        super(e);
    }

    /**
     * @return Whether the sheep is sheared.
     * @author Celtic Minstrel
     */
    @Override
    public boolean isSheared() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * @param flag Whether to shear the sheep
     * @author Celtic Minstrel
     */
    @Override
    public void setSheared(boolean flag) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
