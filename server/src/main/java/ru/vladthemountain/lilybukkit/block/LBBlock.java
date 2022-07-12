package ru.vladthemountain.lilybukkit.block;

import net.minecraft.src.BlockRedstoneWire;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import ru.vladthemountain.lilybukkit.LBWorld;

public class LBBlock implements Block {

    final net.minecraft.src.Block block;
    final LBWorld world;

    public LBBlock(LBWorld w, net.minecraft.src.Block b) {
        this(w, b.blockID);
    }

    public LBBlock(LBWorld w, int id) {
        this.world = w;
        this.block = net.minecraft.src.Block.blocksList[id];
    }

    /**
     * Gets the metadata for this block
     *
     * @return block specific metadata
     */
    @Override
    public byte getData() {
        return (byte) this.world.world.getBlockMetadata(this.getX(), this.getY(), this.getZ());
    }

    /**
     * @deprecated use {@link #getRelative(BlockFace face)}
     */
    @Override
    public Block getFace(BlockFace face) {
        return this.getRelative(face);
    }

    /**
     * @deprecated use {@link #getRelative(BlockFace face, int distance)}
     */
    @Override
    public Block getFace(BlockFace face, int distance) {
        return this.getRelative(face, distance);
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
        return this.getWorld().getBlockAt(this.getX() + modX, this.getY() + modY, this.getZ() + modZ);
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
        return this.getRelative(face, 1);
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
        return this.getRelative(face.getModX() * distance, face.getModY() * distance, face.getModZ() * distance);
    }

    /**
     * Gets the type of this block
     *
     * @return block type
     */
    @Override
    public Material getType() {
        return Material.getMaterial(this.getTypeId());
    }

    /**
     * Gets the type-id of this block
     *
     * @return block type-id
     */
    @Override
    public int getTypeId() {
        return this.block.blockID;
    }

    /**
     * Gets the light level between 0-15
     *
     * @return light level
     */
    @Override
    public byte getLightLevel() {
        return (byte) this.world.world.getBlockLightValue(this.getX(), this.getY(), this.getZ());
    }

    /**
     * Gets the world which contains this Block
     *
     * @return World containing this block
     */
    @Override
    public World getWorld() {
        return this.world;
    }

    /**
     * Gets the x-coordinate of this block
     *
     * @return x-coordinate
     */
    @Override
    public int getX() {
        return new Double(this.block.minX).intValue();
    }

    /**
     * Gets the y-coordinate of this block
     *
     * @return y-coordinate
     */
    @Override
    public int getY() {
        return new Double(this.block.minY).intValue();
    }

    /**
     * Gets the z-coordinate of this block
     *
     * @return z-coordinate
     */
    @Override
    public int getZ() {
        return new Double(this.block.minZ).intValue();
    }

    /**
     * Gets the Location of the block
     *
     * @return Location of block
     */
    @Override
    public Location getLocation() {
        return new Location(this.getWorld(), this.getX(), this.getY(), this.getZ());
    }

    /**
     * Gets the chunk which contains this block
     *
     * @return Containing Chunk
     */
    @Override
    public Chunk getChunk() {
        return this.world.getChunkAt(this);
    }

    /**
     * Sets the metadata for this block
     *
     * @param data New block specific metadata
     */
    @Override
    public void setData(byte data) {
        this.setData(data, true);
    }

    @Override
    public void setData(byte data, boolean applyPhysics) {
        if (applyPhysics) this.world.world.setBlockMetadataWithNotify(this.getX(), this.getY(), this.getZ(), data);
        else this.world.world.setBlockMetadata(this.getX(), this.getY(), this.getZ(), data);
    }

    /**
     * Sets the type of this block
     *
     * @param type Material to change this block to
     */
    @Override
    public void setType(Material type) {
        this.setTypeId(type.getId());
    }

    /**
     * Sets the type-id of this block
     *
     * @param type Type-Id to change this block to
     * @return whether the block was changed
     */
    @Override
    public boolean setTypeId(int type) {
        return this.setTypeId(type, true);
    }

    @Override
    public boolean setTypeId(int type, boolean applyPhysics) {
        if (applyPhysics) return this.world.world.setBlockWithNotify(this.getX(), this.getY(), this.getZ(), type);
        else return this.world.world.setBlock(this.getX(), this.getY(), this.getZ(), type);
    }

