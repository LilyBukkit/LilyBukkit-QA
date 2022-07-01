package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * Represents a furnace.
 */
public class Furnace extends MaterialData implements Directional {

    public Furnace() {
        super(Material.FURNACE);
    }

    /**
     * Instantiate a furnace facing in a particular direction.
     * @param direction the direction the furnace's "opening" is facing
     */
    public Furnace(BlockFace direction) {
        this();
        setFacingDirection(direction);
    }

    public Furnace(final int type) {
        super(type);
    }

    public Furnace(final Material type) {
        super(type);
    }

    public Furnace(final int type, final byte data) {
        super(type, data);
    }

    public Furnace(final Material type, final byte data) {
        super(type, data);
    }

    public void setFacingDirection(BlockFace face) {
        byte data;

        switch (face) {
            case EAST:
                data = 0x2;
                break;

            case WEST:
                data = 0x3;
                break;

            case NORTH:
                data = 0x4;
                break;

            case SOUTH:
            default:
                data = 0x5;
        }

        setData(data);
    }

    public BlockFace getFacing() {
        byte data = getData();

        switch (data) {
            case 0x2:
                return BlockFace.EAST;

            case 0x3:
                return BlockFace.WEST;

            case 0x4:
                return BlockFace.NORTH;

            case 0x5:
            default:
                return BlockFace.SOUTH;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing();
    }
}
