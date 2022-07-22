package org.bukkit.craftbukkit.block;

import org.bukkit.block.Block;
import ru.vladthemountain.lilybukkit.LBWorld;
import ru.vladthemountain.lilybukkit.block.LBCreatureSpawner;

@Deprecated
public class CraftCreatureSpawner extends LBCreatureSpawner {
    public CraftCreatureSpawner(final Block b) {
        super((LBWorld) b.getWorld(), b);
    }
}
