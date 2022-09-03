package org.bukkit.craftbukkit.block;

import org.bukkit.block.Block;
import ru.vladthemountain.lilybukkit.core.LBWorld;
import ru.vladthemountain.lilybukkit.core.block.LBFurnace;

@Deprecated
public class CraftFurnace extends LBFurnace {
    public CraftFurnace(final Block b) {
        super((LBWorld) b.getWorld(), b);
    }
}
