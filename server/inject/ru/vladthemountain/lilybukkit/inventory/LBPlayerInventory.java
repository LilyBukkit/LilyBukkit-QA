package ru.vladthemountain.lilybukkit.inventory;

import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryPlayer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;

/**
 * @author VladTheMountain
 */
public class LBPlayerInventory extends LBInventory implements PlayerInventory {
    public LBPlayerInventory(InventoryPlayer inventory) {
        super(inventory);
    }

    /**
     * Get all ItemStacks from the armor slots
     *
     * @return All the ItemStacks from the armor slots
     */
    @Override
    public ItemStack[] getArmorContents() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Return the ItemStack from the helmet slot
     *
     * @return The ItemStack in the helmet slot
     */
    @Override
    public ItemStack getHelmet() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Return the ItemStack from the chestplate slot
     *
     * @return The ItemStack in the chestplate slot
     */
    @Override
    public ItemStack getChestplate() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Return the ItemStack from the leg slot
     *
     * @return The ItemStack in the leg slot
     */
    @Override
    public ItemStack getLeggings() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Return the ItemStack from the boots slot
     *
     * @return The ItemStack in the boots slot
     */
    @Override
    public ItemStack getBoots() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Put the given ItemStacks into the armor slots
     *
     * @param items The ItemStacks to use as armour
     */
    @Override
    public void setArmorContents(ItemStack[] items) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Put the given ItemStack into the helmet slot
     * This does not check if the ItemStack is a helmet
     *
     * @param helmet The ItemStack to use as helmet
     */
    @Override
    public void setHelmet(ItemStack helmet) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Put the given ItemStack into the chestplate slot
     * This does not check if the ItemStack is a chestplate
     *
     * @param chestplate The ItemStack to use as chestplate
     */
    @Override
    public void setChestplate(ItemStack chestplate) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Put the given ItemStack into the leg slot
     * This does not check if the ItemStack is a pair of leggings
     *
     * @param leggings The ItemStack to use as leggings
     */
    @Override
    public void setLeggings(ItemStack leggings) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Put the given ItemStack into the boots slot
     * This does not check if the ItemStack is a boots
     *
     * @param boots The ItemStack to use as boots
     */
    @Override
    public void setBoots(ItemStack boots) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the ItemStack currently hold
     *
     * @return The currently held ItemStack
     */
    @Override
    public ItemStack getItemInHand() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the item in hand
     *
     * @param stack Stack to set
     */
    @Override
    public void setItemInHand(ItemStack stack) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Get the slot number of the currently held item
     *
     * @return Held item slot number
     */
    @Override
    public int getHeldItemSlot() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
