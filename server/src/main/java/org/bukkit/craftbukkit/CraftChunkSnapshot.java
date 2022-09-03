package org.bukkit.craftbukkit;

import org.bukkit.Bukkit;
import ru.vladthemountain.lilybukkit.core.LBChunkSnapshot;

@Deprecated
public class CraftChunkSnapshot extends LBChunkSnapshot {
    public CraftChunkSnapshot(int x, int z, String wname, long wtime, byte[] buf, byte[] hmap, /*BiomeBase*/ Object biome, double[] biomeTemp, double[] biomeRain) {
        super(Bukkit.getWorld(wname).getChunkAt(x, z), wtime, hmap != null);
    }
}
