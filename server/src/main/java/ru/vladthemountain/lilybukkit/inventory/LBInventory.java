package ru.vladthemountain.lilybukkit.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class LBInventory implements Inventory {
    /**
     * Returns the size of the inventory
     *
     * @return The inventory size
     */
    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Return the name of the inventory
     *
     * @return The inventory name
     */
    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the ItemStack found in the slot at the given index
     *
     * @param index The index of the Slot's ItemStack to return
     * @return The ItemStack in the slot
     */
    @Override
    public ItemStack getItem(int index) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Stores the ItemStack at the given index
     *
     * @param index The index where to put the ItemStack
     * @param item  The ItemStack to set
     */
    @Override
    public void setItem(int index, ItemStack item) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Stores the given ItemStacks in the inventory.
     * <p>
     * This will try to fill existing stacks and empty slots as good as it can.
     * It will return a HashMap of what it couldn't fit.
     *
     * @param items The ItemStacks to add
     * @return
     */
    @Override
    public HashMap<Integer, ItemStack> addItem(ItemStack... items) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Removes the given ItemStacks from the inventory.
     * <p>
     * It will try to remove 'as much as possible' from the types and amounts you
     * give as arguments. It will return a HashMap of what it couldn't remove.
     *
     * @param items The ItemStacks to remove
     * @return
     */
    @Override
    public HashMap<Integer, ItemStack> removeItem(ItemStack... items) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get all ItemStacks from the inventory
     *
     * @return All the ItemStacks from all slots
     */
    @Override
    public ItemStack[] getContents() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the inventory's contents
     *
     * @param items
     * @return All the ItemStacks from all slots
     */
    @Override
    public void setContents(ItemStack[] items) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Check if the inventory contains any ItemStacks with the given materialId
     *
     * @param materialId The materialId to check for
     * @return If any ItemStacks were found
     */
    @Override
    public boolean contains(int materialId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Check if the inventory contains any ItemStacks with the given material
     *
     * @param material The material to check for
     * @return If any ItemStacks were found
     */
    @Override
    public boolean contains(Material material) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Check if the inventory contains any ItemStacks matching the given ItemStack
     * This will only match if both the type and the amount of the stack match
     *
     * @param item The ItemStack to match against
     * @return If any matching ItemStacks were found
     */
    @Override
    public boolean contains(ItemStack item) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Check if the inventory contains any ItemStacks with the given materialId and at least the minimum amount specified
     *
     * @param materialId The materialId to check for
     * @param amount     The minimum amount to look for
     * @return If any ItemStacks were found
     */
    @Override
    public boolean contains(int materialId, int amount) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Check if the inventory contains any ItemStacks with the given material and at least the minimum amount specified
     *
     * @param material The material to check for
     * @param amount
     * @return If any ItemStacks were found
     */
    @Override
    public boolean contains(Material material, int amount) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Check if the inventory contains any ItemStacks matching the given ItemStack and at least the minimum amount specified
     * This will only match if both the type and the amount of the stack match
     *
     * @param item   The ItemStack to match against
     * @param amount
     * @return If any matching ItemStacks were found
     */
    @Override
    public boolean contains(ItemStack item, int amount) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Find all slots in the inventory containing any ItemStacks with the given materialId
     *
     * @param materialId The materialId to look for
     * @return The Slots found.
     */
    @Override
    public HashMap<Integer, ? extends ItemStack> all(int materialId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Find all slots in the inventory containing any ItemStacks with the given material
     *
     * @param material@return The Slots found.
     */
    @Override
    public HashMap<Integer, ? extends ItemStack> all(Material material) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Find all slots in the inventory containing any ItemStacks with the given ItemStack
     * This will only match slots if both the type and the amount of the stack match
     *
     * @param item The ItemStack to match against
     * @return The Slots found.
     */
    @Override
    public HashMap<Integer, ? extends ItemStack> all(ItemStack item) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Find the first slot in the inventory containing an ItemStack with the given materialId
     *
     * @param materialId The materialId to look for
     * @return The Slot found.
     */
    @Override
    public int first(int materialId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Find the first slot in the inventory containing an ItemStack with the given material
     *
     * @param material@return The Slot found.
     */
    @Override
    public int first(Material material) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Find the first slot in the inventory containing an ItemStack with the given stack
     * This will only match a slot if both the type and the amount of the stack match
     *
     * @param item The ItemStack to match against
     * @return The Slot found.
     */
    @Override
    public int first(ItemStack item) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Find the first empty Slot.
     *
     * @return The first empty Slot found.
     */
    @Override
    public int firstEmpty() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Remove all stacks in the inventory matching the given materialId.
     *
     * @param materialId The material to remove
     */
    @Override
    public void remove(int materialId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Remove all stacks in the inventory matching the given material.
     *
     * @param material The material to remove
     */
    @Override
    public void remove(Material material) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Remove all stacks in the inventory matching the given stack.
     * This will only match a slot if both the type and the amount of the stack match
     *
     * @param item The ItemStack to match against
     */
    @Override
    public void remove(ItemStack item) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Clear out a particular slot in the index
     *
     * @param index The index to empty.
     */
    @Override
    public void clear(int index) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Clear out the whole index
     */
    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
