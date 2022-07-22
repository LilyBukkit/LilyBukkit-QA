package org.bukkit.craftbukkit.block;

import org.bukkit.block.Block;

@Deprecated
public class CraftDispenser extends CraftBlockState {
    public CraftDispenser(Block b) {
        super(b);
        throw new UnsupportedOperationException("One of the plugins called deprecated Block API");
    }
}
