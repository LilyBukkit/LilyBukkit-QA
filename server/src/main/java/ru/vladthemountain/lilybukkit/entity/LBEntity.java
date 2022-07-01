package ru.vladthemountain.lilybukkit.entity;

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

public class LBEntity implements Entity {

    LBWorld world;
    net.minecraft.src.Entity entity;


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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the entity's current fire ticks (ticks before the entity stops being on fire).
     *
     * @return int fireTicks
     */
    @Override
    public int getFireTicks() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the entity's maximum fire ticks.
     *
     * @return int maxFireTicks
     */
    @Override
    public int getMaxFireTicks() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the entity's current fire ticks (ticks before the entity stops being on fire).
     *
     * @param ticks
     */
    @Override
    public void setFireTicks(int ticks) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Mark the entity's removal.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns true if this entity has been marked for removal.
     */
    @Override
    public boolean isDead() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the {@link Server} that contains this Entity
     *
     * @return Server instance running this Entity
     */
    @Override
    public Server getServer() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the primary passenger of a vehicle. For vehicles that could have
     * multiple passengers, this will only return the primary passenger.
     *
     * @return an entity
     */
    @Override
    public Entity getPassenger() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the passenger of a vehicle.
     *
     * @param passenger
     * @return false if it could not be done for whatever reason
     */
    @Override
    public boolean setPassenger(Entity passenger) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns true if the vehicle has no passengers.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Eject any passenger. True if there was a passenger.
     *
     * @return
     */
    @Override
    public boolean eject() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the distance this entity has fallen
     *
     * @return
     */
    @Override
    public float getFallDistance() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the fall distance for this entity
     *
     * @param distance
     */
    @Override
    public void setFallDistance(float distance) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Record the last {@link EntityDamageEvent} inflicted on this entity
     *
     * @param event a {@link EntityDamageEvent}
     */
    @Override
    public void setLastDamageCause(EntityDamageEvent event) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Retrieve the last {@link EntityDamageEvent} inflicted on this entity. This event may have been cancelled.
     *
     * @return the last known {@link EntityDamageEvent} or null if hitherto unharmed
     */
    @Override
    public EntityDamageEvent getLastDamageCause() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns a unique and persistent id for this entity
     *
     * @return unique id
     */
    @Override
    public UUID getUniqueId() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
