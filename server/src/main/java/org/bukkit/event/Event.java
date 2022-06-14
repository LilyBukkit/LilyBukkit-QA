package org.bukkit.event;

import java.io.Serializable;

import static org.bukkit.event.Event.Category.*;

/**
 * Represents an event
 */
public abstract class Event implements Serializable {
    private final Type type;
    private final String name;

    protected Event(final Type type) {
        exAssert(type != null, "type is null");
        exAssert(type != Type.CUSTOM_EVENT, "use Event(String) to make custom events");
        this.type = type;
        this.name = null;
    }

    protected Event(final String name) {
        exAssert(name != null, "name is null");
        this.type = Type.CUSTOM_EVENT;
        this.name = name;
    }

    /**
     * Gets the Type of this event
     * @return Event type that this object represents
     */
    public final Type getType() {
        return type;
    }

    private void exAssert(boolean b, String s) {
        if(!b) throw new IllegalArgumentException(s);
    }

    /**
     * Gets the event's name. Should only be used if getType() == Type.CUSTOM
     *
     * @return Name of this event
     */
    public final String getEventName() {
        return ( type != Type.CUSTOM_EVENT) ? type.toString() : name;
    }

    /**
     * Represents an events priority in execution
     */
    public enum Priority {
        /**
         * Event call is of very low importance and should be ran first, to allow
         * other plugins to further customise the outcome
         */
        Lowest,

        /**
         * Event call is of low importance
         */
        Low,

        /**
         * Event call is neither important or unimportant, and may be ran normally
         */
        Normal,

        /**
         * Event call is of high importance
         */
        High,

        /**
         * Event call is critical and must have the final say in what happens
         * to the event
         */
        Highest,

        /**
         * Event is listened to purely for monitoring the outcome of an event.
         *
         * No modifications to the event should be made under this priority
         */
        Monitor
    }

    /**
     * Represents a category used by Type
     */
    public enum Category {
        /**
         * Represents Player-based events
         * @see #LIVING_ENTITY
         */
        PLAYER,

        /**
         * Represents Block-based events
         */
        BLOCK,

        /**
         * Represents LivingEntity-based events
         */
        LIVING_ENTITY,

        /**
         * Represents Vehicle-based events
         */
        VEHICLE,

        /**
         * Represents World-based events
         */
        WORLD,

        /**
         * Represents Server and Plugin based events
         */
        SERVER,

        /**
         * Represents Inventory-based events
         */
        INVENTORY,

        /**
         * Any miscellaneous events
         */
        MISCELLANEOUS;
    }

    /**
     * Provides a lookup for all core events
     *
     * @see org.bukkit.event.Event
     */
    public enum Type {
        /**
         * PLAYER EVENTS
         */

        /**
         * Called when a player enters the world on a server
         *
         * @see org.bukkit.event.player.PlayerEvent
         */
        PLAYER_JOIN (PLAYER),

        /**
         * Called when a player is attempting to connect to the server
         *
         * @see org.bukkit.event.player.PlayerLoginEvent
         */
        PLAYER_LOGIN (PLAYER),

        /**
         * Called when a player respawns
         *
         * @see org.bukkit.event.player.PlayerEvent
         */
        PLAYER_RESPAWN (PLAYER),

        /**
         * Called when a player gets kicked a server
         *
         * @see org.bukkit.event.player.PlayerEvent
         */
        PLAYER_KICK (PLAYER),

        /**
         * Called when a player sends a chat message
         *
         * @see org.bukkit.event.player.PlayerChatEvent
         */
        PLAYER_CHAT (PLAYER),

        /**
         * Called when a player early in the command handling process
         *
         * @see org.bukkit.event.player.PlayerChatEvent
         */
        PLAYER_COMMAND_PREPROCESS (PLAYER),

        /**
         * Called when a player leaves a server
         *
         * @see org.bukkit.event.player.PlayerEvent
         */
        PLAYER_QUIT (PLAYER),

        /**
         * Called when a player moves position in the world
         *
         * @see org.bukkit.event.player.PlayerMoveEvent
         */
        PLAYER_MOVE (PLAYER),

