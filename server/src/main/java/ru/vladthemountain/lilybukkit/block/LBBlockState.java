package ru.vladthemountain.lilybukkit.block;

import net.minecraft.src.Entity;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;

public class LBBlockState implements BlockState {
    public LBBlockState(Entity e) {
        
    }

    /**
     * Gets the block represented by this BlockState
     *
     * @return Block that this BlockState represents
     */
    @Override
    public Block getBlock() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the metadata for this block
     *
     * @return block specific metadata
     */
    @Override
    public MaterialData getData() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the type of this block
     *
     * @return block type
     */
    @Override
    public Material getType() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the type-id of this block
     *
     * @return block type-id
     */
    @Override
    public int getTypeId() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the light level between 0-15
     *
     * @return light level
     */
    @Override
    public byte getLightLevel() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the world which contains this Block
     *
     * @return World containing this block
     */
    @Override
    public World getWorld() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the x-coordinate of this block
     *
     * @return x-coordinate
     */
    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the y-coordinate of this block
     *
     * @return y-coordinate
     */
    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the z-coordinate of this block
     *
     * @return z-coordinate
     */
    @Override
    public int getZ() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the chunk which contains this block
     *
     * @return Containing Chunk
     */
    @Override
    public Chunk getChunk() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the metadata for this block
     *
     * @param data New block specific metadata
     */
    @Override
    public void setData(MaterialData data) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the type of this block
     *
     * @param type Material to change this block to
     */
    @Override
    public void setType(Material type) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the type-id of this block
     *
     * @param type Type-Id to change this block to
     */
    @Override
    public boolean setTypeId(int type) {
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public byte getRawData() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
