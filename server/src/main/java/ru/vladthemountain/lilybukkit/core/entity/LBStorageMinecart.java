package ru.vladthemountain.lilybukkit.core.entity;

import net.minecraft.src.EntityMinecart;
import org.bukkit.entity.StorageMinecart;
import org.bukkit.inventory.Inventory;
import ru.vladthemountain.lilybukkit.core.LBWorld;
import ru.vladthemountain.lilybukkit.core.inventory.LBInventory;

public class LBStorageMinecart extends LBMinecart implements StorageMinecart {
    public LBStorageMinecart(LBWorld w, EntityMinecart e) {
        super(w, e);
    }

    @Override
    public Inventory getInventory() {
        return new LBInventory(this.entity);
    }
}
