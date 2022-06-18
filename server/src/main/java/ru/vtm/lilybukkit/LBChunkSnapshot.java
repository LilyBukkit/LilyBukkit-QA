package ru.vtm.lilybukkit;

import org.bukkit.ChunkSnapshot;
import org.bukkit.block.Biome;

public class LBChunkSnapshot implements ChunkSnapshot {
    /**
     * Gets the X-coordinate of this chunk
     *
     * @return X-coordinate
     */
    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the Z-coordinate of this chunk
     *
     * @return Z-coordinate
     */
    @Override
    public int getZ() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets name of the world containing this chunk
     *
     * @return Parent World Name
     */
    @Override
    public String getWorldName() {
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get biome at given coordinates
     *
     * @param x X-coordinate
     * @param z Z-coordinate
     * @return Biome at given coordinate
     */
    @Override
    public Biome getBiome(int x, int z) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get raw biome temperature (0.0-1.0) at given coordinate
     *
     * @param x X-coordinate
     * @param z Z-coordinate
     * @return temperature at given coordinate
     */
    @Override
    public double getRawBiomeTemperature(int x, int z) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get raw biome rainfall (0.0-1.0) at given coordinate
     *
     * @param x X-coordinate
     * @param z Z-coordinate
     * @return rainfall at given coordinate
     */
    @Override
    public double getRawBiomeRainfall(int x, int z) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get world full time when chunk snapshot was captured
     *
     * @return time in ticks
     */
    @Override
    public long getCaptureFullTime() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
