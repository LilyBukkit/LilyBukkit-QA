package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.Entity;
import net.minecraft.src.EntitySlime;
import org.bukkit.entity.Slime;

public class LBSlime extends LBLivingEntity implements Slime {

    EntitySlime entity;

    public LBSlime(EntitySlime e) {
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
}
