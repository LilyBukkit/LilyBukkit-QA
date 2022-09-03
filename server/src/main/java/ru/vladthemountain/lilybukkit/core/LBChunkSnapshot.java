package ru.vladthemountain.lilybukkit.core;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;

/**
 * {@link ChunkSnapshot} implementation
 *
 * @author VladTheMountain
 */
public class LBChunkSnapshot implements ChunkSnapshot {

    private Chunk chunk;
    private long timestamp;

    public LBChunkSnapshot(Chunk chunk, long fullTime, boolean maxBlockY) {
        this.chunk = chunk;
        this.timestamp = fullTime;
    }

    /**
     * Gets the X-coordinate of this chunk
     *
     * @return X-coordinate
     */
    @Override
    public int getX() {
        return this.chunk.getX();
    }

    /**
     * Gets the Z-coordinate of this chunk
     *
     * @return Z-coordinate
     */
    @Override
    public int getZ() {
        return this.chunk.getZ();
    }

    /**
     * Gets name of the world containing this chunk
     *
     * @return Parent World Name
     */
    @Override
    public String getWorldName() {
        return this.chunk.getWorld().getName();
    }

    /**
     * Get block type for block at corresponding coordinate in the chunk
     *
     * @param x 0-15
     * @param y 0-127
     * @param z 0-15
     * @return 0-255
     */
    @Override
    public int getBlockTypeId(int x, int y, int z) {
        return this.chunk.getBlock(x, y, z).getTypeId();
    }

    /**
     * Get block data for block at corresponding coordinate in the chunk
     *
     * @param x 0-15
     * @param y 0-127
     * @param z 0-15
     * @return 0-15
     */
    @Override
    public int getBlockData(int x, int y, int z) {
        return this.chunk.getBlock(x, y, z).getData();
    }

    /**
     * Get sky light level for block at corresponding coordinate in the chunk
     *
     * @param x 0-15
     * @param y 0-127
     * @param z 0-15
     * @return 0-15
     */
    @Override
    public int getBlockSkyLight(int x, int y, int z) {
        return this.chunk.getBlock(x, y, z).getLightLevel();
    }

    /**
     * Get light level emitted by block at corresponding coordinate in the chunk
     *
     * @param x 0-15
     * @param y 0-127
     * @param z 0-15
     * @return 0-15
     */
    @Override
    public int getBlockEmittedLight(int x, int y, int z) {
        return this.chunk.getBlock(x, y, z).getLightLevel(); //I don't think there's any other way
    }

    /**
     * Gets the highest non-air coordinate at the given coordinates
     *
     * @param x X-coordinate of the blocks
     * @param z Z-coordinate of the blocks
     * @return Y-coordinate of the highest non-air block
     */
    @Override
    public int getHighestBlockYAt(int x, int z) {
        for (int y = 127; y >= 0; y--) {
            if (!(this.chunk.getBlock(x, y, z).isEmpty() || this.chunk.getBlock(x, y, z).getTypeId() == 0)) {
                return y;
            }
        }
        return 127;
    }

    /**
     * Get world full time when chunk snapshot was captured
     *
     * @return time in ticks
     */
    @Override
    public long getCaptureFullTime() {
        return this.timestamp;
    }
}
