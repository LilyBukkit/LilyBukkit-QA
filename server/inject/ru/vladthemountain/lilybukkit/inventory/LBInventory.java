package ru.vladthemountain.lilybukkit.inventory;

import net.minecraft.src.*;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

/**
 * @author VladTheMountain
 */
public class LBInventory implements Inventory {

    private final IInventory inventory;
    private String invName = "Chest";

    public LBInventory(IInventory blockContainer) {
        this.inventory = blockContainer;
    }

    /**
     * Returns the size of the inventory
     *
     * @return The inventory size
     */
    @Override
    public int getSize() {
        return this.inventory.getSizeInventory();
    }

    /**
     * Return the name of the inventory
     *
     * @return The inventory name
     */
    @Override
    public String getName() {
        return this.invName;
    }

    /**
     * Get the ItemStack found in the slot at the given index
     *
     * @param index The index of the Slot's ItemStack to return
     * @return The ItemStack in the slot
     */
    @Override
    public ItemStack getItem(int index) {
        if (index < 0 || index > this.getSize()) return null;
        net.minecraft.src.ItemStack vanillaItemStack = this.inventory.getStackInSlot(index);
        if (vanillaItemStack != null)
            return new ItemStack(vanillaItemStack.itemID, vanillaItemStack.stackSize, (short) vanillaItemStack.itemDmg);
        else return new ItemStack(0, 0, (short) 0);
    }

    /**
     * Stores the ItemStack at the given index
     *
     * @param index The index where to put the ItemStack
     * @param item  The ItemStack to set
     */
    @Override
    public void setItem(int index, ItemStack item) {
        net.minecraft.src.ItemStack vanillaItemStack = new net.minecraft.src.ItemStack(item.getTypeId(), item.getAmount());
        if (this.inventory instanceof TileEntityChest) {
            if (index > this.inventory.getSizeInventory() || index < 0) {
                throw new IllegalArgumentException("[LilyBukkit] Attempted to set an ItemStack to slot " + index + " which Chest " + this.inventory + " does not have.");
            } else {
                ((TileEntityChest) this.inventory).setInventorySlotContents(index, vanillaItemStack);
                ((TileEntityChest) this.inventory).onInventoryChanged();
            }
        } else if (this.inventory instanceof TileEntityFurnace) {
            if (index < 0 || index > 2) {
                // Yeah...
                NBTTagCompound furnaceContents = new NBTTagCompound();
                ((TileEntityFurnace) this.inventory).writeToNBT(furnaceContents);
                NBTTagList newItemList = furnaceContents.getTagList("Items");
                NBTTagCompound newFurnaceContents = new NBTTagCompound();
                newFurnaceContents.setByte("Slot", (byte) index);
                vanillaItemStack.writeToNBT(newFurnaceContents);
                newItemList.setTag(newFurnaceContents);
                furnaceContents.setTag("Items", newItemList);
                ((TileEntityFurnace) this.inventory).onInventoryChanged();
            } else {
                throw new IllegalArgumentException("[LilyBukkit] Attempted to set an ItemStack to slot " + index + " which Furnace " + this.inventory + " does not have.");
            }
        }
    }

    /**
     * Stores the given ItemStacks in the inventory.
     * <p>
     * This will try to fill existing stacks and empty slots as good as it can.
     * It will return a HashMap of what it couldn't fit.
     *
     * @param items The ItemStacks to add
     * @return what the method couldn't remove
     */
    @Override
    public HashMap<Integer, ItemStack> addItem(ItemStack... items) {
        HashMap<Integer, ItemStack> didntFit = new HashMap<>();
        for (int slot = 0; slot < this.getSize(); slot++) {
            ItemStack currentInventoryItem = this.getItem(slot);
            for (ItemStack currentNewItem : items) {
                if (currentInventoryItem.getType().equals(currentNewItem.getType()) && currentInventoryItem.getAmount() < currentInventoryItem.getMaxStackSize()) {
                    if (currentNewItem.getAmount() + currentInventoryItem.getAmount() <= currentInventoryItem.getMaxStackSize()) {
                        currentInventoryItem.setAmount(currentInventoryItem.getAmount() + currentNewItem.getAmount());
                    } else {
                        currentNewItem.setAmount(currentInventoryItem.getAmount() + currentNewItem.getAmount() - currentInventoryItem.getMaxStackSize());
                        didntFit.put(slot, currentNewItem);
                        currentInventoryItem.setAmount(currentInventoryItem.getMaxStackSize());
                    }
                    this.setItem(slot, currentInventoryItem);
                } else {
                    this.setItem(slot, currentNewItem);
                }
            }
        }
        return didntFit;
    }

