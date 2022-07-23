package org.bukkit.craftbukkit.entity;

import net.minecraft.server.EntityAnimal;
import org.bukkit.craftbukkit.CraftServer;
import ru.vladthemountain.lilybukkit.entity.LBAnimals;

@Deprecated
public class CraftAnimals extends LBAnimals {
    public CraftAnimals(CraftServer server, EntityAnimal e) {
        super(server.worldList.get(0), e);
    }
}
