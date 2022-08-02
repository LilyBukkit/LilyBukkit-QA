package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMinecart;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.util.BlockIterator;
import ru.vladthemountain.lilybukkit.LBWorld;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author VladTheMountain
 */
public class LBLivingEntity extends LBEntity implements LivingEntity {

    EntityLiving entity;
    int entityHealth;

    public LBLivingEntity(LBWorld w, EntityLiving e) {
        super(w, e);
        this.entity = e;
    }

    /**
     * Gets the entity's health from 0-20, where 0 is dead and 20 is full
     *
     * @return Health represented from 0-20
     */
    @Override
    public int getHealth() {
        return this.entityHealth;
    }

    /**
     * Sets the entity's health from 0-20, where 0 is dead and 20 is full
     *
     * @param health New health represented from 0-20
     */
    @Override
    public void setHealth(int health) {
        this.entityHealth = health;
    }

    /**
     * Gets the height of the entity's head above its Location
     *
     * @return Height of the entity's eyes above its Location
     */
    @Override
    public double getEyeHeight() {
        return this.entity.height;
    }

    /**
     * Get a Location detailing the current eye position of the LivingEntity.
     *
     * @return a Location at the eyes of the LivingEntity.
     */
    @Override
    public Location getEyeLocation() {
        return new Location(this.world, this.getLocation().getX(), this.getLocation().getY() + 1.0, this.getLocation().getZ());
    }

    /**
     * Gets all blocks along the player's line of sight
     * List iterates from player's position to target inclusive
     *
     * @param maxDistance This is the maximum distance to scan. This may be further limited by the server, but never to less than 100 blocks.
     * @return List containing all blocks along the player's line of sight
     */
    @Override
    public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
        // Modified CraftBukkit code ahead
        List<Block> los = new ArrayList<>();
        if (maxDistance < 100) {
            Bukkit.getServer().getLogger().warning("maxDistance is less than 100");
        }
        Iterator<Block> itr = new BlockIterator(this, maxDistance);
        while (itr.hasNext()) {
            Block block = itr.next();
            los.add(block);
            int id = block.getTypeId();
            if (transparent == null) {
                if (id != 0) {
                    break;
                }
            } else {
                if (!transparent.contains((byte) id)) {
                    break;
                }
            }
        }
        return los;
    }

    /**
     * Gets the block that the player has targeted
     *
     * @param maxDistance This is the maximum distance to scan. This may be further limited by the server, but never to less than 100 blocks.
     * @return Block that the player has targeted
     */
    @Override
    public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
        return this.getLineOfSight(transparent, maxDistance).get(this.getLineOfSight(transparent, maxDistance).size());
    }

    /**
     * Gets the last two blocks along the player's line of sight.
     * The target block will be the last block in the list.
     *
     * @param maxDistance This is the maximum distance to scan. This may be further limited by the server, but never to less than 100 blocks
     * @return List containing the last 2 blocks along the player's line of sight
     */
    @Override
    public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) {
        List<Block> los = new ArrayList<>();
        los.add(this.getLineOfSight(transparent, maxDistance).get(this.getLineOfSight(transparent, maxDistance).size() - 1));
        los.add(this.getLineOfSight(transparent, maxDistance).get(this.getLineOfSight(transparent, maxDistance).size()));
        return los;
    }

    /**
     * Throws a snowball from the entity.
     */
    @Override
    public Snowball throwSnowball() {
        return this.getWorld().spawn(this.getLocation(), LBSnowball.class);
    }

    /**
     * Shoots an arrow from the entity.
     */
    @Override
    public Arrow shootArrow() {
        return this.getWorld().spawn(this.getLocation(), LBArrow.class);
    }

    /**
     * Returns whether this entity is inside a vehicle.
     */
    @Override
    public boolean isInsideVehicle() {
        return this.entity.ridingEntity != null && (this.entity.ridingEntity instanceof EntityBoat || this.entity.ridingEntity instanceof EntityMinecart);
    }

    /**
     * Leave the current vehicle. If the entity is currently in a vehicle
     * (and is removed from it), true will be returned, otherwise false will
     * be returned.
     */
    @Override
    public boolean leaveVehicle() {
        this.entity.mountEntity(this.entity.ridingEntity);
        return !isInsideVehicle();
    }

    /**
     * Get the vehicle that this player is inside. If there is no vehicle,
     * null will be returned.
     */
    @Override
    public Vehicle getVehicle() {
        if (this.entity.ridingEntity instanceof EntityBoat)
            return new LBBoat(this.world, (EntityBoat) this.entity.ridingEntity);
        else if (this.entity.ridingEntity instanceof EntityMinecart)
            return new LBMinecart(this.world, (EntityMinecart) this.entity.ridingEntity);
        else return null;
    }

    /**
     * Returns the amount of air that this entity has remaining, in ticks
     *
     * @return Amount of air remaining
     */
    @Override
    public int getRemainingAir() {
        return this.entity.air;
    }

    /**
     * Sets the amount of air that this entity has remaining, in ticks
     *
     * @param ticks Amount of air remaining
     */
    @Override
    public void setRemainingAir(int ticks) {
        this.entity.air = ticks;
    }

    /**
     * Deals the given amount of damage to this entity
     *
     * @param amount Amount of damage to deal
     */
    @Override
    public void damage(int amount) {
        this.entity.attackEntityFrom(null, amount);
    }

    /**
     * Deals the given amount of damage to this entity, from a specified entity
     *
     * @param amount Amount of damage to deal
     * @param source Entity which to attribute this damage from
     */
    @Override
    public void damage(int amount, Entity source) {
        for (net.minecraft.src.Entity e : this.world.getWorldServer().loadedEntityList) {
            if (e.entityID == source.getEntityId()) this.entity.attackEntityFrom(e, amount);
        }
    }

    @Override
    public int getMaximumNoDamageTicks() {
        return this.entity.heartsHalvesLife;
    }

    @Override
    public void setMaximumNoDamageTicks(int i) {
        this.entity.heartsHalvesLife = i;
    }

    @Override
    public int getNoDamageTicks() {
        return this.entity.heartsLife;
    }

    @Override
    public void setNoDamageTicks(int i) {
        this.entity.heartsLife = i;
    }
}
