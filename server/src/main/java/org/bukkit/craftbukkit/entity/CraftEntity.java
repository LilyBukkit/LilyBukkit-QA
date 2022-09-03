package org.bukkit.craftbukkit.entity;

import net.minecraft.src.Entity;
import org.bukkit.World;
import org.bukkit.craftbukkit.CraftServer;
import ru.vladthemountain.lilybukkit.core.entity.LBEntity;

@Deprecated
public class CraftEntity extends LBEntity {
    public CraftEntity(World w, Entity e) {
        super(w, e);
    }

    public CraftEntity(final CraftServer craftServer, Entity entity){
        this(craftServer.getWorld(entity.worldObj.levelName), entity);
    }
}
