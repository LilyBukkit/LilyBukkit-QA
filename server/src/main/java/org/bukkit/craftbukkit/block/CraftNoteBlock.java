package org.bukkit.craftbukkit.block;

import org.bukkit.block.Block;

@Deprecated
public class CraftNoteBlock extends CraftBlockState{
    public CraftNoteBlock(Block b) {
        super(b);
        throw new UnsupportedOperationException("One of the plugins called deprecated Block API");
    }
}
