package org.bukkit.craftbukkit.inventory;

import org.bukkit.inventory.ItemStack;
import ru.vladthemountain.lilybukkit.inventory.LBRecipe;

@Deprecated
public class CraftShapelessRecipe extends LBRecipe implements CraftRecipe {
    public CraftShapelessRecipe(ItemStack result) {
        super(result, null);
    }
}
