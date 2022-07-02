package org.bukkit.material;

import org.bukkit.Material;

/**
 * Represents a Wool/Cloth block
 */
public class Wool extends MaterialData {
    public Wool() {
        super(Material.WOOL);
    }

    public Wool(final int type) {
        super(type);
    }

    public Wool(final Material type) {
        super(type);
    }

    public Wool(final int type, final byte data) {
        super(type, data);
    }

    public Wool(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
