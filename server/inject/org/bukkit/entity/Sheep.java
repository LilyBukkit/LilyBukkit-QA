/**
 *
 */
package org.bukkit.entity;

/**
 * Represents a Sheep.
 *
 * @author Cogito
 *
 */
public interface Sheep extends Animals {

    /**
     * @author Celtic Minstrel
     * @return Whether the sheep is sheared.
     */
    public boolean isSheared();

    /**
     * @author Celtic Minstrel
     * @param flag Whether to shear the sheep
     */
    public void setSheared(boolean flag);
}
