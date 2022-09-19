package org.bukkit.craftbukkit.entity;

import net.minecraft.src.EntityArrow;
import org.bukkit.craftbukkit.CraftServer;
import ru.vladthemountain.lilybukkit.core.entity.LBArrow;

@Deprecated
public class CraftArrow extends LBArrow {
    public CraftArrow(CraftServer server, EntityArrow e) {
        super(server.getWorld(e.worldObj.levelName), e);
    }
}
