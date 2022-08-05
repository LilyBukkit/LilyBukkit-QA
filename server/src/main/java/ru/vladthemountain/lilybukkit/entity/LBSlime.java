package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.Entity;
import net.minecraft.src.EntitySlime;
import org.bukkit.World;
import org.bukkit.entity.Slime;

/**
 * @author VladTheMountain
 */
public class LBSlime extends LBLivingEntity implements Slime {

    EntitySlime entity;

    public LBSlime(World w, EntitySlime e) {
        super(w, e);
        this.entity = e;
    }

    /**
     * @return The size of the slime
     * @author Celtic Minstrel
     */
    @Override
    public int getSize() {
        return this.entity.size;
    }

    /**
     * @param sz The new size of the slime.
     * @author Celtic Minstrel
     */
    @Override
    public void setSize(int sz) {
        this.entity.setSlimeSize(sz);
    }

    @Override
    public Entity getHandle() {
        return this.entity;
    }
}
