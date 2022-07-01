package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityAnimal;
import org.bukkit.entity.Animals;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBAnimals extends LBCreature implements Animals {

    EntityAnimal entity;

    public LBAnimals(LBWorld w,EntityAnimal e) {
        super(w,e);
        this.entity = e;
    }
}
