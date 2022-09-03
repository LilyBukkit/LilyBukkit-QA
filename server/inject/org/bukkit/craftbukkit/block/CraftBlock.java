package org.bukkit.craftbukkit.block;

import org.bukkit.craftbukkit.CraftChunk;
import ru.vladthemountain.lilybukkit.core.LBWorld;
import ru.vladthemountain.lilybukkit.core.block.LBBlock;

@Deprecated
public class CraftBlock extends LBBlock {
    public CraftBlock(CraftChunk chunk, int x, int y, int z) {
        super((LBWorld) chunk.getWorld(), chunk.getWorld().getBlockTypeIdAt(x, y, z), x, y, z);
    }
}
