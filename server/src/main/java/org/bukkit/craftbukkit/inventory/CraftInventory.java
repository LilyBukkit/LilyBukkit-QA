package org.bukkit.craftbukkit.inventory;

import net.minecraft.src.IInventory;
import ru.vladthemountain.lilybukkit.core.inventory.LBInventory;

@Deprecated
public class CraftInventory extends LBInventory {
    public CraftInventory(IInventory blockContainer) {
        super(blockContainer);
    }
}
