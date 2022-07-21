package org.bukkit.craftbukkit;

import net.minecraft.src.WorldServer;
import org.bukkit.generator.ChunkGenerator;
import ru.vladthemountain.lilybukkit.LBWorld;

@Deprecated
public class CraftWorld extends LBWorld {
    public CraftWorld(WorldServer world, ChunkGenerator gen, Environment env) {
        super(world, gen);
    }
}
