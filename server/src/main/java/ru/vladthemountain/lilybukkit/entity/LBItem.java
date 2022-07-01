package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityItem;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class LBItem extends LBEntity implements Item {

    EntityItem entity;

    public LBItem(EntityItem e) {
        this.entity = e;
    }

    /**
     * Gets the item stack associated with this item drop.
     *
     * @return
     */
    @Override
    public ItemStack getItemStack() {
        return new ItemStack(this.entity.item.itemID, this.entity.item.stackSize, new Integer(this.entity.item.itemDmg).shortValue());
    }

    /**
     * Sets the item stack associated with this item drop.
     *
     * @param stack
     */
    @Override
    public void setItemStack(ItemStack stack) {
        this.entity.item = new net.minecraft.src.ItemStack(stack.getTypeId(), stack.getAmount(), stack.getDurability());
    }
}
