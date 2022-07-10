package org.bukkit.material;

import org.bukkit.Material;

/**
 * Represents redstone wire
 */
public class GreenstoneWire extends MaterialData implements Greenstone {
    public GreenstoneWire() {
        super(Material.GREENSTONE_WIRE);
    }

    public GreenstoneWire(final int type) {
        super(type);
    }

    public GreenstoneWire(final Material type) {
        super(type);
    }

    public GreenstoneWire(final int type, final byte data) {
        super(type, data);
    }

    public GreenstoneWire(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the current state of this Material, indicating if it's powered or
     * unpowered
     *
     * @return true if powered, otherwise false
     */
    public boolean isPowered() {
        return getData() > 0;
    }

    @Override
    public String toString() {
        return super.toString() + " " + (isPowered() ? "" : "NOT ") + "POWERED";
    }
}
