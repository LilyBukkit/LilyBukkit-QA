package ru.vladthemountain.lilybukkit.core.block;

import net.minecraft.src.TileEntityMobSpawner;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;
import ru.vladthemountain.lilybukkit.core.LBWorld;

public class LBCreatureSpawner extends LBBlockState implements CreatureSpawner {

    TileEntityMobSpawner entity;

    public LBCreatureSpawner(LBWorld w, Block b) {
        super(w, b);
        this.entity = (TileEntityMobSpawner) w.getWorldServer().getBlockTileEntity(b.getX(), b.getY(), b.getZ());
    }

    /**
     * Get the spawner's creature type.
     *
     * @return
     */
    @Override
    public CreatureType getCreatureType() {
        return CreatureType.fromName(this.getCreatureTypeId());
    }

    /**
     * Set the spawner creature type.
     *
     * @param creatureType
     */
    @Override
    public void setCreatureType(CreatureType creatureType) {
        this.setCreatureTypeId(creatureType.getName());
    }

    /**
     * Get the spawner's creature type.
     *
     * @return
     */
    @Override
    public String getCreatureTypeId() {
        return this.entity.mobID;
    }

    /**
     * Set the spawner mob type.
     *
     * @param creatureType
     */
    @Override
    public void setCreatureTypeId(String creatureType) {
        this.entity.mobID = creatureType;
    }

    /**
     * Get the spawner's delay.
     *
     * @return
     */
    @Override
    public int getDelay() {
        return this.entity.delay;
    }

    /**
     * Set the spawner's delay.
     *
     * @param delay
     */
    @Override
    public void setDelay(int delay) {
        this.entity.delay = delay;
    }
}