        /**
         * Called when a player undergoes an animation, such as arm swinging
         *
         * @see org.bukkit.event.player.PlayerAnimationEvent
         */
        PLAYER_ANIMATION (PLAYER),

        /**
         * Called when a player toggles sneak mode
         *
         * @todo: add javadoc see comment
         */
        PLAYER_TOGGLE_SNEAK (PLAYER),

        /**
         * Called when a player uses an item
         *
         * @see org.bukkit.event.player.PlayerInteractEvent
         */
        PLAYER_INTERACT (PLAYER),

        /**
         * Called when a player throws an egg and it might hatch
         *
         * @see org.bukkit.event.player.PlayerEggThrowEvent
         */
        PLAYER_EGG_THROW (PLAYER),

        /**
         * Called when a player teleports from one position to another
         *
         * @see org.bukkit.event.player.PlayerMoveEvent
         */
        PLAYER_TELEPORT (PLAYER),

        /**
         * Called when a player changes their held item
         *
         * @see org.bukkit.event.player.PlayerItemHeldEvent
         */
        PLAYER_ITEM_HELD (PLAYER),

        /**
         * Called when a player drops an item
         *
         * @see org.bukkit.event.player.PlayerDropItemEvent
         */
        PLAYER_DROP_ITEM (PLAYER),

        /**
         * Called when a player picks an item up off the ground
         *
         * @see org.bukkit.event.player.PlayerPickupItemEvent
         */
        PLAYER_PICKUP_ITEM (PLAYER),

        /**
         * Called when a player empties a bucket
         * 
         * @see org.bukkit.event.player.PlayerBucketEmptyEvent
         */
        PLAYER_BUCKET_EMPTY(PLAYER),

        /**
         * Called when a player fills a bucket
         * 
         * @see org.bukkit.event.player.PlayerBucketFillEvent
         */
        PLAYER_BUCKET_FILL(PLAYER),

        /**
         * Called when a player interacts with the inventory
         *
         * @see org.bukkit.event.player.PlayerInventoryEvent
         */
        PLAYER_INVENTORY(PLAYER),
        
        /**
         * Called when a player enter a bed
         * 
         * @see org.bukkit.event.player.PlayerBedEnterEvent
         */
        PLAYER_BED_ENTER(PLAYER),
        
        /**
         * Called when a player leaves a bed
         * 
         * @see org.bukkit.event.player.PlayerBedEnterEvent
         */
        PLAYER_BED_LEAVE(PLAYER),
        
        /**
         * BLOCK EVENTS
         */

        /**
         * Called when a block is damaged (hit by a player)
         *
         * @see org.bukkit.event.block.BlockDamageEvent
         */
        BLOCK_DAMAGE (BLOCK),

        /**
         * Called when a block is undergoing a universe physics
         * check on whether it can be built
         *
         * For example, cacti cannot be built on grass unless overridden here
         *
         * @see org.bukkit.event.block.BlockCanBuildEvent
         */
        BLOCK_CANBUILD (BLOCK),

        /**
         * Called when a block of water or lava attempts to flow into another
         * block
         *
         * @see org.bukkit.event.block.BlockFromToEvent
         */
        BLOCK_FROMTO (BLOCK),

        /**
         * Called when a block is being set on fire from another block, such as
         * an adjacent block of fire attempting to set fire to wood
         *
         * @see org.bukkit.event.block.BlockIgniteEvent
         */
        BLOCK_IGNITE (BLOCK),

        /**
         * Called when a block undergoes a physics check
         *
         * A physics check is commonly called when an adjacent block changes
         * type
         *
         * @see org.bukkit.event.block.BlockPhysicsEvent
         */
        BLOCK_PHYSICS (BLOCK),

        /**
         * Called when a player is attempting to place a block
         *
         * @see org.bukkit.event.block.BlockPlaceEvent
         */
        BLOCK_PLACE (BLOCK),

        /**
         * Called when a block is destroyed from being burnt by fire
         *
         * @see org.bukkit.event.block.BlockBurnEvent
         */
        BLOCK_BURN (BLOCK),

