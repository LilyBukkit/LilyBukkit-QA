package ru.vtm.lilybukkit.stubs.block;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.inventory.Inventory;
import org.bukkit.material.MaterialData;

/**
 * A stub class for a non-existent block
 */
public class BlockDispenser extends BlockContainer implements Dispenser {
    protected BlockDispenser(int id, Material material) {
        super(id, material);
    }

    protected BlockDispenser(int id, int blockIndex, Material material) {
        super(id, blockIndex, material);
    }

    @Override
    protected TileEntity getBlockEntity() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Attempts to dispense the contents of this block<br />
     * <br />
     * If the block is no longer a dispenser, this will return false
     *
     * @return true if successful, otherwise false
     */
    @Override
    public boolean dispense() {
        throw new UnsupportedOperationException("Not implemented yet");
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
     * Sets the metadata for this block
     *
     * @param data New block specific metadata
     */
    @Override
    public void setData(MaterialData data) {
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
     * @see BlockState.update(boolean force)
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

    /**
     * Get the block's inventory.
     *
     * @return
     */
    @Override
    public Inventory getInventory() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
