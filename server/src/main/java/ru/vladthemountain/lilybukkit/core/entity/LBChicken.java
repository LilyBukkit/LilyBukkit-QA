package ru.vladthemountain.lilybukkit.core.entity;

import net.minecraft.src.EntityChicken;
import org.bukkit.World;
import org.bukkit.entity.Chicken;

/**
 * @author VladTheMountain
 */
public class LBChicken extends LBAnimals implements Chicken {

    public LBChicken(World w, EntityChicken e) {
        super(w, e);
    }
}