        /**
         * Called when leaves are decaying naturally
         *
         * @see org.bukkit.event.block.LeavesDecayEvent
         */
        LEAVES_DECAY (BLOCK),

        /**
         * Called when a sign is changed
         *
         * @see org.bukkit.event.block.SignChangeEvent
         */
        SIGN_CHANGE (BLOCK),

        /**
         * Called when a block changes redstone current. Only triggered on blocks
         * that are actually capable of transmitting or carrying a redstone
         * current
         *
         * @see org.bukkit.event.block.BlockFromToEvent
         */
        REDSTONE_CHANGE (BLOCK),

        /**
         * Called when a block is destroyed by a player.
         *
         * @see org.bukkit.event.block.BlockBreakEvent
         */
        BLOCK_BREAK (BLOCK),

        /**
         * INVENTORY EVENTS
         */

        /**
         * Called when a player opens an inventory
         *
         * @todo: add javadoc see comment
         */
        INVENTORY_OPEN (INVENTORY),

        /**
         * Called when a player closes an inventory
         *
         * @todo: add javadoc see comment
         */
        INVENTORY_CLOSE (INVENTORY),

        /**
         * Called when a player clicks on an inventory slot
         *
         * @todo: add javadoc see comment
         */
        INVENTORY_CLICK (INVENTORY),

        /**
         * Called when an inventory slot changes values or type
         *
         * @todo: add javadoc see comment
         */
        INVENTORY_CHANGE (INVENTORY),

        /**
         * Called when a player is attempting to perform an inventory transaction
         *
         * @todo: add javadoc see comment
         */
        INVENTORY_TRANSACTION (INVENTORY),

        /**
         * SERVER EVENTS
         */

        /**
         * Called when a plugin is enabled
         *
         * @see org.bukkit.event.server.PluginEvent
         */
        PLUGIN_ENABLE (SERVER),

        /**
         * Called when a plugin is disabled
         *
         * @see org.bukkit.event.server.PluginEvent
         */
        PLUGIN_DISABLE (SERVER),

        /**
         * Called when a server command is called
         *
         * @see org.bukkit.event.server.PluginEvent
         */
        SERVER_COMMAND (SERVER),

        /**
         * WORLD EVENTS
         */

        /**
         * Called when a chunk is loaded
         *
         * If a new chunk is being generated for loading, it will call
         * Type.CHUNK_GENERATION and then Type.CHUNK_LOADED upon completion
         *
         * @see org.bukkit.event.world.ChunkLoadEvent
         */
        CHUNK_LOAD (WORLD),

        /**
         * Called when a chunk is unloaded
         *
         * @see org.bukkit.event.world.ChunkUnloadEvent
         */
        CHUNK_UNLOAD (WORLD),

        /**
         * Called when a chunk needs to be generated
         *
         * @todo: add javadoc see comment
         */
        CHUNK_GENERATION (WORLD),

        /**
         * Called when an ItemEntity spawns in the world
         *
         * @todo: add javadoc see comment
         */
        ITEM_SPAWN (WORLD),

        /**
         * Called when a World's spawn is changed
         *
         * @see org.bukkit.event.world.SpawnChangeEvent
         */
        SPAWN_CHANGE (WORLD),

        /**
         * Called when a world is saved
         * 
         */
        WORLD_SAVE (WORLD),

        /**
         * Called when a World is loaded
         */
        WORLD_LOAD (WORLD),

        /**
         * LIVING_ENTITY EVENTS
         */

        /**
         * Called when a creature, either hostile or neutral, attempts to spawn
         * in the world "naturally"
         *
         * @todo: add javadoc see comment
         */
        CREATURE_SPAWN (LIVING_ENTITY),

        /**
         * Called when a LivingEntity is damaged with no source.
         *
         * @see org.bukkit.event.entity.EntityDamageEvent
         */
        ENTITY_DAMAGE (LIVING_ENTITY),

        /**
         * Called when a LivingEntity dies
         *
         * @todo: add javadoc see comment
         */
        ENTITY_DEATH (LIVING_ENTITY),

