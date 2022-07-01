package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.Entity;
import org.bukkit.entity.Slime;

public class LBSlime extends LBLivingEntity implements Slime {

    public LBSlime(Entity e) {
        super(e);
    }

    /**
     * @return The size of the slime
     * @author Celtic Minstrel
     */
    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * @param sz The new size of the slime.
     * @author Celtic Minstrel
     */
    @Override
    public void setSize(int sz) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
