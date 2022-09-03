package org.bukkit.craftbukkit.inventory;

import net.minecraft.src.InventoryPlayer;
import ru.vladthemountain.lilybukkit.core.inventory.LBPlayerInventory;

@Deprecated
public class CraftPlayerInventory extends LBPlayerInventory {
    public CraftPlayerInventory(InventoryPlayer inventory) {
        super(inventory);
    }
}
