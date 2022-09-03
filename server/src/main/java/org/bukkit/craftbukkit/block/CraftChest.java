package org.bukkit.craftbukkit.block;

import org.bukkit.block.Block;
import ru.vladthemountain.lilybukkit.core.LBWorld;
import ru.vladthemountain.lilybukkit.core.block.LBChest;

@Deprecated
public class CraftChest extends LBChest {
    public CraftChest(final Block b) {
        super((LBWorld) b.getWorld(), b);
    }
}
