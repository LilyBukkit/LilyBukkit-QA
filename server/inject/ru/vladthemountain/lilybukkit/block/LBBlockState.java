package ru.vladthemountain.lilybukkit.block;

import net.minecraft.src.TileEntity;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import ru.vladthemountain.lilybukkit.LBWorld;

public class LBBlockState implements BlockState {

    TileEntity tileEntity;
    Block block;
    LBWorld world;

    public LBBlockState(LBWorld w, Block b) {
        this.block = b;
        this.world = w;
        this.tileEntity = w.getWorldServer().getBlockTileEntity(b.getX(), b.getY(), b.getZ());
    }

    /**
     * Gets the block represented by this BlockState
     *
     * @return Block that this BlockState represents
     */
    @Override
    public Block getBlock() {
        return this.getWorld().getBlockAt(this.tileEntity.xCoord, this.tileEntity.yCoord, this.tileEntity.zCoord);
    }

    /**
     * Gets the metadata for this block
     *
     * @return block specific metadata
     */
    @Override
    public MaterialData getData() {
        return this.getType().getNewData(this.block.getData());
    }

    /**
     * Gets the type of this block
     *
     * @return block type
     */
    @Override
    public Material getType() {
        return this.block.getType();
    }

    /**
     * Gets the type-id of this block
     *
     * @return block type-id
     */
    @Override
    public int getTypeId() {
        return this.block.getTypeId();
    }

    /**
     * Gets the light level between 0-15
     *
     * @return light level
     */
    @Override
    public byte getLightLevel() {
        return this.block.getLightLevel();
    }

    /**
     * Gets the world which contains this Block
     *
     * @return World containing this block
     */
    @Override
    public World getWorld() {
        return this.block.getWorld();
    }

    /**
     * Gets the x-coordinate of this block
     *
     * @return x-coordinate
     */
    @Override
    public int getX() {
        return this.block.getX();
    }

    /**
     * Gets the y-coordinate of this block
     *
     * @return y-coordinate
     */
    @Override
    public int getY() {
        return this.block.getY();
    }

    /**
     * Gets the z-coordinate of this block
     *
     * @return z-coordinate
     */
    @Override
    public int getZ() {
        return this.block.getZ();
    }

    /**
     * Gets the chunk which contains this block
     *
     * @return Containing Chunk
     */
    @Override
    public Chunk getChunk() {
        return this.block.getChunk();
    }

    /**
     * Sets the metadata for this block
     *
     * @param data New block specific metadata
     */
    @Override
    public void setData(MaterialData data) {
        this.block.setData(data.getData());
    }

    /**
     * Sets the type of this block
     *
     * @param type Material to change this block to
     */
    @Override
    public void setType(Material type) {
        this.block.setType(type);
    }

    /**
     * Sets the type-id of this block
     *
     * @param type Type-Id to change this block to
     */
    @Override
    public boolean setTypeId(int type) {
        return this.block.setTypeId(type);
    }

    /**
     * Attempts to update the block represented by this state, setting it to the
     * new values as defined by this state. <br />
     * <br />
     * This has the same effect as calling update(false). That is to say,
     * this will not modify the state of a block if it is no longer the same
     * type as it was when this state was taken. It will return false in this
     * eventuality.
     *
     * @return true if the update was successful, otherwise false
     * @see BlockState#update(boolean force)
     */
    @Override
    public boolean update() {
        return this.update(false);
    }

    /**
     * Attempts to update the block represented by this state, setting it to the
     * new values as defined by this state. <br />
     * <br />
     * Unless force is true, this will not modify the state of a block if it is
     * no longer the same type as it was when this state was taken. It will return
     * false in this eventuality.<br />
     * <br />
     * If force is true, it will set the type of the block to match the new state,
     * set the state data and then return true.
     *
     * @param force true to forcefully set the state
     * @return true if the update was successful, otherwise false
     */
    @Override
    public boolean update(boolean force) {
        this.block = this.block.getWorld().getBlockAt(this.block.getLocation());
        return true;
    }

    @Override
    public byte getRawData() {
        return this.getData().getData();
    }
}
