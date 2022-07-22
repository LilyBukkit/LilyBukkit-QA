package org.bukkit.craftbukkit.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Deprecated
public class CraftItemStack extends ItemStack {
    public CraftItemStack(int type) {
        super(type);
    }

    public CraftItemStack(Material type) {
        super(type);
    }

    public CraftItemStack(int type, int amount) {
        super(type, amount);
    }

    public CraftItemStack(Material type, int amount) {
        super(type, amount);
    }

    public CraftItemStack(int type, int amount, short damage) {
        super(type, amount, damage);
    }

    public CraftItemStack(Material type, int amount, short damage) {
        super(type, amount, damage);
    }

    public CraftItemStack(int type, int amount, short damage, Byte data) {
        super(type, amount, damage, data);
    }

    public CraftItemStack(Material type, int amount, short damage, Byte data) {
        super(type, amount, damage, data);
    }
}
