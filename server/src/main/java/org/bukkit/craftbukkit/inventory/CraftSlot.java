package org.bukkit.craftbukkit.inventory;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Slot;
import ru.vladthemountain.lilybukkit.inventory.LBInventory;
import ru.vladthemountain.lilybukkit.inventory.LBSlot;

@Deprecated
public class CraftSlot extends LBSlot {
    public CraftSlot(Slot slot) {
        super((LBInventory) slot.getInventory(), slot.getIndex(), slot.getItem());
    }
}
