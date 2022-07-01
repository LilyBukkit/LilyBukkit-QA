package ru.vladthemountain.lilybukkit.inventory;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Slot;

/**
 * @author VladTheMountain
 */
public class LBSlot implements Slot {
    /**
     * Gets the inventory this slot belongs to
     *
     * @return The inventory
     */
    @Override
    public Inventory getInventory() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the index this slot belongs to
     *
     * @return Index of the slot
     */
    @Override
    public int getIndex() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the item from the slot.
     *
     * @return ItemStack in the slot.
     */
    @Override
    public ItemStack getItem() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
