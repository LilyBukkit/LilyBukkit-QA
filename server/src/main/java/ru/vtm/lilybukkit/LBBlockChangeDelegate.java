package ru.vtm.lilybukkit;

import org.bukkit.BlockChangeDelegate;

public class LBBlockChangeDelegate implements BlockChangeDelegate {
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
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
