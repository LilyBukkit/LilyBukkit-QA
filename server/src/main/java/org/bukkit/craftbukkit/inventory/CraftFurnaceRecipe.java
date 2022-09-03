package org.bukkit.craftbukkit.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import ru.vladthemountain.lilybukkit.core.inventory.LBRecipe;

@Deprecated
public class CraftFurnaceRecipe extends LBRecipe implements CraftRecipe {
    public CraftFurnaceRecipe(ItemStack result, Material source) {
        super(result, null);
    }
}
