package org.bukkit.material;

import org.bukkit.Material;

/**
 * Represents the different types of coals.
 */
public class Coal extends MaterialData {
    public Coal() {
        super(Material.COAL);
    }

    public Coal(final int type) {
        super(type);
    }

    public Coal(final Material type) {
        super(type);
    }

    public Coal(final int type, final byte data) {
        super(type, data);
    }

    public Coal(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
