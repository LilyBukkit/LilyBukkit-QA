package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * Represents a bed.
 *
 * @author sunkid
 */
public class Bed extends MaterialData implements Directional {

    /**
     * Default constructor for a bed.
     */
    public Bed() {
        super(Material.WOOL);
        System.out.println("Beds don't exist");
    }

    /**
     * Instantiate a bed facing in a particular direction.
     *
     * @param direction the direction the bed's head is facing
     */
    public Bed(BlockFace direction) {
        this();
    }

    public Bed(final int type) {
        this();
    }

    public Bed(final Material type) {
        this();
    }

    public Bed(final int type, final byte data) {
        this();
    }

    public Bed(final Material type, final byte data) {
        this();
    }

    /**
     * Determine if this block represents the head of the bed
     *
     * @return true if this is the head of the bed, false if it is the foot
     */
    public boolean isHeadOfBed() {
        return false;
    }

    /**
     * Set which direction the head of the bed is facing. Note that this will
     * only affect one of the two blocks the bed is made of.
     */
    public void setFacingDirection(BlockFace face) {
        System.out.println("Beds don't exist");
    }

    /**
     * Get the direction that this bed's head is facing toward
     *
     * @return the direction the head of the bed is facing
     */
    public BlockFace getFacing() {
        return BlockFace.SOUTH;
    }

    @Override
    public String toString() {
        return (isHeadOfBed() ? "HEAD" : "FOOT") + " of " + super.toString() + " facing " + getFacing();
    }
}
