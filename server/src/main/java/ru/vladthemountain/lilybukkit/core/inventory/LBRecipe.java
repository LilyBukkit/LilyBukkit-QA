package ru.vladthemountain.lilybukkit.core.inventory;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.HashMap;

/**
 * @author VladTheMountain
 */
public class LBRecipe implements Recipe {

    HashMap<Integer, ItemStack> grid;
    ItemStack result;

    public LBRecipe(ItemStack result, HashMap<Integer, ItemStack> items) {
        if (items.size() > 9) throw new IllegalArgumentException("The recipe grid is too large");
        this.grid = items;
        this.result = result;
    }

    /**
     * Get the result of this recipe.
     *
     * @return The result stack
     */
    @Override
    public ItemStack getResult() {
        return this.result;
    }
}
