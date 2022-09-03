package org.bukkit.craftbukkit.block;

import org.bukkit.block.Block;
import ru.vladthemountain.lilybukkit.core.LBWorld;
import ru.vladthemountain.lilybukkit.core.block.LBSign;

@Deprecated
public class CraftSign extends LBSign {
    public CraftSign(final Block b) {
        super((LBWorld) b.getWorld(), b);
    }
}