    /**
     * Removes the given ItemStacks from the inventory.
     * <p>
     * It will try to remove 'as much as possible' from the types and amounts you
     * give as arguments. It will return a HashMap of what it couldn't remove.
     *
     * @param items The ItemStacks to remove
     * @return what the method couldn't remove
     */
    @Override
    public HashMap<Integer, ItemStack> removeItem(ItemStack... items) {
        HashMap<Integer, ItemStack> didntFit = new HashMap<>();
        for (int i = 0; i < this.getSize(); i++) {
            ItemStack currentSlot = this.getItem(i);
            for (ItemStack item : items) {
                if (currentSlot.getTypeId() == item.getTypeId()) {
                    if (!(currentSlot.getAmount() - item.getAmount() > 64)) {
                        currentSlot.setAmount(currentSlot.getAmount() - item.getAmount());
                        items[i].setAmount(0);
                    } else {
                        currentSlot.setAmount(0);
                        items[i].setAmount(items[i].getAmount() - 64);
                        didntFit.put(i, items[i]);
                    }
                }
            }
        }
        return didntFit;
    }

    /**
     * Get all ItemStacks from the inventory
     *
     * @return All the ItemStacks from all slots
     */
    @Override
    public ItemStack[] getContents() {
        ItemStack[] contents = new ItemStack[this.getSize()];
        for (int i = 0; i < this.getSize(); i++) {
            net.minecraft.src.ItemStack vanillaItemStack = this.inventory.getStackInSlot(i);
            contents[i] = new ItemStack(vanillaItemStack.itemID, vanillaItemStack.stackSize, (short) vanillaItemStack.itemDmg);
        }
        return contents;
    }

    /**
     * Set the inventory's contents
     *
     * @param items the inventory's new contents
     */
    @Override
    public void setContents(ItemStack[] items) {
        if (items.length > this.getSize()) {
            throw new IllegalArgumentException("[LilyBukkit] ItemStack array too large");
        } else {
            for (int i = 0; i < items.length; i++) {
                this.inventory.getStackInSlot(i).itemID = items[i].getTypeId();
                this.inventory.getStackInSlot(i).stackSize = items[i].getAmount();
                this.inventory.getStackInSlot(i).itemDmg = items[i].getDurability();
            }
        }
    }

    /**
     * Check if the inventory contains any ItemStacks with the given materialId
     *
     * @param materialId The materialId to check for
     * @return If any ItemStacks were found
     */
    @Override
    public boolean contains(int materialId) {
        boolean flag = false;
        for (ItemStack i : this.getContents()) {
            flag = flag || i.getTypeId() == materialId;
        }
        return flag;
    }

    /**
     * Check if the inventory contains any ItemStacks with the given material
     *
     * @param material The material to check for
     * @return If any ItemStacks were found
     */
    @Override
    public boolean contains(Material material) {
        return this.contains(material.getId());
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
        boolean flag = false;
        for (ItemStack i : this.getContents()) {
            flag = flag || (i.getTypeId() == item.getTypeId() && i.getAmount() == item.getAmount());
        }
        return flag;
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
        for (ItemStack i : this.getContents()) {
            if (i.getTypeId() == materialId && i.getAmount() >= amount) return true;
        }
        return false;
    }

