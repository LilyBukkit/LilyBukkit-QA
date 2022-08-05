package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.Entity;
import net.minecraft.src.EntitySheep;
import org.bukkit.World;
import org.bukkit.entity.Sheep;

/**
 * @author VladTheMountain
 */
public class LBSheep extends LBAnimals implements Sheep {

    EntitySheep entity;

    public LBSheep(World w, EntitySheep e) {
        super(w, e);
        this.entity = e;
    }

    /**
     * @return Whether the sheep is sheared.
     * @author Celtic Minstrel
     */
    @Override
    public boolean isSheared() {
        return this.entity.sheared;
    }

    /**
     * @param flag Whether to shear the sheep
     * @author Celtic Minstrel
     */
    @Override
    public void setSheared(boolean flag) {
        this.entity.sheared = flag;
        this.entity.onUpdate();
    }

    @Override
    public Entity getHandle() {
        return this.entity;
    }
}
