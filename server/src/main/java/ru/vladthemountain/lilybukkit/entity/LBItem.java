package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityItem;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBItem extends LBEntity implements Item {

    EntityItem entity;

    public LBItem(World w, EntityItem e) {
        super(w, e);
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

    @Override
    public int getPickupDelay() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void setPickupDelay(int i) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