    /**
     * Check if the inventory contains any ItemStacks with the given material and at least the minimum amount specified
     *
     * @param material The material to check for
     * @param amount   The minimal amount of the item
     * @return If any ItemStacks were found
     */
    @Override
    public boolean contains(Material material, int amount) {
        return this.contains(material.getId(), amount);
    }

    /**
     * Check if the inventory contains any ItemStacks matching the given ItemStack and at least the minimum amount specified
     * This will only match if both the type and the amount of the stack match
     *
     * @param item   The ItemStack to match against
     * @param amount The minimal amount of the item
     * @return If any matching ItemStacks were found
     */
    @Override
    public boolean contains(ItemStack item, int amount) {
        for (ItemStack i : this.getContents()) {
            if (i.equals(item) && i.getAmount() >= amount) return true;
        }
        return false;
    }

    /**
     * Find all slots in the inventory containing any ItemStacks with the given materialId
     *
     * @param materialId The materialId to look for
     * @return The Slots found.
     */
    @Override
    public HashMap<Integer, ? extends ItemStack> all(int materialId) {
        HashMap<Integer, ItemStack> found = new HashMap<>();
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getContents()[i].getTypeId() == materialId) found.put(i, this.getContents()[i]);
        }
        return found;
    }

    /**
     * Find all slots in the inventory containing any ItemStacks with the given material
     *
     * @param material the {@link Material} to look for
     * @return The Slots found.
     */
    @Override
    public HashMap<Integer, ? extends ItemStack> all(Material material) {
        return this.all(material.getId());
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
        HashMap<Integer, ItemStack> found = new HashMap<>();
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getContents()[i].equals(item)) found.put(i, this.getContents()[i]);
        }
        return found;
    }

    /**
     * Find the first slot in the inventory containing an ItemStack with the given materialId
     *
     * @param materialId The materialId to look for
     * @return The Slot found.
     */
    @Override
    public int first(int materialId) {
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getContents()[i].getTypeId() == materialId) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Find the first slot in the inventory containing an ItemStack with the given material
     *
     * @param material the {@link Material} to look for
     * @return The Slot found. -1 if not found
     */
    @Override
    public int first(Material material) {
        return this.first(material.getId());
    }

    /**
     * Find the first slot in the inventory containing an ItemStack with the given stack
     * This will only match a slot if both the type and the amount of the stack match
     *
     * @param item The ItemStack to match against
     * @return The Slot found. -1 if not found
     */
    @Override
    public int first(ItemStack item) {
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getContents()[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Find the first empty Slot.
     *
     * @return The first empty Slot found. -1 if not found
     */
    @Override
    public int firstEmpty() {
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getContents()[i] == null || this.getContents()[i].getTypeId() == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Remove all stacks in the inventory matching the given materialId.
     *
     * @param materialId The material to remove
     */
    @Override
    public void remove(int materialId) {
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getContents()[i].getTypeId() == materialId) {
                this.inventory.getStackInSlot(i).stackSize = 0;
            }
        }
    }

    /**
     * Remove all stacks in the inventory matching the given material.
     *
     * @param material The material to remove
     */
    @Override
    public void remove(Material material) {
        this.remove(material.getId());
    }

    /**
     * Remove all stacks in the inventory matching the given stack.
     * This will only match a slot if both the type and the amount of the stack match
     *
     * @param item The ItemStack to match against
     */
    @Override
    public void remove(ItemStack item) {
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getContents()[i].equals(item)) {
                this.inventory.getStackInSlot(i).stackSize = 0;
            }
        }
    }

    /**
     * Clear out a particular slot in the index
     *
     * @param index The index to empty.
     */
    @Override
    public void clear(int index) {
        this.inventory.getStackInSlot(index).readFromNBT(new NBTTagCompound()); //Idk, tbh
    }

    /**
     * Clear out the whole index
     */
    @Override
    public void clear() {
        for (int i = 0; i < this.getSize(); i++) {
            this.clear(i);
        }
    }
}
