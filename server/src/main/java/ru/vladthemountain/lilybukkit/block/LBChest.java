package ru.vladthemountain.lilybukkit.block;

import net.minecraft.src.Entity;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;

public class LBChest extends LBBlockState implements Chest {

    public LBChest(Entity e) {
        super(e);
    }

    /**
     * Get the block's inventory.
     *
     * @return
     */
    @Override
    public Inventory getInventory() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
