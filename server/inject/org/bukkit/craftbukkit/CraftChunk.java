package org.bukkit.craftbukkit;

import net.minecraft.src.Chunk;
import ru.vladthemountain.lilybukkit.LBChunk;

@Deprecated
public class CraftChunk extends LBChunk {
    public CraftChunk(Chunk chunk) {
        super(chunk);
    }
}
