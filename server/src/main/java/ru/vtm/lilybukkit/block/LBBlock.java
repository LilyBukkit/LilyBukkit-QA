package ru.vtm.lilybukkit.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.*;

public class LBBlock implements Block {
    /**
     * Gets the metadata for this block
     *
     * @return block specific metadata
     */
    @Override
    public byte getData() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * @param face
     * @deprecated use {@link #getRelative(BlockFace face)}
     */
    @Override
    public Block getFace(BlockFace face) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * @param face
     * @param distance
     * @deprecated use {@link #getRelative(BlockFace face, int distance)}
     */
    @Override
    public Block getFace(BlockFace face, int distance) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the block at the given offsets
     *
     * @param modX X-coordinate offset
     * @param modY Y-coordinate offset
     * @param modZ Z-coordinate offset
     * @return Block at the given offsets
     */
    @Override
    public Block getRelative(int modX, int modY, int modZ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the block at the given face<br />
     * <br />
     * This method is equal to getRelative(face, 1)
     *
     * @param face Face of this block to return
     * @return Block at the given face
     * @see Block#getRelative(BlockFace face, int distance);
     */
    @Override
    public Block getRelative(BlockFace face) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the block at the given distance of the given face<br />
     * <br />
     * For example, the following method places water at 100,102,100; two blocks
     * above 100,100,100.
     * <pre>
     * Block block = world.getBlockAt(100,100,100);
     * Block shower = block.getFace(BlockFace.UP, 2);
     * shower.setType(Material.WATER);
     * </pre>
     *
     * @param face     Face of this block to return
     * @param distance Distance to get the block at
     * @return Block at the given face
     */
    @Override
    public Block getRelative(BlockFace face, int distance) {
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
     * Gets the Location of the block
     *
     * @return Location of block
     */
    @Override
    public Location getLocation() {
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
    public void setData(byte data) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void setData(byte data, boolean applyPhyiscs) {
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
     * @return whether the block was changed
     */
    @Override
    public boolean setTypeId(int type) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean setTypeId(int type, boolean applyPhysics) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean setTypeIdAndData(int type, byte data, boolean applyPhyiscs) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the face relation of this block compared to the given block<br />
     * <br />
     * For example:
     * <pre>
     * Block current = world.getBlockAt(100, 100, 100);
     * Block target = world.getBlockAt(100, 101, 100);
     *
     * current.getFace(target) == BlockFace.Up;
     * </pre>
     * <br />
     * If the given block is not connected to this block, null may be returned
     *
     * @param block Block to compare against this block
     * @return BlockFace of this block which has the requested block, or null
     */
    @Override
    public BlockFace getFace(Block block) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Captures the current state of this block. You may then cast that state
     * into any accepted type, such as Furnace or Sign.
     * <p>
     * The returned object will never be updated, and you are not guaranteed that
     * (for example) a sign is still a sign after you capture its state.
     *
     * @return BlockState with the current state of this block.
     */
    @Override
    public BlockState getState() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the biome that this block resides in
     *
     * @return Biome type containing this block
     */
    @Override
    public Biome getBiome() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns true if the block is being powered by Redstone.
     *
     * @return
     */
    @Override
    public boolean isBlockPowered() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns true if the block is being indirectly powered by Redstone.
     *
     * @return
     */
    @Override
    public boolean isBlockIndirectlyPowered() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns true if the block face is being powered by Redstone.
     *
     * @param face
     * @return
     */
    @Override
    public boolean isBlockFacePowered(BlockFace face) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns true if the block face is being indirectly powered by Redstone.
     *
     * @param face
     * @return
     */
    @Override
    public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the redstone power being provided to this block face
     *
     * @param face the face of the block to query or BlockFace.SELF for the block itself
     * @return
     */
    @Override
    public int getBlockPower(BlockFace face) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the redstone power being provided to this block
     *
     * @return
     */
    @Override
    public int getBlockPower() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Checks if this block is empty.
     * <p>
     * A block is considered empty when {@link #getType()} returns {@link Material#AIR}.
     *
     * @return true if this block is empty
     */
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Checks if this block is liquid.
     * <p>
     * A block is considered liquid when {@link #getType()} returns {@link Material#WATER}, {@link Material#STATIONARY_WATER}, {@link Material#LAVA} or {@link Material#STATIONARY_LAVA}.
     *
     * @return true if this block is liquid
     */
    @Override
    public boolean isLiquid() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the temperature of the biome of this block
     *
     * @return Temperature of this block
     */
    @Override
    public double getTemperature() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the humidity of the biome of this block
     *
     * @return Humidity of this block
     */
    @Override
    public double getHumidity() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the reaction of the block when moved by a piston
     *
     * @return reaction
     */
    @Override
    public PistonMoveReaction getPistonMoveReaction() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
