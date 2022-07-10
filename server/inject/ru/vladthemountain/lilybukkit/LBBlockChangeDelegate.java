package ru.vladthemountain.lilybukkit;

import org.bukkit.BlockChangeDelegate;
import org.bukkit.World;

/**
 * {@link BlockChangeDelegate} implementation
 *
 * @author VladTheMountain
 */
public class LBBlockChangeDelegate implements BlockChangeDelegate {

    private World world;

    public LBBlockChangeDelegate(World w) {
        this.world = w;
    }

    /**
     * Set a block type at the specified coordinates.
     *
     * @param x
     * @param y
     * @param z
     * @param typeId
     * @return true if the block was set successfully
     */
    @Override
    public boolean setRawTypeId(int x, int y, int z, int typeId) {
        return this.world.getBlockAt(x, y, z).setTypeId(typeId);
    }

    /**
     * Set a block type and data at the specified coordinates.
     *
     * @param x
     * @param y
     * @param z
     * @param typeId
     * @param data
     * @return true if the block was set successfully
     */
    @Override
    public boolean setRawTypeIdAndData(int x, int y, int z, int typeId, int data) {
        return this.world.getBlockAt(x, y, z).setTypeIdAndData(typeId, new Integer(data).byteValue(), true);
    }

    /**
     * Get the block type at the location.
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    @Override
    public int getTypeId(int x, int y, int z) {
        return this.world.getBlockAt(x, y, z).getTypeId();
    }
}
