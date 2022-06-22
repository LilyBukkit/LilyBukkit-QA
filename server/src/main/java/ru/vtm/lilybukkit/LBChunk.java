package ru.vtm.lilybukkit;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

public class LBChunk implements Chunk {

    public LBChunk(net.minecraft.src.Chunk chunk){
        //TODO
    }

    public LBChunk(Chunk chunk) {
        //TODO
    }

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
     * Gets the world containing this chunk
     *
     * @return Parent World
     */
    @Override
    public World getWorld() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets a block from this chunk
     *
     * @param x 0-15
     * @param y 0-127
     * @param z 0-15
     * @return the Block
     */
    @Override
    public Block getBlock(int x, int y, int z) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Capture thread-safe read-only snapshot of chunk data
     *
     * @return ChunkSnapshot
     */
    @Override
    public ChunkSnapshot getChunkSnapshot() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Capture thread-safe read-only snapshot of chunk data
     *
     * @param includeMaxblocky     - if true, snapshot includes per-coordinate maximum Y values
     * @param includeBiome         - if true, snapshot includes per-coordinate biome type
     * @param includeBiomeTempRain - if true, snapshot includes per-coordinate raw biome temperature and rainfall
     * @return ChunkSnapshot
     */
    @Override
    public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Entity[] getEntities() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public BlockState[] getTileEntities() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Checks if the chunk is loaded.
     *
     * @return
     */
    @Override
    public boolean isLoaded() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Loads the chunk.
     *
     * @param generate Whether or not to generate a chunk if it doesn't already exist
     * @return true if the chunk has loaded successfully, otherwise false
     */
    @Override
    public boolean load(boolean generate) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Loads the chunk.
     *
     * @return true if the chunk has loaded successfully, otherwise false
     */
    @Override
    public boolean load() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Unloads and optionally saves the Chunk
     *
     * @param save Controls whether the chunk is saved
     * @param safe Controls whether to unload the chunk when players are nearby
     * @return true if the chunk has unloaded successfully, otherwise false
     */
    @Override
    public boolean unload(boolean save, boolean safe) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Unloads and optionally saves the Chunk
     *
     * @param save Controls whether the chunk is saved
     * @return true if the chunk has unloaded successfully, otherwise false
     */
    @Override
    public boolean unload(boolean save) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Unloads and optionally saves the Chunk
     *
     * @return true if the chunk has unloaded successfully, otherwise false
     */
    @Override
    public boolean unload() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
