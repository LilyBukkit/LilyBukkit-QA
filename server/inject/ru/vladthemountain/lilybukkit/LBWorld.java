package ru.vladthemountain.lilybukkit;

import net.minecraft.src.*;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.*;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import ru.vladthemountain.lilybukkit.block.LBBlock;
import ru.vladthemountain.lilybukkit.entity.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * {@link World} implementation
 *
 * @author VladTheMountain
 */
public class LBWorld implements World {

    public final net.minecraft.src.WorldServer world;
    boolean allowMonsters;
    boolean allowAnimals;

    List<Chunk> loadedChunks;
    List<BlockPopulator> blockPopulatorList;
    ChunkGenerator chunkGen;
    boolean spawnInMemory;
    boolean isPVPAllowed;

    public LBWorld(String name) {
        this(name, new Random().nextLong());
    }

    public LBWorld(String name, long seed) {
        world = new net.minecraft.src.WorldServer(new File(name), name, true);
        world.randomSeed = seed;
        this.loadedChunks = new ArrayList<>();
        for (net.minecraft.src.Entity p : this.world.playerEntities) {
            for (ChunkCoordIntPair c : ((EntityPlayerMP) p).loadedChunks) {
                this.loadedChunks.add(this.getChunkAt(c.chunkXPos, c.chunkZPos));
            }
        }
        this.blockPopulatorList = new ArrayList<>();
        this.isPVPAllowed = Bukkit.getServer().getPVPEnabled();
    }

    public LBWorld(String name, ChunkGenerator chunkGen) {
        this(name, new Random().nextLong(), chunkGen);
    }

    public LBWorld(String name, long seed, ChunkGenerator chunkGen) {
        this(name, seed);
        this.chunkGen = chunkGen;
    }

    /**
     * Gets the {@link Block} at the given coordinates
     *
     * @param x X-coordinate of the block
     * @param y Y-coordinate of the block
     * @param z Z-coordinate of the block
     * @return Block at the given coordinates
     * @see #getBlockTypeIdAt(int, int, int) Returns the current type ID of the block
     */
    @Override
    public Block getBlockAt(int x, int y, int z) {
        return this.world.blockExists(x, y, z) ? new LBBlock(this, this.world.getBlockId(x, y, z)) : new LBBlock(this, 0);
    }

