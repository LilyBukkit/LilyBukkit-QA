package ru.vladthemountain.lilybukkit.inventory;

import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.MinecraftException;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;


/**
 * @author VladTheMountain
 */
public class LBPlayerInventory extends LBInventory implements PlayerInventory {

    InventoryPlayer inventoryPlayer;

    public LBPlayerInventory(InventoryPlayer inventory) {
        super(inventory);
        inventoryPlayer = inventory;
    }

    /**
     * Get all ItemStacks from the armor slots
     *
     * @return All the ItemStacks from the armor slots
     */
    @Override
    public ItemStack[] getArmorContents() {
        return new ItemStack[]{this.getHelmet(), this.getChestplate(), this.getLeggings(), this.getBoots()};
    }

    /**
     * Return the ItemStack from the helmet slot
     *
     * @return The ItemStack in the helmet slot
     */
    @Override
    public ItemStack getHelmet() {
        net.minecraft.src.ItemStack helmet = this.inventoryPlayer.armorInventory[0];
        return new ItemStack(helmet.itemID, helmet.stackSize, (short) helmet.itemDmg);
    }

    /**
     * Return the ItemStack from the chestplate slot
     *
     * @return The ItemStack in the chestplate slot
     */
    @Override
    public ItemStack getChestplate() {
        net.minecraft.src.ItemStack chestplate = this.inventoryPlayer.armorInventory[1];
        return new ItemStack(chestplate.itemID, chestplate.stackSize, (short) chestplate.itemDmg);
    }

    /**
     * Return the ItemStack from the leg slot
     *
     * @return The ItemStack in the leg slot
     */
    @Override
    public ItemStack getLeggings() {
        net.minecraft.src.ItemStack leggings = this.inventoryPlayer.armorInventory[2];
        return new ItemStack(leggings.itemID, leggings.stackSize, (short) leggings.itemDmg);
    }

    /**
     * Return the ItemStack from the boots slot
     *
     * @return The ItemStack in the boots slot
     */
    @Override
    public ItemStack getBoots() {
        net.minecraft.src.ItemStack boots = this.inventoryPlayer.armorInventory[3];
        return new ItemStack(boots.itemID, boots.stackSize, (short) boots.itemDmg);
    }

    /**
     * Put the given ItemStacks into the armor slots
     *
     * @param items The ItemStacks to use as armour
     */
    @Override
    public void setArmorContents(ItemStack[] items) {
        net.minecraft.src.ItemStack[] newArmorContents = new net.minecraft.src.ItemStack[4];
        for (int i = 0; i < newArmorContents.length; i++) {
            newArmorContents[i] = new net.minecraft.src.ItemStack(items[i].getTypeId(), items[i].getAmount(), items[i].getDurability());
        }
        this.inventoryPlayer.armorInventory = newArmorContents.clone();
    }

    /**
     * Put the given ItemStack into the helmet slot
     * This does not check if the ItemStack is a helmet
     *
     * @param helmet The ItemStack to use as helmet
     */
    @Override
    public void setHelmet(ItemStack helmet) {
        this.inventoryPlayer.armorInventory[0] = new net.minecraft.src.ItemStack(helmet.getTypeId(), helmet.getAmount(), helmet.getDurability());
    }

    /**
     * Put the given ItemStack into the chestplate slot
     * This does not check if the ItemStack is a chestplate
     *
     * @param chestplate The ItemStack to use as chestplate
     */
    @Override
    public void setChestplate(ItemStack chestplate) {
        this.inventoryPlayer.armorInventory[1] = new net.minecraft.src.ItemStack(chestplate.getTypeId(), chestplate.getAmount(), chestplate.getDurability());
    }

    /**
     * Put the given ItemStack into the leg slot
     * This does not check if the ItemStack is a pair of leggings
     *
     * @param leggings The ItemStack to use as leggings
     */
    @Override
    public void setLeggings(ItemStack leggings) {
        this.inventoryPlayer.armorInventory[2] = new net.minecraft.src.ItemStack(leggings.getTypeId(), leggings.getAmount(), leggings.getDurability());
    }

    /**
     * Put the given ItemStack into the boots slot
     * This does not check if the ItemStack is a boots
     *
     * @param boots The ItemStack to use as boots
     */
    @Override
    public void setBoots(ItemStack boots) {
        this.inventoryPlayer.armorInventory[3] = new net.minecraft.src.ItemStack(boots.getTypeId(), boots.getAmount(), boots.getDurability());
    }

    /**
     * Returns the ItemStack currently hold
     *
     * @return The currently held ItemStack
     */
    @Override
    public ItemStack getItemInHand() {
        return this.getItem(this.inventoryPlayer.currentItem);
    }

    /**
     * Sets the item in hand
     *
     * @param stack Stack to set
     */
    @Override
    public void setItemInHand(ItemStack stack) {
        if (this.getItem(this.first(stack)) != null) {
            this.inventoryPlayer.currentItem = this.first(stack);
        } else {
            if (this.inventoryPlayer.addItemStackToInventory(new net.minecraft.src.ItemStack(stack.getTypeId(), stack.getAmount(), stack.getDurability()))) {
                this.inventoryPlayer.currentItem = this.first(stack);
            } else {
                throw new MinecraftException("Couldn't add item " + stack.getTypeId() + " to inventory " + this.inventoryPlayer);
            }
        }
    }

    /**
     * Get the slot number of the currently held item
     *
     * @return Held item slot number
     */
    @Override
    public int getHeldItemSlot() {
        return this.inventoryPlayer.currentItem;
    }
}
