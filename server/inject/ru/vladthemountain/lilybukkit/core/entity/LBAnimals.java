package ru.vladthemountain.lilybukkit.core.entity;

import net.minecraft.src.EntityAnimal;
import org.bukkit.World;
import org.bukkit.entity.Animals;

/**
 * @author VladTheMountain
 */
public class LBAnimals extends LBCreature implements Animals {

    EntityAnimal entity;

    public LBAnimals(World w, EntityAnimal e) {
        super(w, e);
        this.entity = e;
    }
}