    /**
     * Gets the {@link Block} at the given {@link Location}
     *
     * @param location Location of the block
     * @return Block at the given location
     * @see #getBlockTypeIdAt(Location) Returns the current type ID of the block
     */
    @Override
    public Block getBlockAt(Location location) {
        return this.getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    /**
     * Gets the block type ID at the given coordinates
     *
     * @param x X-coordinate of the block
     * @param y Y-coordinate of the block
     * @param z Z-coordinate of the block
     * @return Type ID of the block at the given coordinates
     * @see #getBlockAt(int, int, int) Returns a live Block object at the given location
     */
    @Override
    public int getBlockTypeIdAt(int x, int y, int z) {
        return this.world.getBlockId(x, y, z);
    }

    /**
     * Gets the block type ID at the given {@link Location}
     *
     * @param location Location of the block
     * @return Type ID of the block at the given location
     * @see #getBlockAt(Location) Returns a live Block object at the given location
     */
    @Override
    public int getBlockTypeIdAt(Location location) {
        return this.getBlockTypeIdAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
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
        return this.world.getChunkFromBlockCoords(x, z).getHeightValue(x, z);
    }

    /**
     * Gets the highest non-air coordinate at the given {@link Location}
     *
     * @param location Location of the blocks
     * @return Y-coordinate of the highest non-air block
     */
    @Override
    public int getHighestBlockYAt(Location location) {
        return this.getHighestBlockYAt(location.getBlockX(), location.getBlockZ());
    }

    /**
     * Gets the highest non-empty block at the given coordinates
     *
     * @param x X-coordinate of the block
     * @param z Z-coordinate of the block
     * @return Highest non-empty block
     */
    @Override
    public Block getHighestBlockAt(int x, int z) {
        return this.getBlockAt(x, this.getHighestBlockYAt(x, z), z);
    }

    /**
     * Gets the highest non-empty block at the given coordinates
     *
     * @param location Coordinates to get the highest block
     * @return Highest non-empty block
     */
    @Override
    public Block getHighestBlockAt(Location location) {
        return this.getHighestBlockAt(location.getBlockX(), location.getBlockY());
    }

    /**
     * Gets the {@link Chunk} at the given coordinates
     *
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     * @return Chunk at the given coordinates
     */
    @Override
    public Chunk getChunkAt(int x, int z) {
        return new LBChunk(this.world.getChunkFromChunkCoords(x, z));
    }

    /**
     * Gets the {@link Chunk} at the given {@link Location}
     *
     * @param location Location of the chunk
     * @return Chunk at the given location
     */
    @Override
    public Chunk getChunkAt(Location location) {
        return this.getChunkAt(location.getBlockX(), location.getBlockZ());
    }

    /**
     * Gets the {@link Chunk} that contains the given {@link Block}
     *
     * @param block Block to get the containing chunk from
     * @return The chunk that contains the given block
     */
    @Override
    public Chunk getChunkAt(Block block) {
        return new LBChunk(this.world.getChunkFromBlockCoords(block.getX(), block.getY()));
    }

    /**
     * Checks if the specified {@link Chunk} is loaded
     *
     * @param chunk The chunk to check
     * @return true if the chunk is loaded, otherwise false
     */
    @Override
    public boolean isChunkLoaded(Chunk chunk) {
        for (Chunk lbchunk : this.getLoadedChunks()) {
            if (lbchunk.equals(chunk)) return lbchunk.isLoaded();
        }
        return false;
    }

    /**
     * Gets an array of all loaded {@link Chunk}s
     *
     * @return Chunk[] containing all loaded chunks
     */
    @Override
    public Chunk[] getLoadedChunks() {
        /*
            TODO:
            Implement a solution that will go over all chunks beginning with the [1,1], [1,-1], [-1,1] and [-1,-1] in groups of 3x3 and check if they are loaded.
            Since ChunkProviderServer and WorldServer do not provide useful functionality due to the Alpha level format,
            a possible solution would be iteration until we stumble upon at least N unloaded chunks and exit the loop,
            but this will cause the server to mark the far chunks as unloaded.
            E.g. a player that has reached the Farlands would be considered by LilyBukkit to be in an unloaded chunk,
            when in reality, it is loaded and is consuming resources (and MinecraftServer is probably aware of that, but I might be wrong).

            Damn, I think I'll have to modify the sources...
         */
        /*
        A bad solution, but whatever
        */
        return loadedChunks.toArray(new Chunk[]{});
    }

    /**
     * Loads the specified {@link Chunk}
     *
     * @param chunk The chunk to load
     */
    @Override
    public void loadChunk(Chunk chunk) {
        if (chunk.load()) this.loadedChunks.add(chunk);
    }

    /**
     * Checks if the {@link Chunk} at the specified coordinates is loaded
     *
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     * @return true if the chunk is loaded, otherwise false
     */
    @Override
    public boolean isChunkLoaded(int x, int z) {
        return this.isChunkLoaded(this.getChunkAt(x, z));
    }

    /**
     * Loads the {@link Chunk} at the specified coordinates
     * <p>
     * If the chunk does not exist, it will be generated.
     * This method is analogous to {@link #loadChunk(int, int, boolean)} where generate is true.
     *
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     */
    @Override
    public void loadChunk(int x, int z) {
        this.loadChunk(this.getChunkAt(x, z));
    }

    /**
     * Loads the {@link Chunk} at the specified coordinates
     *
     * @param x        X-coordinate of the chunk
     * @param z        Z-coordinate of the chunk
     * @param generate Whether or not to generate a chunk if it doesn't already exist
     * @return true if the chunk has loaded successfully, otherwise false
     */
    @Override
    public boolean loadChunk(int x, int z, boolean generate) {
        boolean flag = this.getChunkAt(x, z).load(generate);
        if (flag) this.loadedChunks.add(this.getChunkAt(x, z));
        return flag;
    }

    /**
     * Safely unloads and saves the {@link Chunk} at the specified coordinates
     * <p>
     * This method is analogous to {@link #unloadChunk(int, int, boolean, boolean)} where safe and saveis true
     *
     * @param chunk the chunk to unload
     * @return true if the chunk has unloaded successfully, otherwise false
     */
    @Override
    public boolean unloadChunk(Chunk chunk) {
        return this.unloadChunk(chunk.getX(), chunk.getZ());
    }

    /**
     * Safely unloads and saves the {@link Chunk} at the specified coordinates
     * <p>
     * This method is analogous to {@link #unloadChunk(int, int, boolean, boolean)} where safe and saveis true
     *
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     * @return true if the chunk has unloaded successfully, otherwise false
     */
    @Override
    public boolean unloadChunk(int x, int z) {
        return this.unloadChunk(x, z, true, true);
    }

    /**
     * Safely unloads and optionally saves the {@link Chunk} at the specified coordinates
     * <p>
     * This method is analogous to {@link #unloadChunk(int, int, boolean, boolean)} where save is true
     *
     * @param x    X-coordinate of the chunk
     * @param z    Z-coordinate of the chunk
     * @param save Whether or not to save the chunk
     * @return true if the chunk has unloaded successfully, otherwise false
     */
    @Override
    public boolean unloadChunk(int x, int z, boolean save) {
        return this.unloadChunk(x, z, save, true);
    }

    /**
     * Unloads and optionally saves the {@link Chunk} at the specified coordinates
     *
     * @param x    X-coordinate of the chunk
     * @param z    Z-coordinate of the chunk
     * @param save Controls whether the chunk is saved
     * @param safe Controls whether to unload the chunk when players are nearby
     * @return true if the chunk has unloaded successfully, otherwise false
     */
    @Override
    public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
        boolean flag = this.getChunkAt(x, z).unload(save, safe);
        if (flag) this.loadedChunks.remove(this.getChunkAt(x, z));
        return flag;
    }

