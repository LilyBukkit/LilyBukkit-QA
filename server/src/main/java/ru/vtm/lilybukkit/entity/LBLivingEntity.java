package ru.vtm.lilybukkit.entity;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.*;

import java.util.HashSet;
import java.util.List;

public class LBLivingEntity extends LBEntity implements LivingEntity {
    public LBLivingEntity(net.minecraft.src.Entity e) {
        super(e);
    }

    /**
     * Gets the entity's health from 0-20, where 0 is dead and 20 is full
     *
     * @return Health represented from 0-20
     */
    @Override
    public int getHealth() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the entity's health from 0-20, where 0 is dead and 20 is full
     *
     * @param health New health represented from 0-20
     */
    @Override
    public void setHealth(int health) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the height of the entity's head above its Location
     *
     * @return Height of the entity's eyes above its Location
     */
    @Override
    public double getEyeHeight() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the height of the entity's head above its Location
     *
     * @param ignoreSneaking@return Height of the entity's eyes above its Location
     */
    @Override
    public double getEyeHeight(boolean ignoreSneaking) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get a Location detailing the current eye position of the LivingEntity.
     *
     * @return a Location at the eyes of the LivingEntity.
     */
    @Override
    public Location getEyeLocation() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets all blocks along the player's line of sight
     * List iterates from player's position to target inclusive
     *
     * @param transparent
     * @param maxDistance
     * @return List containing all blocks along the player's line of sight
     */
    @Override
    public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the block that the player has targeted
     *
     * @param transparent
     * @param maxDistance
     * @return Block that the player has targeted
     */
    @Override
    public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the last two blocks along the player's line of sight.
     * The target block will be the last block in the list.
     *
     * @param transparent
     * @param maxDistance
     * @return List containing the last 2 blocks along the player's line of sight
     */
    @Override
    public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Throws an egg from the entity.
     */
    @Override
    public Egg throwEgg() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Throws a snowball from the entity.
     */
    @Override
    public Snowball throwSnowball() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Shoots an arrow from the entity.
     *
     * @return
     */
    @Override
    public Arrow shootArrow() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns whether this entity is inside a vehicle.
     *
     * @return
     */
    @Override
    public boolean isInsideVehicle() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Leave the current vehicle. If the entity is currently in a vehicle
     * (and is removed from it), true will be returned, otherwise false will
     * be returned.
     *
     * @return
     */
    @Override
    public boolean leaveVehicle() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the vehicle that this player is inside. If there is no vehicle,
     * null will be returned.
     *
     * @return
     */
    @Override
    public Vehicle getVehicle() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the amount of air that this entity has remaining, in ticks
     *
     * @return Amount of air remaining
     */
    @Override
    public int getRemainingAir() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the amount of air that this entity has remaining, in ticks
     *
     * @param ticks Amount of air remaining
     */
    @Override
    public void setRemainingAir(int ticks) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the maximum amount of air this entity can have, in ticks
     *
     * @return Maximum amount of air
     */
    @Override
    public int getMaximumAir() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the maximum amount of air this entity can have, in ticks
     *
     * @param ticks Maximum amount of air
     */
    @Override
    public void setMaximumAir(int ticks) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Deals the given amount of damage to this entity
     *
     * @param amount Amount of damage to deal
     */
    @Override
    public void damage(int amount) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Deals the given amount of damage to this entity, from a specified entity
     *
     * @param amount Amount of damage to deal
     * @param source Entity which to attribute this damage from
     */
    @Override
    public void damage(int amount, Entity source) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the entities current maximum noDamageTicks
     * This is the time in ticks the entity will become unable to take
     * equal or less damage than the lastDamage
     *
     * @return noDamageTicks
     */
    @Override
    public int getMaximumNoDamageTicks() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the entities current maximum noDamageTicks
     *
     * @param ticks maximumNoDamageTicks
     */
    @Override
    public void setMaximumNoDamageTicks(int ticks) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the entities lastDamage taken in the current noDamageTicks time.
     * Only damage higher than this amount will further damage the entity.
     *
     * @return lastDamage
     */
    @Override
    public int getLastDamage() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the entities current maximum noDamageTicks
     *
     * @param damage last damage
     */
    @Override
    public void setLastDamage(int damage) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the entities current noDamageTicks
     *
     * @return noDamageTicks
     */
    @Override
    public int getNoDamageTicks() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the entities current noDamageTicks
     *
     * @param ticks NoDamageTicks
     */
    @Override
    public void setNoDamageTicks(int ticks) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
