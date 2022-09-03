package org.bukkit.craftbukkit.inventory;

import org.bukkit.inventory.ItemStack;
import ru.vladthemountain.lilybukkit.core.inventory.LBRecipe;

@Deprecated
public class CraftShapedRecipe extends LBRecipe implements CraftRecipe {
    public CraftShapedRecipe(ItemStack result) {
        super(result, null);
    }
}
