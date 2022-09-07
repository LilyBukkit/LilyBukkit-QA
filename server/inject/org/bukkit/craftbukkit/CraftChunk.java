package org.bukkit.craftbukkit;

import net.minecraft.src.Chunk;
import org.bukkit.Bukkit;
import ru.vladthemountain.lilybukkit.core.LBChunk;
import ru.vladthemountain.lilybukkit.core.LBWorld;

@Deprecated
public class CraftChunk extends LBChunk {
    public CraftChunk(Chunk chunk) {
        super((LBWorld) Bukkit.getServer().getWorld(chunk.worldObj.levelName), chunk);
    }

    public net.minecraft.src.Chunk getHandle() {
        return this.chunk;
    }
}
