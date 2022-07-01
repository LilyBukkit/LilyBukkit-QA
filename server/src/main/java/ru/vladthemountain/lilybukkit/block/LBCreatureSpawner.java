package ru.vladthemountain.lilybukkit.block;

import net.minecraft.src.Entity;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;

public class LBCreatureSpawner extends LBBlockState implements CreatureSpawner {

    public LBCreatureSpawner(Entity e) {
        super(e);
    }

    /**
     * Get the spawner's creature type.
     *
     * @return
     */
    @Override
    public CreatureType getCreatureType() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the spawner creature type.
     *
     * @param creatureType
     */
    @Override
    public void setCreatureType(CreatureType creatureType) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the spawner's creature type.
     *
     * @return
     */
    @Override
    public String getCreatureTypeId() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the spawner mob type.
     *
     * @param creatureType
     */
    @Override
    public void setCreatureTypeId(String creatureType) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the spawner's delay.
     *
     * @return
     */
    @Override
    public int getDelay() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the spawner's delay.
     *
     * @param delay
     */
    @Override
    public void setDelay(int delay) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
