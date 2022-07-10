package org.bukkit.material;

import org.bukkit.Material;

/**
 * Represents a redstone torch
 */
public class GreenstoneTorch extends Torch implements Greenstone {
    public GreenstoneTorch() {
        super(Material.GREENSTONE_TORCH_ON);
    }

    public GreenstoneTorch(final int type) {
        super(type);
    }

    public GreenstoneTorch(final Material type) {
        super(type);
    }

    public GreenstoneTorch(final int type, final byte data) {
        super(type, data);
    }

    public GreenstoneTorch(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the current state of this Material, indicating if it's powered or
     * unpowered
     *
     * @return true if powered, otherwise false
     */
    public boolean isPowered() {
        return getItemType() == Material.GREENSTONE_TORCH_ON;
    }

    @Override
    public String toString() {
        return super.toString() + " " + (isPowered() ? "" : "NOT ") + "POWERED";
    }
}
