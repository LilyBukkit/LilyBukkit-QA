package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;
import ru.vladthemountain.lilybukkit.LBWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author VladTheMountain
 */
public class LBEntity implements Entity {

    LBWorld world;
    net.minecraft.src.Entity entity;
    EntityDamageEvent lastDamageCause;

    public LBEntity(LBWorld w, net.minecraft.src.Entity e) {
        this.world = w;
        this.entity = e;
    }


    /**
     * Gets the entity's current position
     *
     * @return Location containing the position of this entity
     */
    @Override
    public Location getLocation() {
        return new Location(this.world, this.entity.posX, this.entity.posY, this.entity.posZ);
    }

    /**
     * Sets this entity's velocity
     *
     * @param velocity New velocity to travel with
     */
    @Override
    public void setVelocity(Vector velocity) {
        this.entity.motionX = velocity.getX();
        this.entity.motionY = velocity.getY();
        this.entity.motionZ = velocity.getZ();
    }

    /**
     * Gets this entity's current velocity
     *
     * @return Current travelling velocity of this entity
     */
    @Override
    public Vector getVelocity() {
        return new Vector(this.entity.motionX, this.entity.motionY, this.entity.motionZ);
    }

    /**
     * Gets the current world this entity resides in
     *
     * @return World
     */
    @Override
    public World getWorld() {
        return this.world;
    }

    /**
     * Teleports this entity to the given location
     *
     * @param location New location to teleport this entity to
     * @return <code>true</code> if the teleport was successful
     */
    @Override
    public boolean teleport(Location location) {
        this.entity.setPosition(location.getX(), location.getY(), location.getZ());
        return this.getLocation().equals(location);
    }

    /**
     * Teleports this entity to the target Entity
     *
     * @param destination Entity to teleport this entity to
     * @return <code>true</code> if the teleport was successful
     */
    @Override
    public boolean teleport(Entity destination) {
        return this.teleport(destination.getLocation());
    }

    /**
     * Returns a list of entities within a bounding box defined by x,y,z centered around player
     *
     * @param x Size of the box along x axis
     * @param y Size of the box along y axis
     * @param z Size of the box along z axis
     * @return List<Entity> List of entities nearby
     */
    @Override
    public List<Entity> getNearbyEntities(double x, double y, double z) {
        List<Entity> nearbyEntities = new ArrayList<>();

        return nearbyEntities;
    }

    /**
     * Returns a unique id for this entity
     *
     * @return Entity id
     */
    @Override
    public int getEntityId() {
        return this.entity.entityID;
    }

    /**
     * Returns the entity's current fire ticks (ticks before the entity stops being on fire).
     *
     * @return int fireTicks
     */
    @Override
    public int getFireTicks() {
        return this.entity.fire;
    }

    /**
     * Returns the entity's maximum fire ticks.
     *
     * @return int maxFireTicks
     */
    @Override
    public int getMaxFireTicks() {
        return this.entity.fireResistance;
    }

    /**
     * Sets the entity's current fire ticks (ticks before the entity stops being on fire).
     *
     * @param ticks
     */
    @Override
    public void setFireTicks(int ticks) {
        this.entity.fireResistance = ticks;
    }

    /**
     * Mark the entity's removal.
     */
    @Override
    public void remove() {
        this.entity.setEntityDead();
    }

    /**
     * Returns true if this entity has been marked for removal.
     */
    @Override
    public boolean isDead() {
        return this.entity.isDead;
    }

    /**
     * Gets the {@link Server} that contains this Entity
     *
     * @return Server instance running this Entity
     */
    @Override
    public Server getServer() {
        return Bukkit.getServer();
    }

    /**
     * Gets the primary passenger of a vehicle. For vehicles that could have
     * multiple passengers, this will only return the primary passenger.
     *
     * @return an entity
     */
    @Override
    public Entity getPassenger() {
        return new LBEntity(this.world, this.entity.riddenByEntity);
    }

    /**
     * Set the passenger of a vehicle.
     *
     * @param passenger
     * @return false if it could not be done for whatever reason
     */
    @Override
    public boolean setPassenger(Entity passenger) {
        net.minecraft.src.Entity passengerEntity = null;
        if (passenger instanceof LBPlayer) {
            passengerEntity = new EntityPlayer(this.world.getWorldServer());
        }
        //TODO add other entities
        this.entity.riddenByEntity = passengerEntity;
        return this.entity.riddenByEntity != null;
    }

    /**
     * Returns true if the vehicle has no passengers.
     */
    @Override
    public boolean isEmpty() {
        return this.entity.riddenByEntity == null;
    }

    /**
     * Eject any passenger. True if there was a passenger.
     */
    @Override
    public boolean eject() {
        this.entity.riddenByEntity.mountEntity(this.entity);
        return this.entity.riddenByEntity == null;
    }

    /**
     * Returns the distance this entity has fallen
     */
    @Override
    public float getFallDistance() {
        return (float) (this.entity.prevPosY - this.entity.posY);
    }

    /**
     * Sets the fall distance for this entity
     */
    @Override
    public void setFallDistance(float distance) {
        this.entity.prevPosY = this.entity.posY + distance;
    }

    /**
     * Record the last {@link EntityDamageEvent} inflicted on this entity
     *
     * @param event a {@link EntityDamageEvent}
     */
    @Override
    public void setLastDamageCause(EntityDamageEvent event) {
        this.lastDamageCause = event;
    }

    /**
     * Retrieve the last {@link EntityDamageEvent} inflicted on this entity. This event may have been cancelled.
     *
     * @return the last known {@link EntityDamageEvent} or null if hitherto unharmed
     */
    @Override
    public EntityDamageEvent getLastDamageCause() {
        return this.lastDamageCause;
    }

    /**
     * Returns a unique and persistent id for this entity
     *
     * @return unique id
     */
    @Override
    public UUID getUniqueId() {
        return UUID.fromString(String.valueOf(this.entity.entityID));
    }
}
