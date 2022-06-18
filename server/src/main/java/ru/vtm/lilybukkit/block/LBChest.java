package ru.vtm.lilybukkit.block;

import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;

public class LBChest extends LBBlockState implements Chest {

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
