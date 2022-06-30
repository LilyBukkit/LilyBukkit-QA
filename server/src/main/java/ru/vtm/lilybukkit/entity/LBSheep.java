package ru.vtm.lilybukkit.entity;

import net.minecraft.src.Entity;
import org.bukkit.DyeColor;
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

    /**
     * Gets the color of this object.
     *
     * @return The DyeColor of this object.
     */
    @Override
    public DyeColor getColor() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the color of this object to the specified DyeColor.
     *
     * @param color The color of the object, as a DyeColor.
     */
    @Override
    public void setColor(DyeColor color) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
