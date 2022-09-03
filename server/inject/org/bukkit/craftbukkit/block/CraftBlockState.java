package org.bukkit.craftbukkit.block;

import org.bukkit.block.Block;
import ru.vladthemountain.lilybukkit.core.LBWorld;
import ru.vladthemountain.lilybukkit.core.block.LBBlockState;

@Deprecated
public class CraftBlockState extends LBBlockState {
    public CraftBlockState(final Block b) {
        super((LBWorld) b.getWorld(), b);
    }
}
