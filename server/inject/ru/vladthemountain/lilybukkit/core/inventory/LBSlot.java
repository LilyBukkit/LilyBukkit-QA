package ru.vladthemountain.lilybukkit.core.inventory;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Slot;

/**
 * @author VladTheMountain
 */
public class LBSlot implements Slot {

    private LBInventory inventory;
    private int index;
    private ItemStack itemStack;

    public LBSlot(LBInventory parent, int index, ItemStack item) {
        this.inventory = parent;
        this.index = index;
        this.itemStack = item;
    }

    /**
     * Gets the inventory this slot belongs to
     *
     * @return The inventory
     */
    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Get the index this slot belongs to
     *
     * @return Index of the slot
     */
    @Override
    public int getIndex() {
        return this.index;
    }

    /**
     * Get the item from the slot.
     *
     * @return ItemStack in the slot.
     */
    @Override
    public ItemStack getItem() {
        return this.itemStack;
    }
}
