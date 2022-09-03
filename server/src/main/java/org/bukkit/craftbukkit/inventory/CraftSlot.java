package org.bukkit.craftbukkit.inventory;

import org.bukkit.inventory.Slot;
import ru.vladthemountain.lilybukkit.core.inventory.LBInventory;
import ru.vladthemountain.lilybukkit.core.inventory.LBSlot;

@Deprecated
public class CraftSlot extends LBSlot {
    public CraftSlot(Slot slot) {
        super((LBInventory) slot.getInventory(), slot.getIndex(), slot.getItem());
    }
}