    @Override
    public boolean setTypeIdAndData(int type, byte data, boolean applyPhysics) {
        if (applyPhysics)
            return this.world.world.setBlockAndMetadataWithNotify(this.getX(), this.getY(), this.getZ(), type, data);
        else return this.world.world.setBlockAndMetadata(this.getX(), this.getY(), this.getZ(), type, data);
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
        for (BlockFace f : BlockFace.values()) {
            if (this.getX() + f.getModX() == block.getX() && this.getY() + f.getModY() == block.getY() && this.getZ() + f.getModZ() == block.getZ()) {
                return f;
            }
        }
        return null;
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
        return new LBBlockState(world, this);
    }

    /**
     * Returns true if the block is being powered by Greenstone.
     */
    @Override
    public boolean isBlockPowered() {
        return this.world.world.isBlockGettingPowered(this.getX(), this.getY(), this.getZ());
    }

    /**
     * Returns true if the block is being indirectly powered by Greenstone.
     */
    @Override
    public boolean isBlockIndirectlyPowered() {
        return this.world.world.isBlockIndirectlyGettingPowered(this.getX(), this.getY(), this.getZ());
    }

    /**
     * Returns true if the block face is being powered by Greenstone.
     */
    @Override
    public boolean isBlockFacePowered(BlockFace face) {
        switch (face) {
            case DOWN:
                return this.world.world.isBlockProvidingPowerTo(this.getX(), this.getY(), this.getZ(), 0);
            case UP:
                return this.world.world.isBlockProvidingPowerTo(this.getX(), this.getY(), this.getZ(), 1);
            case EAST:
                return this.world.world.isBlockProvidingPowerTo(this.getX(), this.getY(), this.getZ(), 2);
            case WEST:
                return this.world.world.isBlockProvidingPowerTo(this.getX(), this.getY(), this.getZ(), 3);
            case NORTH:
                return this.world.world.isBlockProvidingPowerTo(this.getX(), this.getY(), this.getZ(), 4);
            case SOUTH:
                return this.world.world.isBlockProvidingPowerTo(this.getX(), this.getY(), this.getZ(), 5);
            default:
                return false;
        }
    }

    /**
     * Returns true if the block face is being indirectly powered by Greenstone.
     */
    @Override
    public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
        switch (face) {
            case DOWN:
                return this.world.world.isBlockIndirectlyProvidingPowerTo(this.getX(), this.getY(), this.getZ(), 0);
            case UP:
                return this.world.world.isBlockIndirectlyProvidingPowerTo(this.getX(), this.getY(), this.getZ(), 1);
            case EAST:
                return this.world.world.isBlockIndirectlyProvidingPowerTo(this.getX(), this.getY(), this.getZ(), 2);
            case WEST:
                return this.world.world.isBlockIndirectlyProvidingPowerTo(this.getX(), this.getY(), this.getZ(), 3);
            case NORTH:
                return this.world.world.isBlockIndirectlyProvidingPowerTo(this.getX(), this.getY(), this.getZ(), 4);
            case SOUTH:
                return this.world.world.isBlockIndirectlyProvidingPowerTo(this.getX(), this.getY(), this.getZ(), 5);
            default:
                return false;
        }
    }

    /**
     * Returns the Greenstone power being provided to this block face
     *
     * @param face the face of the block to query or BlockFace.SELF for the block itself
     */
    @Override
    public int getBlockPower(BlockFace face) {
        switch (face) {
            case SOUTH:
            case WEST:
            case SELF:
            case NORTH:
            case EAST:
                return this.getBlockPower();
            default:
                return 0;
        }
    }

    /**
     * Returns the Greenstone power being provided to this block
     */
    @Override
    public int getBlockPower() {
        //As it's the only block that stores the power
        if (this.block instanceof BlockRedstoneWire) {
            return this.world.world.getBlockMetadata(this.getX(), this.getY(), this.getZ());
        }
        return 0;
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
        return this.getType().equals(Material.AIR);
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
        return this.getType().equals(Material.WATER) || this.getType().equals(Material.STATIONARY_WATER) || this.getType().equals(Material.LAVA) || this.getType().equals(Material.STATIONARY_LAVA);
    }
}
