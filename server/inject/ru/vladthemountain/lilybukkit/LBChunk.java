package ru.vladthemountain.lilybukkit;

import net.minecraft.src.AxisAlignedBB;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import ru.vladthemountain.lilybukkit.block.LBBlock;
import ru.vladthemountain.lilybukkit.block.LBBlockState;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link Chunk} implementation
 *
 * @author VladTheMountain
 */
public class LBChunk implements Chunk {

    private net.minecraft.src.Chunk chunk;
    private LBWorld world;

    public LBChunk(net.minecraft.src.Chunk chunk) {
        this.chunk = chunk;
        this.world = (LBWorld) Bukkit.getServer().getWorld(this.chunk.worldObj.levelName);
    }

    /**
     * Gets the X-coordinate of this chunk
     *
     * @return X-coordinate
     */
    @Override
    public int getX() {
        return this.chunk.xPosition;
    }

    /**
     * Gets the Z-coordinate of this chunk
     *
     * @return Z-coordinate
     */
    @Override
    public int getZ() {
        return this.chunk.zPosition;
    }

    /**
     * Gets the world containing this chunk
     *
     * @return Parent World
     */
    @Override
    public World getWorld() {
        return this.world;
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
        return new LBBlock(this.world, this.chunk.getBlockID(x, y, z));
    }

    /**
     * Capture thread-safe read-only snapshot of chunk data
     *
     * @return ChunkSnapshot
     */
    @Override
    public ChunkSnapshot getChunkSnapshot() {
        return this.getChunkSnapshot(false);
    }

    /**
     * Capture thread-safe read-only snapshot of chunk data
     *
     * @param includeMaxblocky - if true, snapshot includes per-coordinate maximum Y values
     * @return ChunkSnapshot
     */
    @Override
    public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky) {
        return new LBChunkSnapshot(this, this.world.getFullTime(), includeMaxblocky);
    }

    @Override
    public Entity[] getEntities() {
        List<net.minecraft.src.Entity> vEntityList = new ArrayList<>();
        this.chunk.getEntitiesOfTypeWithinAAAB(net.minecraft.src.Entity.class, AxisAlignedBB.getBoundingBoxFromPool(new Integer(this.chunk.xPosition).doubleValue(), 0.0, new Integer(this.chunk.zPosition).doubleValue(), new Integer(this.chunk.xPosition + 16).doubleValue(), 127.0, new Integer(this.chunk.zPosition).doubleValue()), vEntityList);
        List<Entity> bEntityList = new ArrayList<>();
        for (net.minecraft.src.Entity e : vEntityList) {
            bEntityList.add((Entity) e);
        }
        return bEntityList.toArray(new Entity[]{});
    }

    @Override
    public BlockState[] getTileEntities() {
        List<net.minecraft.src.Entity> vEntityList = new ArrayList<>();
        this.chunk.getEntitiesOfTypeWithinAAAB(net.minecraft.src.TileEntity.class, AxisAlignedBB.getBoundingBoxFromPool(new Integer(this.chunk.xPosition).doubleValue(), 0.0, new Integer(this.chunk.zPosition).doubleValue(), new Integer(this.chunk.xPosition + 16).doubleValue(), 128.0, new Integer(this.chunk.zPosition).doubleValue()), vEntityList);
        List<BlockState> bEntityList = new ArrayList<>();
        for (net.minecraft.src.Entity e : vEntityList) {
            bEntityList.add(new LBBlockState(this.getBlock((int) e.posX, (int) e.posY, (int) e.posZ)));
        }
        return bEntityList.toArray(new BlockState[bEntityList.size()]);
    }

    /**
     * Checks if the chunk is loaded.
     *
     * @return
     */
    @Override
    public boolean isLoaded() {
        return this.chunk.isChunkLoaded;
    }

    /**
     * Loads the chunk.
     *
     * @param generate Whether or not to generate a chunk if it doesn't already exist
     * @return true if the chunk has loaded successfully, otherwise false
     */
    @Override
    public boolean load(boolean generate) {
        this.chunk.onChunkLoad();
        return this.chunk.isChunkLoaded;
    }

    /**
     * Loads the chunk.
     *
     * @return true if the chunk has loaded successfully, otherwise false
     */
    @Override
    public boolean load() {
        return this.load(false);
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
        this.chunk.onChunkUnload();
        return this.chunk.isChunkLoaded;
    }

    /**
     * Unloads and optionally saves the Chunk
     *
     * @param save Controls whether the chunk is saved
     * @return true if the chunk has unloaded successfully, otherwise false
     */
    @Override
    public boolean unload(boolean save) {
        return this.unload(save, true);
    }

    /**
     * Unloads and optionally saves the Chunk
     *
     * @return true if the chunk has unloaded successfully, otherwise false
     */
    @Override
    public boolean unload() {
        return this.unload(true, true);
    }
}
