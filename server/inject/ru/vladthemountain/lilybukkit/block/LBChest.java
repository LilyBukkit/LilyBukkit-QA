package ru.vladthemountain.lilybukkit.block;

import net.minecraft.src.Entity;
import net.minecraft.src.InventoryLargeChest;
import net.minecraft.src.TileEntityChest;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import ru.vladthemountain.lilybukkit.inventory.LBInventory;

public class LBChest extends LBBlockState implements Chest {

    TileEntityChest entity;

    public LBChest(LBBlock b) {
        super(b);
    }

    /**
     * Get the block's inventory.
     *
     * @return
     */
    @Override
    public Inventory getInventory() {
        //return new LBInventory(new InventoryLargeChest(entity.));
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