        /**
         * Called when a Skeleton or Zombie catch fire due to the sun
         *
         * @todo: add javadoc see comment
         */
        ENTITY_COMBUST (LIVING_ENTITY),

        /**
         * Called when an entity explodes, either TNT, Creeper, or Ghast Fireball
         *
         * @todo: add javadoc see comment
         */
        ENTITY_EXPLODE (LIVING_ENTITY),

        /**
         * Called when an entity has made a decision to explode.
         * 
         * Provides an opportunity to act on the entity, change the explosion radius,
         * or to change the fire-spread flag.
         * 
         * Canceling the event negates the entity's decision to explode.
         * For EntityCreeper, this resets the fuse but does not kill the Entity.
         * For EntityFireball and EntityTNTPrimed....?
         * 
         * @see org.bukkit.event.entity.ExplosionPrimeEvent
         */
        EXPLOSION_PRIME (LIVING_ENTITY),

        /**
         * Called when an entity targets another entity
         *
         * @see org.bukkit.event.entity.EntityTargetEvent
         */
        ENTITY_TARGET (LIVING_ENTITY),
        
        /**
         * Called when an entity interacts with a block
         * This event specifically excludes player entities
         * 
         * @see org.bukkit.event.entity.EntityInteractEvent
         */
        ENTITY_INTERACT (LIVING_ENTITY),

        /**
         * VEHICLE EVENTS
         */

        /**
         * Called when a vehicle is placed by a player
         *
         * @see org.bukkit.event.vehicle.VehicleCreateEvent
         */
        VEHICLE_CREATE (VEHICLE),

        /**
         * Called when a vehicle is destroyed
         *
         * @see org.bukkit.event.vehicle.VehicleDestroyEvent
         */
        VEHICLE_DESTROY (VEHICLE),

        /**
         * Called when a vehicle is damaged by a LivingEntity
         *
         * @see org.bukkit.event.vehicle.VehicleDamageEvent
         */
        VEHICLE_DAMAGE (VEHICLE),

        /**
         * Called when a vehicle collides with an Entity
         *
         * @see org.bukkit.event.vehicle.VehicleCollisionEvent
         */
        VEHICLE_COLLISION_ENTITY (VEHICLE),

        /**
         * Called when a vehicle collides with a Block
         *
         * @see org.bukkit.event.vehicle.VehicleBlockCollisionEvent
         */
        VEHICLE_COLLISION_BLOCK (VEHICLE),

        /**
         * Called when a vehicle is entered by a LivingEntity
         *
         * @see org.bukkit.event.vehicle.VehicleEnterEvent
         */
        VEHICLE_ENTER (VEHICLE),

        /**
         * Called when a vehicle is exited by a LivingEntity
         *
         * @see org.bukkit.event.vehicle.VehicleExitEvent
         */
        VEHICLE_EXIT (VEHICLE),

        /**
         * Called when a vehicle moves position in the world
         *
         * @see org.bukkit.event.vehicle.VehicleMoveEvent
         */
        VEHICLE_MOVE (VEHICLE),

        /**
         * Called when a vehicle is going through an update cycle, rechecking itself
         *
         * @see org.bukkit.event.vehicle.VehicleUpdateEvent
         */
        VEHICLE_UPDATE (VEHICLE),

        /**
         * MISCELLANEOUS EVENTS
         */

        /**
         * Represents a custom event, isn't actually used
         */
        CUSTOM_EVENT (MISCELLANEOUS);

        private final Category category;

        private Type(Category category) {
            this.category = category;
        }

        /**
         * Gets the Category assigned to this event
         *
         * @return Category of this Event.Type
         */
        public Category getCategory() {
            return category;
        }
    }

    public enum Result {
        /**
         * Deny the event.
         * Depending on the event, the action indicated by the event will either not take place or will be reverted.
         * Some actions may not be denied.
         */
        DENY,

        /**
         * Neither deny nor allow the event.
         * The server will proceed with its normal handling.
         */
        DEFAULT,

        /**
         * Allow / Force the event.
         * The action indicated by the event will take place if possible, even if the server would not normally allow the action.
         * Some actions may not be allowed.
         */
        ALLOW;
    }
}