    /**
     * Safely queues the {@link Chunk} at the specified coordinates for unloading
     * <p>
     * This method is analogous to {@link #unloadChunkRequest(int, int, boolean)} where safe is true
     *
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     * @return true is the queue attempt was successful, otherwise false
     */
    @Override
    public boolean unloadChunkRequest(int x, int z) {
        return this.unloadChunkRequest(x, z, true);
    }

    /**
     * Queues the {@link Chunk} at the specified coordinates for unloading
     *
     * @param x    X-coordinate of the chunk
     * @param z    Z-coordinate of the chunk
     * @param safe Controls whether to queue the chunk when players are nearby
     * @return Whether the chunk was actually queued
     */
    @Override
    public boolean unloadChunkRequest(int x, int z, boolean safe) {
        return Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("Minecraft"), () -> unloadChunk(x, z, true, safe)) != -1;
    }

    /**
     * Regenerates the {@link Chunk} at the specified coordinates
     *
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     * @return Whether the chunk was actually regenerated
     */
    @Override
    public boolean regenerateChunk(int x, int z) {
        return this.getChunkAt(x, z).unload(true, true) && this.getChunkAt(x, z).load(true);
    }

    /**
     * Resends the {@link Chunk} to all clients
     *
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     * @return Whether the chunk was actually refreshed
     */
    @Override
    public boolean refreshChunk(int x, int z) {
        return this.getChunkAt(x, z).unload(true, true) && this.getChunkAt(x, z).load(false);
    }

    /**
     * Drops an item at the specified {@link Location}
     *
     * @param location Location to drop the item
     * @param item     ItemStack to drop
     * @return ItemDrop entity created as a result of this method
     */
    @Override
    public Item dropItem(Location location, ItemStack item) {
        return new LBItem(this, this.world.getClosestPlayer(location.getBlockX(), location.getBlockY(), location.getBlockZ(), 16.0).dropItem(item.getTypeId(), item.getAmount()));
    }

    /**
     * Drops an item at the specified {@link Location} with a random offset
     *
     * @param location Location to drop the item
     * @param item     ItemStack to drop
     * @return ItemDrop entity created as a result of this method
     */
    @Override
    public Item dropItemNaturally(Location location, ItemStack item) {
        EntityItem i = new EntityItem(this.world, new Integer(location.getBlockX()).doubleValue(), new Integer(location.getBlockY()).doubleValue(), new Integer(location.getBlockZ()).doubleValue(), new net.minecraft.src.ItemStack(item.getTypeId(), item.getAmount(), item.getData().getData()));
        if (this.world.spawnEntityInWorld(i)) return new LBItem(this, i);
        return null;
    }

    /**
     * Creates an {@link Arrow} entity at the given {@link Location}
     *
     * @param location Location to spawn the arrow
     * @param velocity Velocity to shoot the arrow in
     * @param speed    Speed of the arrow. A recommend speed is 0.6
     * @param spread   Spread of the arrow. A recommend spread is 12
     * @return Arrow entity spawned as a result of this method
     */
    @Override
    public Arrow spawnArrow(Location location, Vector velocity, float speed, float spread) {
        EntityArrow e = new EntityArrow(this.world);
        e.setPosition(new Integer(location.getBlockX()).doubleValue(), new Integer(location.getBlockY()).doubleValue(), new Integer(location.getBlockZ()).doubleValue());
        e.setArrowHeading(velocity.getX(), velocity.getY(), velocity.getZ(), velocity.angle(new Vector(0, velocity.getY(), 0)), velocity.angle(new Vector(velocity.getX(), 0, 0)));
        if (this.world.spawnEntityInWorld(e)) return new LBArrow(this, e);
        return null;
    }

    /**
     * Creates a tree at the given {@link Location}
     *
     * @param location Location to spawn the tree
     * @param type     Type of the tree to create
     * @return true if the tree was created successfully, otherwise false
     */
    @Override
    public boolean generateTree(Location location, TreeType type) {
        return this.generateTree(location, type, new LBBlockChangeDelegate(this));
    }

    /**
     * Creates a tree at the given {@link Location}
     *
     * @param loc      Location to spawn the tree
     * @param type     Type of the tree to create
     * @param delegate A class to call for each block changed as a result of this method
     * @return true if the tree was created successfully, otherwise false
     */
    @Override
    public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate) {
        WorldGenTrees generator = new WorldGenTrees();
        return generator.generate(this.world, new Random(), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
    }

    /**
     * Creates a creature at the given {@link Location}
     *
     * @param loc  The location to spawn the creature
     * @param type The creature to spawn
     * @return Resulting LivingEntity of this method, or null if it was unsuccessful
     */
    @Override
    public LivingEntity spawnCreature(Location loc, CreatureType type) {
        switch (type) {
            case CHICKEN:
                return this.spawn(loc, LBChicken.class);
            case COW:
                return this.spawn(loc, LBCow.class);
            case PIG:
                return this.spawn(loc, LBPig.class);
            case GIANT:
                return this.spawn(loc, LBGiant.class);
            case SHEEP:
                return this.spawn(loc, LBSheep.class);
            case SLIME:
                return this.spawn(loc, LBSlime.class);
            case SPIDER:
                return this.spawn(loc, LBSpider.class);
            case ZOMBIE:
                return this.spawn(loc, LBZombie.class);
            case CREEPER:
                return this.spawn(loc, LBCreeper.class);
            case SKELETON:
                return this.spawn(loc, LBSkeleton.class);
            case MONSTER:
            default:
                return null;
        }
    }

    /**
     * Get a list of all entities in this World
     *
     * @return A List of all Entities currently residing in this world
     */
    @Override
    public List<Entity> getEntities() {
        List<net.minecraft.src.Entity> loadedEntities = this.world.loadedEntityList;
        List<Entity> entities = new ArrayList<>();
        for (net.minecraft.src.Entity e : loadedEntities) {
            entities.add((Entity) e);
        }
        return entities;
    }

    /**
     * Get a list of all living entities in this World
     *
     * @return A List of all LivingEntities currently residing in this world
     */
    @Override
    public List<LivingEntity> getLivingEntities() {
        List<net.minecraft.src.Entity> loadedEntities = this.world.loadedEntityList;
        List<LivingEntity> livingEntities = new ArrayList<>();
        for (net.minecraft.src.Entity e : loadedEntities) {
            if (e instanceof net.minecraft.src.EntityLiving) {
                livingEntities.add((LivingEntity) e);
            }
        }
        return livingEntities;
    }

    /**
     * Get a list of all players in this World
     *
     * @return A list of all Players currently residing in this world
     */
    @Override
    public List<Player> getPlayers() {
        List<net.minecraft.src.Entity> loadedEntities = this.world.loadedEntityList;
        List<Player> playerEntities = new ArrayList<>();
        for (net.minecraft.src.Entity e : loadedEntities) {
            if (e instanceof net.minecraft.src.EntityPlayer) {
                playerEntities.add(new LBPlayer(this, (EntityPlayerMP) e));
            }
        }
        return playerEntities;
    }

    /**
     * Gets the unique name of this world
     *
     * @return Name of this world
     */
    @Override
    public String getName() {
        return this.world.levelName;
    }

    /**
     * Gets the Unique ID of this world
     *
     * @return Unique ID of this world.
     */
    @Override
    public UUID getUID() {
        return UUID.fromString(this.getName());
    }

    /**
     * Gets a semi-unique identifier for this world.
     * <p>
     * While it is highly unlikely that this may be shared with another World,
     * it is not guaranteed to be unique
     *
     * @return Id of this world
     * @deprecated Replaced with {@link #getUID()}
     */
    @Override
    public long getId() {
        return new Long(this.getUID().toString());
    }

    /**
     * Gets the default spawn {@link Location} of this world
     *
     * @return The spawn location of this world
     */
    @Override
    public Location getSpawnLocation() {
        return new Location(this, this.world.spawnX, this.world.spawnY, this.world.spawnZ);
    }

    /**
     * Sets the spawn location of the world
     *
     * @return True if it was successfully set.
     */
    @Override
    public boolean setSpawnLocation(int x, int y, int z) {
        this.world.spawnX = x;
        this.world.spawnY = y;
        this.world.spawnZ = z;
        //TODO: Add additional check
        return true;
    }

    /**
     * Gets the relative in-game time of this world.
     * <p>
     * The relative time is analogous to hours * 1000
     *
     * @return The current relative time
     * @see #getFullTime() Returns an absolute time of this world
     */
    @Override
    public long getTime() {
        return this.world.worldTime;
    }

    /**
     * Sets the relative in-game time on the server.
     * <p>
     * The relative time is analogous to hours * 1000
     * <br /><br />
     * Note that setting the relative time below the current relative time will
     * actually move the clock forward a day. If you require to rewind time, please
     * see setFullTime
     *
     * @param time The new relative time to set the in-game time to (in hours*1000)
     * @see #setFullTime(long) Sets the absolute time of this world
     */
    @Override
    public void setTime(long time) {
        this.world.worldTime = time;
    }

    /**
     * Gets the full in-game time on this world
     *
     * @return The current absolute time
     * @see #getTime() Returns a relative time of this world
     */
    @Override
    public long getFullTime() {
        return this.world.worldTime;
    }

    /**
     * Sets the in-game time on the server
     * <br /><br />
     * Note that this sets the full time of the world, which may cause adverse
     * effects such as breaking Greenstone clocks and any scheduled events
     *
     * @param time The new absolute time to set this world to
     * @see #setTime(long) Sets the relative time of this world
     */
    @Override
    public void setFullTime(long time) {
        this.world.worldTime = time;
    }

    /**
     * Creates explosion at given coordinates with given power
     *
     * @param power The power of explosion, where 4F is TNT
     * @return false if explosion was canceled, otherwise true
     */
    @Override
    public boolean createExplosion(double x, double y, double z, float power) {
        return this.createExplosion(x, y, z, power, false);
    }

    /**
     * Creates explosion at given coordinates with given power and optionally setting
     * blocks on fire.
     *
     * @param power   The power of explosion, where 4F is TNT
     * @param setFire Whether or not to set blocks on fire
     * @return false if explosion was canceled, otherwise true
     */
    @Override
    public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
        EntityPlayer p = this.world.getClosestPlayer(x, y, z, 0.0);
        this.world.createExplosion(p, x, y, z, power);
        return p != null;
    }

    /**
     * Creates explosion at given coordinates with given power
     *
     * @param power The power of explosion, where 4F is TNT
     * @return false if explosion was canceled, otherwise true
     */
    @Override
    public boolean createExplosion(Location loc, float power) {
        return this.createExplosion(loc, power, false);
    }

    /**
     * Creates explosion at given coordinates with given power and optionally setting
     * blocks on fire.
     *
     * @param power   The power of explosion, where 4F is TNT
     * @param setFire Whether or not to set blocks on fire
     * @return false if explosion was canceled, otherwise true
     */
    @Override
    public boolean createExplosion(Location loc, float power, boolean setFire) {
        return this.createExplosion(loc.getX(), loc.getY(), loc.getZ(), power, setFire);
    }

    /**
     * Gets the {@link Environment} type of this world
     *
     * @return This worlds Environment type
     */
    @Override
    public Environment getEnvironment() {
        return Environment.NORMAL;
    }

    /**
     * Gets the Seed for this world.
     *
     * @return This worlds Seed
     */
    @Override
    public long getSeed() {
        return this.world.randomSeed;
    }

    /**
     * Gets the current PVP setting for this world.
     */
    @Override
    public boolean getPVP() {
        return this.isPVPAllowed;
    }

    /**
     * Sets the PVP setting for this world.
     *
     * @param pvp True/False whether PVP should be Enabled.
     */
    @Override
    public void setPVP(boolean pvp) {
        this.isPVPAllowed = pvp;
    }

    /**
     * Gets the chunk generator for this world
     *
     * @return ChunkGenerator associated with this world
     */
    @Override
    public ChunkGenerator getGenerator() {
        return this.chunkGen;
    }

    /**
     * Saves world to disk
     */
    @Override
    public void save() {
        //TODO: Make the thing output to chat
        this.world.saveWorld(false, null);
    }

    /**
     * Gets a list of all applied {@link BlockPopulator}s for this World
     *
     * @return List containing any or none BlockPopulators
     */
    @Override
    public List<BlockPopulator> getPopulators() {
        return this.blockPopulatorList;
    }

    /**
     * Spawn an entity of a specific class at the given {@link Location}
     *
     * @param location the {@link Location} to spawn the entity at
     * @param clazz    the class of the {@link Entity} to spawn
     * @return an instance of the spawned {@link Entity}
     * @throws IllegalArgumentException if either parameter is null or the {@link org.bukkit.entity.Entity} requested cannot be spawned
     */
    @Override
    public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException {
        net.minecraft.src.Entity entityToSpawn = null;
        Entity entityToReturn = null;
        if (clazz.equals(LBArrow.class)) {
            entityToSpawn = new EntityArrow(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBArrow(this, (EntityArrow) entityToSpawn);
        } else if (clazz.equals(LBBoat.class)) {
            entityToSpawn = new EntityBoat(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBBoat(this, (EntityBoat) entityToSpawn);
        } else if (clazz.equals(LBChicken.class)) {
            entityToSpawn = new EntityChicken(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBChicken(this, (EntityChicken) entityToSpawn);
        } else if (clazz.equals(LBCow.class)) {
            entityToSpawn = new EntityCow(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBCow(this, (EntityCow) entityToSpawn);
        } else if (clazz.equals(LBCreeper.class)) {
            entityToSpawn = new EntityCreeper(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBCreeper(this, (EntityCreeper) entityToSpawn);
        } else if (clazz.equals(LBFallingSand.class)) {
            entityToSpawn = new EntityFallingSand(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBFallingSand(this, (EntityFallingSand) entityToSpawn);
        } else if (clazz.equals(LBGiant.class)) {
            entityToSpawn = new EntityGiantZombie(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBGiant(this, (EntityGiantZombie) entityToSpawn);
        }/* else if (clazz.equals(LBItem.class)) {
            entityToSpawn = new EntityItem(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBItem(this, (EntityItem) entityToSpawn);
        }*/ else if (clazz.equals(LBMinecart.class)) {
            entityToSpawn = new EntityMinecart(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBMinecart(this, (EntityMinecart) entityToSpawn);
        } else if (clazz.equals(LBPig.class)) {
            entityToSpawn = new EntityPig(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBPig(this, (EntityPig) entityToSpawn);
        } else if (clazz.equals(LBSheep.class)) {
            entityToSpawn = new EntitySheep(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBSheep(this, (EntitySheep) entityToSpawn);
        } else if (clazz.equals(LBSkeleton.class)) {
            entityToSpawn = new EntitySkeleton(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBSkeleton(this, (EntitySkeleton) entityToSpawn);
        } else if (clazz.equals(LBSlime.class)) {
            entityToSpawn = new EntitySlime(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBSlime(this, (EntitySlime) entityToSpawn);
        } else if (clazz.equals(LBSnowball.class)) {
            entityToSpawn = new EntitySnowball(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBSnowball(this, (EntitySnowball) entityToSpawn);
        } else if (clazz.equals(LBSpider.class)) {
            entityToSpawn = new EntitySpider(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBSpider(this, (EntitySpider) entityToSpawn);
        } else if (clazz.equals(LBTNTPrimed.class)) {
            entityToSpawn = new EntityTNTPrimed(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBTNTPrimed(this, (EntityTNTPrimed) entityToSpawn);
        } else if (clazz.equals(LBZombie.class)) {
            entityToSpawn = new EntityZombie(this.world);
            entityToSpawn.setPosition(location.getX(), location.getY(), location.getZ());
            entityToReturn = new LBZombie(this, (EntityZombie) entityToSpawn);
        }
        if (entityToSpawn != null && this.world.spawnEntityInWorld(entityToSpawn)) return (T) entityToReturn;
        else throw new IllegalArgumentException("Can't spawn entity");
    }

    /**
     * Plays an effect to all players within a default radius around a given location.
     *
     * @param location the {@link Location} around which players must be to hear the sound
     * @param effect   the {@link Effect}
     * @param data     a data bit needed for the RECORD_PLAY, SMOKE, and STEP_SOUND sounds
     */
    @Override
    public void playEffect(Location location, Effect effect, int data) {
        this.playEffect(location, effect, data, Bukkit.getServer().getSpawnRadius()); // Yeah...
    }

    /**
     * Plays an effect to all players within a given radius around a location.
     *
     * @param location the {@link Location} around which players must be to hear the effect
     * @param effect   the {@link Effect}
     * @param data     a data bit needed for the RECORD_PLAY, SMOKE, and STEP effects
     * @param radius   the radius around the location
     */
    @Override
    public void playEffect(Location location, Effect effect, int data, int radius) {
        for (Player p : this.getPlayers()) {
            if (p.getLocation().distance(location) <= radius) {
                p.playEffect(location, effect, data);
            }
        }
    }

    /**
     * Get empty chunk snapshot (equivalent to all air blocks), optionally including valid biome
     * data.  Used for representing an ungenerated chunk, or for fetching only biome data without loading a chunk.
     *
     * @param x - chunk x coordinate
     * @param z - chunk z coordinate
     */
    @Override
    public ChunkSnapshot getEmptyChunkSnapshot(int x, int z) {
        return new LBChunkSnapshot(new LBChunk(new net.minecraft.src.Chunk(this.world, x, z)), this.getFullTime(), false);
    }

    /**
     * Sets the spawn flags for this.
     *
     * @param allowMonsters - if true, monsters are allowed to spawn in this world.
     * @param allowAnimals  - if true, animals are allowed to spawn in this world.
     */
    @Override
    public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
        this.allowAnimals = allowAnimals;
        this.allowMonsters = allowMonsters;
    }

    /**
     * Gets whether animals can spawn in this world.
     *
     * @return whether animals can spawn in this world.
     */
    @Override
    public boolean getAllowAnimals() {
        return this.allowAnimals;
    }

    /**
     * Gets whether monsters can spawn in this world.
     *
     * @return whether monsters can spawn in this world.
     */
    @Override
    public boolean getAllowMonsters() {
        return this.allowMonsters;
    }

    /**
     * Gets the maximum height of this world.
     * <p>
     * If the max height is 100, there are only blocks from y=0 to y=99.
     *
     * @return Maximum height of the world
     */
    @Override
    public int getMaxHeight() {
        return 128;
    }

    /**
     * Gets whether the world's spawn area should be kept loaded into memory or not.
     *
     * @return true if the world's spawn area will be kept loaded into memory.
     */
    @Override
    public boolean getKeepSpawnInMemory() {
        return this.spawnInMemory;
    }

    /**
     * Sets whether the world's spawn area should be kept loaded into memory or not.
     *
     * @param keepLoaded if true then the world's spawn area will be kept loaded into memory.
     */
    @Override
    public void setKeepSpawnInMemory(boolean keepLoaded) {
        this.spawnInMemory = keepLoaded;
    }

    @Override
    public boolean isWinter() {
        return this.world.snowCovered;
    }
}
