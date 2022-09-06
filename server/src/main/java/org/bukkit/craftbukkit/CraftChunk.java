package org.bukkit.craftbukkit;

import net.minecraft.src.Chunk;
import ru.vladthemountain.lilybukkit.core.LBChunk;

@Deprecated
public class CraftChunk extends LBChunk {
    public CraftChunk(Chunk chunk) {
        super(chunk);
    }

    public net.minecraft.src.Chunk getHandle() {
        return this.chunk;
    }
}
